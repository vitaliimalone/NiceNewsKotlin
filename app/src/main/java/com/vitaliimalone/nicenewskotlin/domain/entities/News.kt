package com.vitaliimalone.nicenewskotlin.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
        val title: String,
        val shortDescription: String?,
        val description: String?,
        @PrimaryKey
        val url: String,
        val urlToImage: String?,
        val publishedAt: String,
        val author: String?,
        val source: String?,
        var category: Category? = null,
        var isFavorite: Boolean = false
) {
    enum class Category {
        BUSINESS, ENTERTAINMENT, GENERAL, HEALTH, SCIENCE, SPORTS, TECHNOLOGY
    }

    fun getHandyDescription(): String? {
        return if (shortDescription.isNullOrBlank()) {
            description
        } else {
            shortDescription
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as News

        if (url != other.url) return false

        return true
    }

    override fun hashCode(): Int {
        return url.hashCode()
    }


}