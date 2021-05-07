package com.example.bharatreddit.model.network

import com.example.bharatreddit.BuildConfig
import com.example.bharatreddit.model.CharacterResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET(BuildConfig.end_point)
    suspend fun getCharacters(@Query("page") pageParam: Int): CharacterResult

    companion object{
        fun networkApi(): CharacterApi{
            return Retrofit.Builder()
                .baseUrl(BuildConfig.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CharacterApi::class.java)
        }
    }
}