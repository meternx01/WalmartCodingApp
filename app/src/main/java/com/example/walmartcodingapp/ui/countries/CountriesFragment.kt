package com.example.walmartcodingapp.ui.countries

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.viewModels
import com.example.walmartcodingapp.R
import com.example.walmartcodingapp.data.network.NetworkModule
import com.example.walmartcodingapp.data.repository.CountryRepository
import com.example.walmartcodingapp.databinding.FragmentCountriesBinding
import com.example.walmartcodingapp.ui.adapter.CountryAdapter
import com.example.walmartcodingapp.viewmodel.CountriesViewModel
import com.example.walmartcodingapp.viewmodel.CountriesViewModelFactory

class CountriesFragment : Fragment(R.layout.fragment_countries) {

    private val viewModel: CountriesViewModel by viewModels {
        CountriesViewModelFactory(
            CountryRepository(NetworkModule.apiService)
        )
    }

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCountriesBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvCountries.layoutManager = LinearLayoutManager(requireContext())

            viewModel.uiState.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is CountriesViewModel.UiState.Loading -> {
                        progress.isVisible = true
                        rvCountries.isVisible = false
                        tvError.isVisible     = false
                    }
                    is CountriesViewModel.UiState.Success -> {
                        progress.isVisible    = false
                        rvCountries.isVisible = true
                        rvCountries.adapter   = CountryAdapter(state.countries)
                    }
                    is CountriesViewModel.UiState.Error -> {
                        progress.isVisible = false
                        tvError.isVisible  = true
                        tvError.text = getString(R.string.error_text, state.throwable.message)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}