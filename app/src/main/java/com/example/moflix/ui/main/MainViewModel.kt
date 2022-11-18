package com.example.moflix.ui.main

import android.util.Log
import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_data.repository.MainRepository
import com.example.core_model.Movie
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 15/11/22
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : BindingViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val movieFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(1)
    @OptIn(ExperimentalCoroutinesApi::class)
    private val movieDiscoverListFlow = movieFetchingIndex.flatMapLatest { page ->
        repository.fetchDiscoverMovie(
            page = page,
            onStart = { isLoading = true },
            onError = { toastMessage = it},
            onComplete = { isLoading = false }
        )
    }

    @get:Bindable
    val movieDiscoverList: List<Movie> by movieDiscoverListFlow.asBindingProperty(viewModelScope, emptyList())


    init {
        Log.d("MainViewModel", "init mainViewModel")
    }

    @MainThread
    fun fetchNextMovieDiscover(){
        if (!isLoading){
            movieFetchingIndex.value++
        }
    }
}