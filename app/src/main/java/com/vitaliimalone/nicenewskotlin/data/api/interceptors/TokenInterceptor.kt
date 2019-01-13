package com.vitaliimalone.nicenewskotlin.data.api.interceptors

import com.vitaliimalone.nicenewskotlin.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
                .header("Authorization", "Bearer ${BuildConfig.API_KEY}")
                .build()
        return chain.proceed(request)
    }
}