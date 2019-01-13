package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.domain.entities.News

interface NewsRepository {

    suspend fun getTopHeadlines(category: News.Category): List<News>
}