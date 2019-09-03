package pl.ejdriansoft.personalwallet.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.db.SpendRepository
import pl.ejdriansoft.personalwallet.db.SpendRepositoryImpl
import pl.ejdriansoft.personalwallet.services.provideApiService
import pl.ejdriansoft.personalwallet.services.provideDefaultOkhttpClient
import pl.ejdriansoft.personalwallet.services.provideRetrofit


val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), SpendDatabase::class.java, "weather-db")
            .build()
    }

    single { get<SpendDatabase>().spendDao() }
}

val serviceModule = module {
    single { SpendRepositoryImpl(get()) as SpendRepository }

}

val networkModule = module {

    single { provideDefaultOkhttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }

}

val roomTestModule = module {
    single {
        Room.inMemoryDatabaseBuilder(get(), SpendDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}