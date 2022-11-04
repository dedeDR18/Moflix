package com.example.core_network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Dede Dari Rahmadi on 04/11/22
 */
class HttpRequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        return chain.proceed(request)
    }
}