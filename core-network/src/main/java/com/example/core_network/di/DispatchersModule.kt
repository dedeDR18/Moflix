package com.example.core_network.di

import com.example.core_network.Dispatcher
import com.example.core_network.TmdbAppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Dede Dari Rahmadi on 05/11/22
 */

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Dispatcher(TmdbAppDispatchers.IO)
    fun provideIODispatchers(): CoroutineDispatcher = Dispatchers.IO
}