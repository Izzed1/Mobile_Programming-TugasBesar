package com.izzed.ndelokmovie15.core.domain.usecase.tvshow

import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowUseCase{
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}