package com.example.core_data.di

import com.example.core_data.repository.MainRepository
import com.example.core_data.repository.MainRepositoryImpl
import com.example.core_data.repository.MovieDetailRepository
import com.example.core_data.repository.MovieDetailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Dede Dari Rahmadi on 09/11/22
 */

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository

    @Binds
    fun bindMovieDetailRepository(
        movieDetailRepositoryImpl: MovieDetailRepositoryImpl
    ): MovieDetailRepository
}