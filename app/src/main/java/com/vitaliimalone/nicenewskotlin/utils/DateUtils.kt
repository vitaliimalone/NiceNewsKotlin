package com.vitaliimalone.nicenewskotlin.utils

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun formatDate(dateUtc: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = simpleDateFormat.parse(dateUtc)
        return DateFormat.format("dd.MM.yyyy hh:mm", date).toString()
    }
}