package com.example.walmartcodingapp.domain.usecase

import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.data.repository.ICountryRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: ICountryRepository
) {
    suspend operator fun invoke(): Result<List<Country>> = repository.getCountries()
}

