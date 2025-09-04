package com.example.walmartcodingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.data.repository.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel(private val repo: CountryRepository) : ViewModel() {

    sealed class UiState {
        data object Loading : UiState()
        data class Success(val countries: List<Country>) : UiState()
        data class Error(val throwable: Throwable) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

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

}