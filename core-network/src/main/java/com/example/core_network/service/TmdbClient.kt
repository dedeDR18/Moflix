package com.example.core_network.service

import com.example.core_model.MovieDetail
import com.example.core_network.model.dto.MovieDiscoverResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 05/11/22
 */
class TmdbClient @Inject constructor(private val tmdbService: TmdbService) {

    suspend fun fetchDiscoverMovie(page: Int) :ApiResponse<MovieDiscoverResponse> =
        tmdbService.fetchDiscoverMovie(page = page)

    suspend fun fetchMovieDetail(idMovie: Int): ApiResponse<MovieDetail> = tmdbService.fetchMovieDetail(idMovie = idMovie)
}