package pl.ejdriansoft.personalwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import pl.ejdriansoft.personalwallet.services.ServiceApi
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val api: ServiceApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BuildConfig.DEBUG) {
            // TODO: crashliticys
        }
        api.all()
    }
}
