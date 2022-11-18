package com.example.core_network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Dede Dari Rahmadi on 04/11/22
 */
class HttpRequestInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        return chain.proceed(originalRequest)
    }

    companion object {
        const val apikey = "b54ae81b398a5890951b1449f680b6e3"
        const val token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiNTRhZTgxYjM5OGE1ODkwOTUxYjE0NDlmNjgwYjZlMyIsInN1YiI6IjVmOTU0MWFjNGY5YTk5MDA0MWUwZGJkYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.beuA4m4CP4MOA-NmifacoJsyqQlZrGbu-LxZfblefkc"
    }
}