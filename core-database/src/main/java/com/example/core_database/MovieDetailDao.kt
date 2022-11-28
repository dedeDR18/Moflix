package com.example.core_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.entity.MovieDetailEntity
import com.example.core_model.MovieDetail

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */
@Dao
interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movie: MovieDetailEntity)

    @Query("SELECT * FROM MovieDetailEntity WHERE id = :idMovie")
    suspend fun getMovieDetail(idMovie: Int): MovieDetailEntity?

}