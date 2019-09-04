package pl.ejdriansoft.personalwallet

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.ejdriansoft.personalwallet.di.databaseModule
import pl.ejdriansoft.personalwallet.di.networkModule
import pl.ejdriansoft.personalwallet.di.roomTestModule
import pl.ejdriansoft.personalwallet.di.serviceModule

class AppSingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppSingleton)
            listOf(databaseModule, serviceModule, networkModule, roomTestModule)
        }
    }
}
