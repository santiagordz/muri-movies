package com.murimovies.data.remote

import android.util.Log
import com.murimovies.domain.model.MovieResponse

class MovieAPIClient {
private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit: Int): MovieResponse?{
        api = NetworkModuleDI()
        return try{
            val result = api.getPopularMovies(limit)
            Log.d("SalidaAPI", result.toString())
            result
        }catch (e:java.lang.Exception){
            Log.d("SalidaAPI", e.toString())
            e.printStackTrace()
            null
        }
    }
}