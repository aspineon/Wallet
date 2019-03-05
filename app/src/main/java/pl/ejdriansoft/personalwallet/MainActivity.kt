package pl.ejdriansoft.personalwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.ejdriansoft.personalwallet.di.DependencyInjector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DependencyInjector.instance.inject(this)

    }
}
