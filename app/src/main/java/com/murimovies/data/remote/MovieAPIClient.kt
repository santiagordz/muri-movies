package com.murimovies.data.remote

import com.murimovies.domain.model.MovieResponse

class MovieAPIClient {
private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit: Int): MovieResponse?{
        api = NetworkModuleDI()
        return try{
            api.getPopularMovies(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}