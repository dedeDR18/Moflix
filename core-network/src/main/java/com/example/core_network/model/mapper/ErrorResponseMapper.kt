package com.example.core_network.model.mapper

import com.example.core_network.model.dto.MovieDiscoverErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

/**
 * Created by Dede Dari Rahmadi on 03/11/22
 */
object ErrorResponseMapper : ApiErrorModelMapper<MovieDiscoverErrorResponse> {
    override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): MovieDiscoverErrorResponse {
        return MovieDiscoverErrorResponse(
            apiErrorResponse.statusCode.code, apiErrorResponse.message()
        )
    }
}