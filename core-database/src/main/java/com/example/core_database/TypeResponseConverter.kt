package com.example.core_database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.core_model.MovieDetail
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 23/11/22
 */

@ProvidedTypeConverter
class TypeResponseConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromString(value: String): List<MovieDetail.Genre>? {
        val listType = Types.newParameterizedType(List::class.java, MovieDetail.Genre::class.java)
        val adapter: JsonAdapter<List<MovieDetail.Genre>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromTypeGenre(type: List<MovieDetail.Genre>?): String{
        val listType = Types.newParameterizedType(List::class.java, MovieDetail.Genre::class.java)
        val adapter: JsonAdapter<List<MovieDetail.Genre>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}
