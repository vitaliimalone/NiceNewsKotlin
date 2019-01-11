package com.vitaliimalone.nicenewskotlin.data.database

import androidx.room.TypeConverter
import com.vitaliimalone.nicenewskotlin.domain.entities.News

class NiceNewsTypeConverters {
    @TypeConverter
    fun newsCategoryToString(category: News.Category): String {
        return category.name
    }

    @TypeConverter
    fun newsStringToCategory(category: String): News.Category {
        return News.Category.valueOf(category)
    }
}