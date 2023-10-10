package com.murimovies.data.repository

import com.murimovies.data.remote.MovieAPIClient
import com.murimovies.domain.model.MovieResponse

class MovieRepository {
    private val api = MovieAPIClient()
    suspend fun getMovieList(limit: Int): MovieResponse? = api.getMovieList(limit)
}