package com.vitaliimalone.nicenewskotlin.presentation.favorites

import androidx.lifecycle.MutableLiveData
import com.vitaliimalone.nicenewskotlin.domain.Result
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.MainRouter
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseViewModel
import com.vitaliimalone.nicenewskotlin.presentation.favorites.common.FavoritesAdapter
import kotlinx.coroutines.launch

class FavoritesViewModel(
        private val newsInteractor: NewsInteractor,
        private val mainRouter: MainRouter
) : BaseViewModel(), FavoritesAdapter.FavoritesClickListener {
    val favorites: MutableLiveData<List<News>> by lazy { MutableLiveData<List<News>>() }
    val favoriteUpdate: MutableLiveData<News> by lazy { MutableLiveData<News>() }
    val toast: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun loadFavorites() {

    }

    override fun onNewsClick(news: News) {
        mainRouter.navigateToNews(news.url)
    }

    override fun onFavoriteClick(news: News) {
        uiScope.launch {
            news.isFavorite = !news.isFavorite
            val result = newsInteractor.updateNews(news)
            when (result) {
                is Result.Success -> {
                    favoriteUpdate.value = news
                }
                is Result.Error -> {
                    toast.value = result.exception.message
                }
            }
        }
    }

}
