package pl.ejdriansoft.personalwallet.di

import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.SpendDatabase
import pl.ejdriansoft.personalwallet.db.SpendRepository
import pl.ejdriansoft.personalwallet.db.SpendRepositoryImpl
import pl.ejdriansoft.personalwallet.services.provideApiService

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), SpendDatabase::class.java, "spend_db")
            .build()
    }

    single { get<SpendDatabase>().spendDao() }
}

val serviceModule = module {
    single { SpendRepositoryImpl(get()) as SpendRepository }
}

val networkModule = module {

//    single { provideDefaultOkhttpClient() }
//    single { provideRetrofit(get()) }
    single { provideApiService(get()) }

}

val roomTestModule = module {

    single {
        Room.inMemoryDatabaseBuilder(androidApplication(), SpendDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
    single { get<SpendDatabase>().spendDao() }
}

val testContext = listOf(roomTestModule)