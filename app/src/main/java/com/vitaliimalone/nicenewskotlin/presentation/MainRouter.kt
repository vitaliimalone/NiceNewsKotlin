package com.vitaliimalone.nicenewskotlin.presentation

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.favorites.FavoritesFragment
import com.vitaliimalone.nicenewskotlin.presentation.home.HomeFragment
import com.vitaliimalone.nicenewskotlin.presentation.settings.SettingsContainerFragment
import com.vitaliimalone.nicenewskotlin.utils.replaceWithBackStack
import com.vitaliimalone.nicenewskotlin.utils.replaceWithoutBackStack
import kotlinx.android.synthetic.main.main_activity.*

class MainRouter(private val mainActivity: MainActivity) {
    fun navigateToNewsViewPager() {
        mainActivity.replaceWithoutBackStack(mainActivity.mainActivityContainer.id, HomeFragment.newInstance())
    }

    fun navigateToSettings() {
        mainActivity.replaceWithBackStack(mainActivity.mainActivityContainer.id, SettingsContainerFragment.newInstance())
    }

    fun navigateToFavorites() {
        mainActivity.replaceWithBackStack(mainActivity.mainActivityContainer.id, FavoritesFragment.newInstance())
    }

    fun navigateToNews(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .setToolbarColor(ContextCompat.getColor(mainActivity, R.color.purple))
                .build()
        customTabsIntent.launchUrl(mainActivity, Uri.parse(url))
    }
}