package com.vitaliimalone.nicenewskotlin.presentation.settings

import android.os.Bundle
import com.vitaliimalone.nicenewskotlin.R
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseFragment
import com.vitaliimalone.nicenewskotlin.utils.replaceWithoutBackStack
import kotlinx.android.synthetic.main.settings_container_fragment.*

class SettingsContainerFragment: BaseFragment() {
    override fun getLayoutRes(): Int = R.layout.settings_container_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState ?: replaceWithoutBackStack(settingsContainer.id, SettingsFragment.newInstance())
        settingsToolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    companion object {
        fun newInstance() = SettingsContainerFragment()
    }
}