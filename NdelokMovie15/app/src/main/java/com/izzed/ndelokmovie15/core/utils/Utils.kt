package com.izzed.ndelokmovie15.core.utils

import com.izzed.ndelokmovie15.core.data.remote.response.MovieResponse
import com.izzed.ndelokmovie15.core.data.remote.response.TvShowResponse
import com.izzed.ndelokmovie15.core.domain.model.Movie
import com.izzed.ndelokmovie15.core.domain.model.TvShow

fun mapMovieResponseToDomain(input: MovieResponse) =
    Movie(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )

fun mapTvShowResponseToDomain(input: TvShowResponse) =
    TvShow(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )