package com.izzed.ndelokmovie15.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzed.ndelokmovie15.core.domain.usecase.movie.MovieUseCase

class MovieViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getMovies() = useCase.getMovies().asLiveData()
}