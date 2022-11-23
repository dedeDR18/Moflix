package com.example.core_model

import android.os.Parcelable
import android.provider.MediaStore.Audio.Genres
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */

@JsonClass(generateAdapter = true)
data class MovieDetail(
    @field:Json(name = "adult") val adult: Boolean?,
    @field:Json(name = "backdrop_path") val backdrop_path: String?,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "original_language") val original_language: String?,
    @field:Json(name = "original_title") val original_title: String,
    @field:Json(name = "overview") val overview: String?,
    @field:Json(name = "popularity") val popularity: Double?,
    @field:Json(name = "poster_path") val poster_path: String?,
    @field:Json(name = "release_date") val release_date: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "video") val video: Boolean?,
    @field:Json(name = "vote_average") val vote_average: Double,
    @field:Json(name = "vote_count") val vote_count: Int?,
    @field:Json(name = "genres") val genres: List<Genre>
) {

    @JsonClass(generateAdapter = true)
    data class Genre(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "name") val name: String?
    )
}