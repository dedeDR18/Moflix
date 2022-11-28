package com.example.moflix.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.example.core_model.Movie
import com.example.moflix.R
import com.example.moflix.databinding.ActivityMainBinding
import com.example.moflix.ui.detail.DetailMovieActivity
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main), MovieAdapter.OnClickListenerTest{

    @get:VisibleForTesting
    internal val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            adapter = MovieAdapter(this@MainActivity)
            vm = viewModel
        }
    }

    override fun onClickItem(movie: Movie) {
        Log.d("MAIN", "test click movie = ${movie}")
        DetailMovieActivity.runActivity(this, movie)
    }
}