package com.example.walmartcodingapp.ui.countries

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walmartcodingapp.R
import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.data.network.NetworkModule
import com.example.walmartcodingapp.data.repository.CountryRepository
import com.example.walmartcodingapp.viewmodel.CountriesViewModel
import com.example.walmartcodingapp.viewmodel.CountriesViewModelFactory

@Composable
fun CountriesScreen() {
    val viewModel: CountriesViewModel = viewModel(
        factory = CountriesViewModelFactory(CountryRepository(NetworkModule.apiService))
    )
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is CountriesViewModel.UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is CountriesViewModel.UiState.Success -> {
                val countries = (uiState as CountriesViewModel.UiState.Success).countries
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(countries) { country ->
                        CountryItem(country)
                    }
                }
            }
            is CountriesViewModel.UiState.Error -> {
                val error = (uiState as CountriesViewModel.UiState.Error).throwable
                Text(
                    text = stringResource(R.string.error_text, error.message ?: "Unknown error"),
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.country_name_region, country.name, country.region),
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.weight(1f)
                )
                Text(text = country.code, style = MaterialTheme.typography.body2)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = country.capital, style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CountriesScreenPreview() {
    // Provide a sample list of countries for preview
    val sampleCountries = listOf(
        Country("United States", "US", "Washington, D.C.", "Americas"),
        Country("Canada", "CA", "Ottawa", "Americas"),
        Country("Japan", "JP", "Tokyo", "Asia")
    )
    // Simulate Success state
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(sampleCountries) { country ->
                CountryItem(country)
            }
        }
    }
}
