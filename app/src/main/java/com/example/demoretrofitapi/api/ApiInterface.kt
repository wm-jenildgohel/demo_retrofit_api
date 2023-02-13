package com.example.demoretrofitapi.api

import androidx.lifecycle.LiveData
import com.example.demoretrofitapi.model.Superhero
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("all.json")
    suspend fun getAllHeros(): List<Superhero>

    companion object {
        private val url = "https://akabab.github.io/superhero-api/api/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}