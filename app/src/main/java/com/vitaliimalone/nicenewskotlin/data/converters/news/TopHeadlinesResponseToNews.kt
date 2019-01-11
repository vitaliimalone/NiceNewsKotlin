package com.vitaliimalone.nicenewskotlin.data.converters.news

import com.vitaliimalone.nicenewskotlin.data.api.response.TopHeadlinesResponse
import com.vitaliimalone.nicenewskotlin.data.converters.Converter
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class TopHeadlinesResponseToNews : Converter<TopHeadlinesResponse, List<News>>() {
    override fun convert(input: TopHeadlinesResponse): List<News> {
        val news: MutableList<News> = mutableListOf()
        for (article in input.articles) {
            news.add(News(
                article.title,
                article.description,
                article.content,
                article.url,
                article.urlToImage,
                article.publishedAt,
                article.author,
                article.source.name
            ))
        }
        return news
    }

    override fun convertBack(output: List<News>): TopHeadlinesResponse {
        throw UnsupportedOperationException()
    }

    fun setCategory(news: List<News>, category: News.Category): List<News> {
        for (item in news) {
            item.category = category
        }
        return news
    }
}