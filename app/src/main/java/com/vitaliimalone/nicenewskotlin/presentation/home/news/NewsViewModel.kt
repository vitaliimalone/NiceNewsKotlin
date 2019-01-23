package com.vitaliimalone.nicenewskotlin.presentation.home.news

import androidx.lifecycle.MutableLiveData
import com.vitaliimalone.nicenewskotlin.domain.Result
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseViewModel
import com.vitaliimalone.nicenewskotlin.presentation.home.news.common.NewsAdapter
import kotlinx.coroutines.launch

class NewsViewModel(
        private val newsInteractor: NewsInteractor
) : BaseViewModel(), NewsAdapter.NewsItemClickListener {
    val news: MutableLiveData<List<News>> by lazy { MutableLiveData<List<News>>() }
    val toast: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val favoriteUpdate: MutableLiveData<News> by lazy { MutableLiveData<News>() }

    fun loadNews(category: News.Category) {
        uiScope.launch {
            val result = newsInteractor.getTopHeadlines(category)
            when (result) {
                is Result.Success -> {
                    news.value = result.data
                }
                is Result.Error -> {
                    toast.value = result.exception.message
                }
            }
        }
    }

    override fun onNewsClick(news: News) {

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
