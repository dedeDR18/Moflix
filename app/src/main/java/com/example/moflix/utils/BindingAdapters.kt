package com.example.moflix.utils

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.moflix.R

/**
 * Created by Dede Dari Rahmadi on 17/11/22
 */
object BindingAdapters {

    const val BASE_URL_POSTER = "https://image.tmdb.org/t/p/w780/"

    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(iv: AppCompatImageView, url: String?){
        url?.let {
            Log.d("MAIN", "url = $url")
            Glide.with(iv.context)
                .load(BASE_URL_POSTER+it)
                .placeholder(R.drawable.ic_image)
                .into(iv)
        }

    }
}