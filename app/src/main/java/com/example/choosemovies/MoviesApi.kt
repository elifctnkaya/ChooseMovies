package com.example.choosemovies

import android.telecom.Call
import com.example.choosemovies.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    suspend fun getMoviesPop(@Query("api_key") apiKey: String,
                          @Query("page") page: String): Movies

    @GET("movie/top_rated")
    suspend fun getTopRated(@Query("api_key") apiKey: String,
                            @Query("page") page: String): Movies

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") apiKey: String,
                              @Query("page") page: String): Movies

    @GET("movie/upcoming")
    suspend fun getUpComing(@Query("api_key") apiKey: String,
                            @Query("page") page: String): Movies
}