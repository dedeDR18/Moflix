package com.example.moflix.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core_model.Movie
import com.example.moflix.R
import com.example.moflix.databinding.ItemMovieBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

/**
 * Created by Dede Dari Rahmadi on 17/11/22
 */

class MovieAdapter : BindingListAdapter<Movie, MovieAdapter.MovieViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        parent.binding<ItemMovieBinding>(R.layout.item_movie).let(::MovieViewHolder)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bindMovie(getItem(position))

    inner class MovieViewHolder constructor(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindMovie(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Movie>() {

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.original_title == newItem.original_title

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }

}