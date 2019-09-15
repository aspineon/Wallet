package pl.ejdriansoft.personalwallet

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.ejdriansoft.personalwallet.di.*

class AppSingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppSingleton)
            modules
        }
    }
}
