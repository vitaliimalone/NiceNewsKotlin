package com.vitaliimalone.nicenewskotlin.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
        val title: String,
        val shortDescription: String,
        val description: String,
        @PrimaryKey
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val author: String,
        val source: String,
        var category: Category? = null
) {
    enum class Category {
        BUSINESS, ENTERTAINMENT, GENERAL, HEALTH, SCIENCE, SPORTS, TECHNOLOGY
    }
}