package com.izzed.ndelokmovie15.core.domain.repository

import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
}