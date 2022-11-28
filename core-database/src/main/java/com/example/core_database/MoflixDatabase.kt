package com.example.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core_database.entity.MovieDetailEntity
import com.example.core_database.entity.MovieEntity

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */

@Database(
    entities = [MovieEntity::class, MovieDetailEntity::class],
    version = 2,
    exportSchema = true
)

@TypeConverters(value = [TypeResponseConverter::class])
abstract class MoflixDatabase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun movieDetailDao(): MovieDetailDao
}