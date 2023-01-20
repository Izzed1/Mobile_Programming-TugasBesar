package com.izzed.ndelokmovie15.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzed.ndelokmovie15.core.domain.usecase.tvshow.TvShowUseCase

class TvShowViewModel(private val useCase: TvShowUseCase): ViewModel() {

    fun getTvShow() = useCase.getTvShow().asLiveData()
}