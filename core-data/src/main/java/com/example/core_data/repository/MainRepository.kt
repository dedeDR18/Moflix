package com.example.core_data.repository

import androidx.annotation.WorkerThread
import com.example.core_model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dede Dari Rahmadi on 09/11/22
 */
interface MainRepository {

    @WorkerThread
    fun fetchDiscoverMovie(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Movie>>
}