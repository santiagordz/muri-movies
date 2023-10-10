package com.murimovies.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murimovies.domain.model.MovieResponse
import com.murimovies.domain.usecase.GetMovieList
import com.murimovies.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieListViewModel : ViewModel() {
    val movieListLiveData = MutableLiveData<MovieResponse>()
    private val movieListRequirement = GetMovieList()

    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result: MovieResponse? = movieListRequirement(Constants.MAX_MOVIE_NUMBER)
                if (result != null) {
                    CoroutineScope(Dispatchers.Main).launch {
                        movieListLiveData.postValue(result!!)
                    }
                } else {
                    Log.d("Salida", "Error")
                }
            } catch (e: Exception) {
                Log.d("Salida", e.toString())
            }
        }
    }
}