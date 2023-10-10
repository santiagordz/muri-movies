package com.murimovies.data.remote

import com.murimovies.domain.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}