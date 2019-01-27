package com.vitaliimalone.nicenewskotlin.di

import androidx.room.Room
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vitaliimalone.nicenewskotlin.BuildConfig
import com.vitaliimalone.nicenewskotlin.data.api.interceptors.TokenAuthenticator
import com.vitaliimalone.nicenewskotlin.data.api.interceptors.TokenInterceptor
import com.vitaliimalone.nicenewskotlin.data.database.NiceNewsDatabase
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepository
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryImpl
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryLocal
import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepositoryRemote
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.MainActivity
import com.vitaliimalone.nicenewskotlin.presentation.MainRouter
import com.vitaliimalone.nicenewskotlin.presentation.home.HomeViewModel
import com.vitaliimalone.nicenewskotlin.presentation.home.news.NewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { GsonBuilder().create() }
    single {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        builder.addInterceptor(TokenInterceptor())
        builder.authenticator(TokenAuthenticator())
        builder.build()
    }
    single {
        Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}
val dataModule = module {
    single {
        Room.databaseBuilder(androidContext(), NiceNewsDatabase::class.java,
                BuildConfig.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
    single { get<NiceNewsDatabase>().getNews() }
    single { NewsRepositoryRemote(get()) }
    single { NewsRepositoryLocal(get()) }
    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }
}
val domainModule = module {
    single { NewsInteractor(get()) }
}
val presentationModule = module {
    // https://github.com/InsertKoinIO/koin/issues/49#issuecomment-414443350
    single { (activity: MainActivity) -> MainRouter(activity) }
    viewModel { NewsViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}
val appModule = listOf(networkModule, dataModule, domainModule, presentationModule)