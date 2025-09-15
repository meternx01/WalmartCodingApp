package com.example.walmartcodingapp.data.network

import com.example.walmartcodingapp.data.model.Country
import retrofit2.http.GET

interface CountriesApiService {
    @GET("db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun fetchAll(): List<Country>
}
