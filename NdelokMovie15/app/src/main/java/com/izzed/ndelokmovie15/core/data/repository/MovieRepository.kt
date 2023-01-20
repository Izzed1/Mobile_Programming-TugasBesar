package com.izzed.ndelokmovie15.core.data.repository

import com.izzed.ndelokmovie15.core.data.remote.MovieRemoteDataSource
import com.izzed.ndelokmovie15.core.data.remote.Resource
import com.izzed.ndelokmovie15.core.data.remote.network.ApiResponse
import com.izzed.ndelokmovie15.core.domain.model.Movie
import com.izzed.ndelokmovie15.core.domain.repository.IMovieRepository
import com.izzed.ndelokmovie15.core.utils.mapMovieResponseToDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class MovieRepository(private val movieRemoteDataSource: MovieRemoteDataSource): IMovieRepository {
    override fun getMovies(): Flow<Resource<List<Movie>>> =
        flow {
            emit(Resource.Loading())
            when(val apiResponse = movieRemoteDataSource.getMovies().first()){
                is ApiResponse.Success -> emit(Resource.Success(apiResponse.data.map { mapMovieResponseToDomain(it) }))
                is ApiResponse.Empty -> emit(Resource.Success(null))
                is ApiResponse.Error -> emit(Resource.Error(apiResponse.errorMessage))
            }
        }

}