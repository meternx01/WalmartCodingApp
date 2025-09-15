package com.example.walmartcodingapp.data.repository

import com.example.walmartcodingapp.data.model.Country

interface ICountryRepository {
    suspend fun getCountries(): Result<List<Country>>
}

