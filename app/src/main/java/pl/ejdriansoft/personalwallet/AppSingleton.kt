package pl.ejdriansoft.personalwallet

import android.app.Application
import pl.ejdriansoft.personalwallet.di.DependencyInjector

class AppSingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyInjector.initialize(applicationContext)
    }

}
