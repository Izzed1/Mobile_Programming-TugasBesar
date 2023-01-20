package com.izzed.ndelokmovie15.di

import com.izzed.ndelokmovie15.core.domain.usecase.movie.MovieInteractor
import com.izzed.ndelokmovie15.core.domain.usecase.movie.MovieUseCase
import com.izzed.ndelokmovie15.core.domain.usecase.tvshow.TvShowInteractor
import com.izzed.ndelokmovie15.core.domain.usecase.tvshow.TvShowUseCase
import com.izzed.ndelokmovie15.ui.movie.MovieViewModel
import com.izzed.ndelokmovie15.ui.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
    factory<TvShowUseCase> { TvShowInteractor(get()) }

}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
}