package com.example.walmartcodingapp.di

import com.example.walmartcodingapp.data.network.CountriesApiService
import com.example.walmartcodingapp.data.repository.CountryRepository
import com.example.walmartcodingapp.domain.usecase.GetCountriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCountriesApiService(retrofit: Retrofit): CountriesApiService =
        retrofit.create(CountriesApiService::class.java)

    @Provides
    @Singleton
    fun provideCountryRepository(api: CountriesApiService): CountryRepository =
        CountryRepository(api)

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(repo: CountryRepository): GetCountriesUseCase =
        GetCountriesUseCase(repo)
}

