package com.vitaliimalone.nicenewskotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vitaliimalone.nicenewskotlin.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    private val mainRouter: MainRouter by inject { parametersOf(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        savedInstanceState ?: mainRouter.navigateToNewsViewPager()
    }
}
