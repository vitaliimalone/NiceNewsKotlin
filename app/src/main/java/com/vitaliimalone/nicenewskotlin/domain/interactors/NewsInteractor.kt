package com.vitaliimalone.nicenewskotlin.domain.interactors

import com.vitaliimalone.nicenewskotlin.data.repository.news.NewsRepository
import com.vitaliimalone.nicenewskotlin.domain.Result
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NewsInteractor(private val newsRepository: NewsRepository) {
    suspend fun getTopHeadlines(category: News.Category): Result<List<News>> {
        return try {
            Result.Success(newsRepository.getTopHeadlines(category))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}