package com.vitaliimalone.nicenewskotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.home.HomeFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(mainActivityContainer.id, HomeFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }
}
