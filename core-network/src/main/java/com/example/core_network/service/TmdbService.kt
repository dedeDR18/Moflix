package com.example.core_network.service

import com.example.core_model.MovieDetail
import com.example.core_network.model.dto.MovieDiscoverResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Dede Dari Rahmadi on 05/11/22
 */
interface TmdbService {

    @GET("discover/movie?api_key=b54ae81b398a5890951b1449f680b6e3&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&with_watch_monetization_types=flatrate")
    suspend fun fetchDiscoverMovie(
        @Query("page") page: Int = 1
    ): ApiResponse<MovieDiscoverResponse>

    @GET("movie/{idMovie}?api_key=b54ae81b398a5890951b1449f680b6e3&language=en-US")
    suspend fun fetchMovieDetail(
        @Path("idMovie") idMovie: Int
    ): ApiResponse<MovieDetail>

}