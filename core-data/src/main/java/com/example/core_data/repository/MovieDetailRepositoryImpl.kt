package com.example.core_data.repository

import com.example.core_database.MovieDetailDao
import com.example.core_database.entity.mapper.asDomain
import com.example.core_database.entity.mapper.asEntity
import com.example.core_model.MovieDetail
import com.example.core_network.Dispatcher
import com.example.core_network.TmdbAppDispatchers
import com.example.core_network.model.mapper.ErrorResponseMapper
import com.example.core_network.service.TmdbClient
import com.skydoves.sandwich.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */

class MovieDetailRepositoryImpl @Inject constructor(
    private val tmdbClient: TmdbClient,
    private val movieDetailDao: MovieDetailDao,
    @Dispatcher(TmdbAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : MovieDetailRepository {
    override fun fetchMovieDetail(
        idMovie: Int,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<MovieDetail> =
        flow {
            val movie = movieDetailDao.getMovieDetail(idMovie)
            if (movie == null) {
                val response = tmdbClient.fetchMovieDetail(idMovie = idMovie)
                response.suspendOnSuccess {
                    movieDetailDao.insertMovieDetail(data.asEntity())
                    emit(data)
                }
                    // handles the case when the API request gets an error response.
                    // e.g., internal server error.
                    .onError {
                        map(ErrorResponseMapper) { onError("[Code: $code]: $message")}
                    }
                    // handles the case when the API request gets an exception response.
                    // e.g., network connection error.
                    .onException {
                        onError(message)
                    }
            } else {
                emit(movie.asDomain())
            }
        }.onCompletion { onComplete }.flowOn(ioDispatcher)

}