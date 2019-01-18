package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.data.database.news.NewsDao
import com.vitaliimalone.nicenewskotlin.data.repository.common.BaseRepositoryLocal
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryLocal(private val newsDao: NewsDao) : BaseRepositoryLocal() {
    suspend fun storeNews(news: List<News>) {
        return withContext(Dispatchers.IO) {
            newsDao.deleteAll()
            newsDao.insertAll(news)
        }
    }

    suspend fun getNews(category: News.Category): List<News> {
        return withContext(Dispatchers.IO) {
            newsDao.getAllByCategory(category)
        }
    }
}
