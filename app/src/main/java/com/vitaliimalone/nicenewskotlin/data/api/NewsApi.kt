package com.vitaliimalone.nicenewskotlin.data.api

import com.vitaliimalone.nicenewskotlin.data.api.response.TopHeadlinesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun fetchTopHeadlines(@Query("category") category: String): Call<TopHeadlinesResponse>
}