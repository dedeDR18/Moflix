package com.example.core_database.entity.mapper

import com.example.core_database.entity.MovieEntity
import com.example.core_model.Movie

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */
object MovieEntityMapper : EntityMapper<List<Movie>, List<MovieEntity>> {
    override fun asEntity(domain: List<Movie>): List<MovieEntity> {
        return domain.map { movie ->
            MovieEntity(
                id = movie.id,
                originalTitle = movie.original_title,
                posterPath = movie.poster_path ?: "-",
                voteAvarage = movie.vote_average
            )
        }
    }

    override fun asDomain(entity: List<MovieEntity>): List<Movie> {
        return entity.map { movieEntity ->
            Movie(
                id = movieEntity.id,
                original_title = movieEntity.originalTitle,
                poster_path = movieEntity.posterPath,
                vote_average = movieEntity.voteAvarage,
            )
        }
    }
}

fun List<Movie>.asEntity(): List<MovieEntity> {
    return MovieEntityMapper.asEntity(this)
}

fun List<MovieEntity>.asDomain(): List<Movie> {
    return MovieEntityMapper.asDomain(this)
}