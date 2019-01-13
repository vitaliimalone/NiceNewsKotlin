package com.vitaliimalone.nicenewskotlin.data.repository.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

abstract class BaseRepositoryLocal {
    // FIXME: workaround until Room 2.1.0-alpha04 is released
    // FIXME: https://issuetracker.google.com/issues/120227284
    internal suspend fun accessData(queries: () -> Unit) {
        coroutineScope {
            withContext(Dispatchers.IO) {
                queries
            }
        }
    }
}