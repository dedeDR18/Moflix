package com.example.core_database.di

import android.app.Application
import androidx.room.ProvidedTypeConverter
import androidx.room.Room
import com.example.core_database.MoflixDatabase
import com.example.core_database.MovieDao
import com.example.core_database.MovieDetailDao
import com.example.core_database.TypeResponseConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    fun provideMoshi(): Moshi{
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        typeResponseConverter: TypeResponseConverter
    ): MoflixDatabase {
        return Room
            .databaseBuilder(application, MoflixDatabase::class.java, "moflix.db")
            .fallbackToDestructiveMigration()
            .addTypeConverter(typeResponseConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoflixDao(appDb: MoflixDatabase): MovieDao {
        return appDb.movieDao()
    }

    @Provides
    @Singleton
    fun provideMovieDetailDao(appDb: MoflixDatabase): MovieDetailDao {
        return appDb.movieDetailDao()
    }

    @Provides
    @Singleton
    fun provideTypeResponseConverter(moshi: Moshi): TypeResponseConverter {
        return TypeResponseConverter(moshi)
    }
}