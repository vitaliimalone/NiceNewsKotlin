package com.vitaliimalone.nicenewskotlin.data.api.response

data class TopHeadlinesResponse(
        val status: String,
        val totalResults: Int,
        val articles: List<ArticleResponse>
)