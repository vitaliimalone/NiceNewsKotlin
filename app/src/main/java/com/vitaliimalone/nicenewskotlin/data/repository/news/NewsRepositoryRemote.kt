package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.data.api.NewsApi
import com.vitaliimalone.nicenewskotlin.data.converters.news.TopHeadlinesResponseToNews
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import retrofit2.Retrofit

class NewsRepositoryRemote(retrofit: Retrofit) {
    var newsApi: NewsApi = retrofit.create(NewsApi::class.java)

    fun fetchTopHeadlines(category: News.Category): List<News> {
        val response = newsApi.fetchTopHeadlines(category.name).execute()
        val topHeadlinesResponse = response.body()
        val converter = TopHeadlinesResponseToNews()
        var newsList = converter.convert(topHeadlinesResponse!!)
        newsList = converter.setCategory(newsList, category)
        return newsList
    }
}