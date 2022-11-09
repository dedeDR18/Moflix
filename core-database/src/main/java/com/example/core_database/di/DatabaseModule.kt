package com.example.core_database.di

import android.app.Application
import androidx.room.Room
import com.example.core_database.MoflixDatabase
import com.example.core_database.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): MoflixDatabase {
        return Room
            .databaseBuilder(application, MoflixDatabase::class.java, "moflix.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoflixDao(appDb: MoflixDatabase): MovieDao {
        return appDb.movieDao()
    }
}