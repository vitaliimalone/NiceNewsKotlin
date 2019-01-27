package com.vitaliimalone.nicenewskotlin.presentation.home

import androidx.lifecycle.ViewModel
import com.vitaliimalone.nicenewskotlin.presentation.MainRouter

class HomeViewModel(private val mainRouter: MainRouter) : ViewModel() {
    fun onFavoritesMenuClick() {
        mainRouter.navigateToFavorites()
    }

    fun onSettingsMenuClick() {
        mainRouter.navigateToSettings()
    }
}
