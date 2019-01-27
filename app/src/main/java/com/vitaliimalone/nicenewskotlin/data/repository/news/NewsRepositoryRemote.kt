package com.vitaliimalone.nicenewskotlin.data.repository.news

import com.vitaliimalone.nicenewskotlin.data.RetrofitException
import com.vitaliimalone.nicenewskotlin.data.api.NewsApi
import com.vitaliimalone.nicenewskotlin.data.converters.news.TopHeadlinesResponseToNews
import com.vitaliimalone.nicenewskotlin.domain.entities.News
import retrofit2.HttpException
import retrofit2.Retrofit

class NewsRepositoryRemote(private val retrofit: Retrofit) {
    var newsApi: NewsApi = retrofit.create(NewsApi::class.java)

    suspend fun fetchTopHeadlines(category: News.Category, country: String): List<News> {
        try {
            val response = newsApi.fetchTopHeadlines(category.name, country).await()
            if (!response.isSuccessful) throw HttpException(response)
            val topHeadlinesResponse = response.body()
            val converter = TopHeadlinesResponseToNews()
            var newsList = converter.convert(topHeadlinesResponse!!)
            newsList = converter.setCategory(newsList, category)
            return newsList
        } catch (e: Exception) {
            throw RetrofitException.asRetrofitException(e, retrofit)
        }
    }
}