package com.vitaliimalone.nicenewskotlin.data.api

import com.vitaliimalone.nicenewskotlin.data.api.response.TopHeadlinesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun fetchTopHeadlines(@Query("category") category: String): Deferred<Response<TopHeadlinesResponse>>
}