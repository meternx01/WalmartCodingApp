package com.example.walmartcodingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.data.repository.CountryRepository
import kotlinx.coroutines.launch

class CountriesViewModel(private val repo: CountryRepository) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: MutableLiveData<UiState>
        get() = _uiState

    init {
        loadCountries()
    }

    private fun loadCountries() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        repo.getCountries().onSuccess { countries ->
                _uiState.value = UiState.Success(countries)
            }.onFailure { throwable ->
                _uiState.value = UiState.Error(throwable)
            }
    }

    sealed class UiState {
        object Loading : UiState()
        data class Success(val countries: List<Country>) : UiState()
        data class Error(val throwable: Throwable) : UiState()
    }
}