package com.vitaliimalone.nicenewskotlin.di

import androidx.room.Room
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vitaliimalone.nicenewskotlin.data.database.NiceNewsDatabase
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepository
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryImpl
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryLocal
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryRemote
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
                .build()
    }
    single {
        Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2")
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
    single {
        Room.databaseBuilder(androidContext(), NiceNewsDatabase::class.java, "nice-news-database")
                .fallbackToDestructiveMigration()
                .build()
    }
    single { get<NiceNewsDatabase>().getNews() }
    single { NewsRepositoryRemote(get()) }
    single { NewsRepositoryLocal(get()) }
    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }
    single { NewsInteractor(get()) }
    viewModel { NewsViewModel(get()) }
}
