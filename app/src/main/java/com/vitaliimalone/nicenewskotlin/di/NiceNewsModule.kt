package com.vitaliimalone.nicenewskotlin.di

import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepository
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryImpl
import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class NiceNewsModule {
    private val newsModule = module {
        single<NewsRepository> { NewsRepositoryImpl() }
        viewModel<NewsViewModel>()
    }

    fun getModuleList(): List<Module> {
        return listOf(newsModule)
    }
}