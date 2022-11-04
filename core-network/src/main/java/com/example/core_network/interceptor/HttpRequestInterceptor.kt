package com.example.core_network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Dede Dari Rahmadi on 04/11/22
 */
class HttpRequestInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .header("Content-Type", "application/json;charset=utf-8")
            .url(originalRequest.url).build()
        return chain.proceed(request)
    }

    companion object {
        const val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiNTRhZTgxYjM5OGE1ODkwOTUxYjE0NDlmNjgwYjZlMyIsInN1YiI6IjVmOTU0MWFjNGY5YTk5MDA0MWUwZGJkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.beuA4m4CP4MOA-NmifacoJsyqQlZrGbu-LxZfblefkc"
    }
}