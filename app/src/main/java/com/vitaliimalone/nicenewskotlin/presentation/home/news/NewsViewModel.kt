package com.vitaliimalone.nicenewskotlin.presentation.home.news

import androidx.lifecycle.MutableLiveData
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseViewModel
import kotlinx.coroutines.launch

class NewsViewModel(
        private val newsInteractor: NewsInteractor
) : BaseViewModel() {
    val news: MutableLiveData<List<News>> by lazy { MutableLiveData<List<News>>() }

    fun loadNews() {
        uiScope.launch {
            news.value = newsInteractor.getTopHeadlines(News.Category.BUSINESS)
        }
    }
}
