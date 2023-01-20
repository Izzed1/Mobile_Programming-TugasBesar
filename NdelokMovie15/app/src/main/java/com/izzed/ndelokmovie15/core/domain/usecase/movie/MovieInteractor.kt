package com.izzed.ndelokmovie15.core.domain.usecase.movie

import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.domain.model.Movie
import com.izzed.ndelokmovie15.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val repository: IMovieRepository): MovieUseCase {
    override fun getMovies(): Flow<Resource<List<Movie>>> = repository.getMovies()
}