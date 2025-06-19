package com.example.walmartcodingapp.data.repository

import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.data.network.CountriesApiService

class CountryRepository(private val api: CountriesApiService) {
    suspend fun getCountries(): Result<List<Country>> = try {
        val list = api.fetchAll()
        Result.success(list)
    } catch (e: Exception) {
        Result.failure(e)
    }
}


