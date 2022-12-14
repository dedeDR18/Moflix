package com.example.moflix.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import com.example.core_model.Movie
import com.example.core_model.MovieDetail
import com.example.moflix.R
import com.example.moflix.databinding.ActivityDetailMovieBinding
import com.example.moflix.ui.main.MainActivity
import com.skydoves.bindables.BindingActivity
import com.skydoves.bundler.Bundler
import com.skydoves.bundler.bundleNonNull
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailMovieActivity : BindingActivity<ActivityDetailMovieBinding>(R.layout.activity_detail_movie) {

    @set:Inject
    internal lateinit var detailViewModelFactory: DetaiViewModel.AssistedFactory

    @VisibleForTesting
    internal val viewModel:DetaiViewModel by viewModels {
        DetaiViewModel.provideFactory(detailViewModelFactory, movieDetail.id)
    }

    private lateinit var movieDetail: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetail = intent.extras?.getParcelable<Movie>(EXTRA_MOVIE)!!

        binding {
            vm = viewModel
        }
    }

    companion object {
        @VisibleForTesting
        internal const val EXTRA_MOVIE = "EXTRA_MOVIE"

        fun runActivity(context: Context, movie: Movie) {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, movie)
            val bundle = Bundle().apply {

            }
            startActivity(context, intent, bundle)
        }

    }
}