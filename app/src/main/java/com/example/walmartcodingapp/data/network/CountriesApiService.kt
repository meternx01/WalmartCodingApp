package com.example.walmartcodingapp.data.network

import com.example.walmartcodingapp.data.model.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface CountriesApiService {
    @GET("db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun fetchAll(): List<Country>
}

object NetworkModule {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService: CountriesApiService = retrofit.create()
}