package com.vitaliimalone.nicenewskotlin.presentation.home

import com.vitaliimalone.nicenewskotlin.presentation.MainRouter
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseViewModel

class HomeViewModel(private val mainRouter: MainRouter) : BaseViewModel() {
    fun onFavoritesMenuClick() {
        mainRouter.navigateToFavorites()
    }

    fun onSettingsMenuClick() {
        mainRouter.navigateToSettings()
    }
}
