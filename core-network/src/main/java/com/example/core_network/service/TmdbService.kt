package com.example.core_network.service

import com.example.core_network.model.dto.MovieDiscoverResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Dede Dari Rahmadi on 05/11/22
 */
interface TmdbService {

    @GET("discover/movies?language=en-US")
    suspend fun fetchDiscoverMovie(
        @Query("page") page: Int = 1
    ): ApiResponse<MovieDiscoverResponse>
}