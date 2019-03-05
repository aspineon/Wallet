package pl.ejdriansoft.personalwallet.di

import android.content.Context
import dagger.Component
import pl.ejdriansoft.personalwallet.MainActivity
import javax.inject.Singleton


@Component(modules = [AppModule::class, ServicesModule::class])
@Singleton
interface AppComponent {
    fun inject(context: Context)

//    fun inject(service: AgenDialerApi)
//    fun inject(service: FcmPushService)
//    fun inject(service: Prefs)
//    fun inject(service: LocationService)
//    fun inject(service: CellularNetworkService)

    fun inject(activity: MainActivity)
//    fun inject(activity: PermissionsActivity)
//
//    fun inject(fragment: HistoryFragment)
//    fun inject(fragment: TaskFragment)
//    fun inject(fragment: LoginFragment)
//    fun inject(fragment: FavoriteFragment)
//    fun inject(fragment: WorkFragment)
//    fun inject(fragment: ContactsFragment)
//    fun inject(fragment: InfoCardFragment)
//
//    fun inject(adapter: ContactsAdapter)
//    fun inject(adapter: TaskAdapter)
//    fun inject(adapter: PagerAdapter)
//    fun inject(adapter: PagerAdapterLogin)
//    fun inject(adapter: HistoryCallAdapter)
//    fun inject(adapter: HistoryLocalCallAdapter)
}