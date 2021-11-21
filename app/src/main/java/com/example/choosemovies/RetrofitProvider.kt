package com.example.choosemovies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val moviesApi = retrofit.create(MoviesApi::class.java)

}