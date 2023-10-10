package com.murimovies.domain.usecase

import com.murimovies.data.repository.MovieRepository

class GetMovieList {
    private val repository = MovieRepository()
    suspend operator fun invoke(limit: Int) = repository.getMovieList(limit)
}