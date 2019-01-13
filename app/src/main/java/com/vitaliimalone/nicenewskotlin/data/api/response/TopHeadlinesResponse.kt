package com.vitaliimalone.nicenewskotlin.data.api.response

data class TopHeadlinesResponse(
        val status: String,
        val totalResults: Int,
        val articles: List<ArticleResponse>
)

data class ArticleResponse(
        val source: SourceResponse,
        val author: String?,
        val title: String,
        val description: String?,
        val url: String,
        val urlToImage: String?,
        val publishedAt: String,
        val content: String?
)

data class SourceResponse(
        val id: String?,
        val name: String?
)
