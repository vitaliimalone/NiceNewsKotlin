package com.vitaliimalone.nicenewskotlin.di

import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class NiceNewsModule {
    private val newsModule = module {
        viewModel { NewsViewModel() }
    }

    fun getModuleList(): List<Module> {
        return listOf(newsModule)
    }
}