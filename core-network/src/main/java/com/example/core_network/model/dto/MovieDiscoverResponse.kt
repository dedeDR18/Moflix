package com.example.core_network.model.dto

import com.example.core_model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDiscoverResponse(
    @field:Json(name = "page") val page: Int,
    @field:Json(name = "results") val results: List<Movie>,
    @field:Json(name = "total_pages") val total_pages: Int,
    @field:Json(name = "total_results") val total_results: Int
)