package com.murimovies.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import com.murimovies.domain.model.MovieResponse
import com.murimovies.domain.usecase.GetMovieList
import kotlinx.coroutines.CoroutineScope
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murimovies.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieListViewModel: ViewModel() {
    val movieListLiveData = MutableLiveData<MovieResponse>()
    private val movieListRequirement = GetMovieList()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO){
            val result: MovieResponse? = movieListRequirement(Constants.MAX_MOVIE_NUMBER)
            Log.d("Salida", result?.results.toString())
            CoroutineScope(Dispatchers.Main).launch {
                movieListLiveData.postValue(result!!)
            }
        }
    }

}