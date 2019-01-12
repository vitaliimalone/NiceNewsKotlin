package com.vitaliimalone.nicenewskotlin.domain.interactors

import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepository
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsInteractor(private val newsRepository: NewsRepository) {
    fun getTopHeadlines(category: News.Category): List<News> {
        return newsRepository.getTopHeadlines(category)
    }
}