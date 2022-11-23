package com.example.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core_model.MovieDetail
import com.squareup.moshi.Json

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */
@Entity
data class MovieDetailEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val genres: List<MovieDetail.Genre>

)
