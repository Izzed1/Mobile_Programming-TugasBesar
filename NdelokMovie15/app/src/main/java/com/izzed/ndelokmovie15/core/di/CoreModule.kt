package com.izzed.ndelokmovie15.core.di

import com.izzed.ndelokmovie15.BuildConfig
import com.izzed.ndelokmovie15.core.data.remote.MovieRemoteDataSource
import com.izzed.ndelokmovie15.core.data.remote.TvShowRemoteDataSource
import com.izzed.ndelokmovie15.core.data.remote.network.ApiService
import com.izzed.ndelokmovie15.core.data.repository.MovieRepository
import com.izzed.ndelokmovie15.core.data.repository.TvShowRepository
import com.izzed.ndelokmovie15.core.domain.repository.IMovieRepository
import com.izzed.ndelokmovie15.core.domain.repository.ITvShowRepository
import com.izzed.ndelokmovie15.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        val httpCliet = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            httpCliet.addInterceptor(logging)
        }

        httpCliet
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

}

val repositoryModule = module {
    single { MovieRemoteDataSource(get()) }
    single<IMovieRepository> { MovieRepository(get()) }
    single { TvShowRemoteDataSource(get()) }
    single<ITvShowRepository> { TvShowRepository(get()) }
}