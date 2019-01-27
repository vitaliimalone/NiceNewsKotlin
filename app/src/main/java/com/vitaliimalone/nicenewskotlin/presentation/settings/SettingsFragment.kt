package com.vitaliimalone.nicenewskotlin.presentation.settings

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.vitaliimalone.nicenewskotlin.R

class SettingsFragment : PreferenceFragmentCompat() {
    private val countryPreference by lazy {
        findPreference(getString(R.string.settings_country_key)) as ListPreference
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_fragment, rootKey)
        setupListeners()
        setupSummaries()
    }

    private fun setupListeners() {
        countryPreference.setOnPreferenceChangeListener { _, newValue ->
            countryPreference.summary = countryPreference.entries[countryPreference.findIndexOfValue(newValue as String)]
            true
        }
    }

    private fun setupSummaries() {
        countryPreference.summary = countryPreference.entry
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}
