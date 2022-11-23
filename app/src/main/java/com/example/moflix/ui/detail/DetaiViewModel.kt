package com.example.moflix.ui.detail

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.core_data.repository.MovieDetailRepository
import com.example.core_model.MovieDetail
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow

/**
 * Created by Dede Dari Rahmadi on 21/11/22
 */
class DetaiViewModel @AssistedInject constructor(
    movieDetailRepository: MovieDetailRepository,
    @Assisted private val idMovie: Int
) : BindingViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(true)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val movieDetailFlow: Flow<MovieDetail?> = movieDetailRepository.fetchMovieDetail(
        idMovie = idMovie,
        onComplete = { isLoading = false },
        onError = { toastMessage = it }
    )

    @get:Bindable
    val movieDetail: MovieDetail? by movieDetailFlow.asBindingProperty(viewModelScope, null)

    init {
        Log.d("DETAILVIEWMODEL", "INIT DETAIL VIEWMODEL")
    }

    @dagger.assisted.AssistedFactory
    interface AssistedFactory {
        fun create(idMovie: Int): DetaiViewModel
    }


    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
            idMovie: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(idMovie) as T
            }
        }
    }

}
