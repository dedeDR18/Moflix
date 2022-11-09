package com.example.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database.entity.MovieEntity

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = true
)
abstract class MoflixDatabase: RoomDatabase(){
    abstract fun movieDao(): MovieDao
}