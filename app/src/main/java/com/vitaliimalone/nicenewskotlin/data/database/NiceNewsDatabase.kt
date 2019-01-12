package com.vitaliimalone.nicenewskotlin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vitaliimalone.nicenewskotlin.data.database.news.NewsDao
import com.vitaliimalone.nicenewskotlin.domain.entities.News

@Database(entities = [News::class], version = 1, exportSchema = false)
@TypeConverters(NiceNewsTypeConverters::class)
abstract class NiceNewsDatabase : RoomDatabase() {
    abstract fun getNews(): NewsDao
}