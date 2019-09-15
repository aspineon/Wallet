package pl.ejdriansoft.personalwallet.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.services.api.provideApiService
import pl.ejdriansoft.personalwallet.services.api.provideDefaultOkhttpClient
import pl.ejdriansoft.personalwallet.services.api.provideRetrofit
import pl.ejdriansoft.personalwallet.services.repositories.SpendRepository
import pl.ejdriansoft.personalwallet.services.repositories.TagRepository
import pl.ejdriansoft.personalwallet.ui.spends.SpendViewModel
import pl.ejdriansoft.personalwallet.ui.tags.add.TagViewModel

val modules = module {

    single { provideDefaultOkhttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }

    single {
        Room.databaseBuilder(androidApplication(), SpendDatabase::class.java, "spend_db")
            .build()
    }
    single { get<SpendDatabase>().spendDao() }
    single { get<SpendDatabase>().tagDao() }
    single { get<SpendDatabase>().tagMapDao() }

    single { SpendRepository(get(), get()) }
    single { TagRepository(get()) }

    viewModel { TagViewModel(get()) }
    viewModel { SpendViewModel(get()) }

}
