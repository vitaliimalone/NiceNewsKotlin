package com.vitaliimalone.nicenewskotlin.data.database.news

import androidx.room.*
import com.vitaliimalone.nicenewskotlin.domain.entities.News

@Dao
interface NewsDao {
    @Query("SELECT * FROM news WHERE category = :category")
    fun getAllByCategory(category: News.Category): List<News>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(news: List<News>)

    @Query("DELETE FROM news WHERE isFavorite = 0")
    fun deleteAllNonFavorite()

    @Query("DELETE FROM news WHERE category = :category")
    fun deleteAllByCategory(category: News.Category)

    @Update
    fun updateNews(news: News)

    @Query("SELECT * FROM news WHERE isFavorite = 1")
    fun getFavorites(): List<News>
}