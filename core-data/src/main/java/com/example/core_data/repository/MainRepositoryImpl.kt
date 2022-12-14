package com.example.core_data.repository

import android.util.Log
import com.example.core_database.MovieDao
import com.example.core_database.entity.mapper.asDomain
import com.example.core_database.entity.mapper.asEntity
import com.example.core_model.Movie
import com.example.core_network.Dispatcher
import com.example.core_network.TmdbAppDispatchers
import com.example.core_network.service.TmdbClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 09/11/22
 */
class MainRepositoryImpl @Inject constructor(
    private val tmdbClient: TmdbClient,
    private val movieDao: MovieDao,
    @Dispatcher(TmdbAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : MainRepository {
    override fun fetchDiscoverMovie(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        var movies = movieDao.getDiscoverMovieList(page).asDomain()
        if (movies.isEmpty()) {
            val response = tmdbClient.fetchDiscoverMovie(page)
            response.suspendOnSuccess {
                movies = data.results
                movies.forEach { movie ->
                    movie.page = page
                }
                movieDao.insertMovie(movies.asEntity())
                emit(movieDao.getAllDiscoverMovie(page).asDomain())


            }.onFailure {
                // handles the all error cases from the API request fails.
                onError(message())
            }
        } else {
            emit(movieDao.getAllDiscoverMovie(page).asDomain())

        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)

}