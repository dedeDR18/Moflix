package com.example.core_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.entity.MovieEntity

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */

@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieEntity WHERE page = :page_")
    suspend fun getAllDiscoverMovie(page_: Int): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieList: List<MovieEntity>)
}