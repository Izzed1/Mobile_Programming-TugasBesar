package com.izzed.ndelokmovie15.core.domain.repository

import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface ITvShowRepository {
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}