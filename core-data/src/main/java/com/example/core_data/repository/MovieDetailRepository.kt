package com.example.core_data.repository

import androidx.annotation.WorkerThread
import com.example.core_model.MovieDetail
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */
interface MovieDetailRepository {

    @WorkerThread
    fun fetchMovieDetail(
        idMovie: Int,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<MovieDetail>
}