package pl.ejdriansoft.personalwallet.di

import android.content.Context


class DependencyInjector {
    companion object {
        lateinit var instance: AppComponent private set
        fun initialize(context: Context){
            instance = DaggerAppComponent
                .builder()
                .appModule(AppModule(context))
                .servicesModule(ServicesModule())
                .build()
            instance.inject(context)
        }
    }
}