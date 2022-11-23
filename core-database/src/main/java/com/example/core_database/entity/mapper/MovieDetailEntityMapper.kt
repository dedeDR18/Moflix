package com.example.core_database.entity.mapper

import com.example.core_database.entity.MovieDetailEntity
import com.example.core_model.MovieDetail

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */

object MovieDetailEntityMapper : EntityMapper<MovieDetail, MovieDetailEntity>{
    override fun asEntity(domain: MovieDetail): MovieDetailEntity {
        return MovieDetailEntity(
            id = domain.id,
            adult = domain.adult,
            backdrop_path = domain.backdrop_path,
            original_title = domain.original_title,
            original_language = domain.original_language,
            overview = domain.overview,
            poster_path = domain.poster_path,
            popularity = domain.popularity,
            release_date = domain.release_date,
            title = domain.title,
            video = domain.video,
            vote_average = domain.vote_average,
            vote_count = domain.vote_count,
            genres = domain.genres
        )
    }

    override fun asDomain(entity: MovieDetailEntity): MovieDetail {
        return MovieDetail(
            id = entity.id,
            adult = entity.adult,
            backdrop_path = entity.backdrop_path,
            original_title = entity.original_title,
            original_language = entity.original_language,
            overview = entity.overview,
            poster_path = entity.poster_path,
            popularity = entity.popularity,
            release_date = entity.release_date,
            title = entity.title,
            video = entity.video,
            vote_average = entity.vote_average,
            vote_count = entity.vote_count,
            genres = entity.genres
        )
    }
}

fun MovieDetail.asEntity(): MovieDetailEntity {
    return MovieDetailEntityMapper.asEntity(this)
}

fun MovieDetailEntity.asDomain(): MovieDetail {
    return MovieDetailEntityMapper.asDomain(this)
}