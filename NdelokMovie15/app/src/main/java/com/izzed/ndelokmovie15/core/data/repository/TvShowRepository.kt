package com.izzed.ndelokmovie15.core.data.repository

import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.data.remote.TvShowRemoteDataSource
import com.izzed.ndelokmovie15.core.data.remote.network.ApiResponse
import com.izzed.ndelokmovie15.core.domain.model.TvShow
import com.izzed.ndelokmovie15.core.domain.repository.ITvShowRepository
import com.izzed.ndelokmovie15.core.utils.mapTvShowResponseToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class TvShowRepository(private val tvShowRemoteDataSource: TvShowRemoteDataSource): ITvShowRepository {
    override fun getTvShow(): Flow<Resource<List<TvShow>>> =
        flow {
            emit(Resource.Loading())
            when(val apiResponse = tvShowRemoteDataSource.getTvShow().first()){
                is ApiResponse.Success -> emit(Resource.Success(apiResponse.data.map { mapTvShowResponseToDomain(it) }))
                is ApiResponse.Empty -> emit(Resource.Success(null))
                is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
            }
        }

}