package com.example.core_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */
@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    var page: Int = 0,
    val originalTitle: String,
    val posterPath: String,
    val voteAvarage: Double
)
