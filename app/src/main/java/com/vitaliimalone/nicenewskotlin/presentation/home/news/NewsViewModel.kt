package com.vitaliimalone.nicenewskotlin.presentation.home.news

import androidx.lifecycle.MutableLiveData
import com.vitaliimalone.nicenewskotlin.domain.Result
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import com.vitaliimalone.nicenewskotlin.domain.interactors.NewsInteractor
import com.vitaliimalone.nicenewskotlin.presentation.common.BaseViewModel
import kotlinx.coroutines.launch

class NewsViewModel(
        private val newsInteractor: NewsInteractor
) : BaseViewModel() {
    val news: MutableLiveData<List<News>> by lazy { MutableLiveData<List<News>>() }
    val toast: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun loadNews() {
        uiScope.launch {
            val result = newsInteractor.getTopHeadlines(News.Category.BUSINESS)
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
}
