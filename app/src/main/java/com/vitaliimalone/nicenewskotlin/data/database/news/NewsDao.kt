package com.vitaliimalone.nicenewskotlin.data.database.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vitaliimalone.nicenewskotlin.domain.entities.News

@Dao
interface NewsDao {
    @Query("SELECT * FROM news WHERE category IS :category")
    fun getAllByCategory(category: News.Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(news: List<News>)

    @Query("DELETE FROM news")
    fun deleteAll()

    @Query("DELETE FROM news WHERE category IS :category")
    fun deleteAllByCategory(category: News.Category)
}