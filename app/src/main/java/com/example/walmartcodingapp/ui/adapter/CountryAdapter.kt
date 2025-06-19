package com.example.walmartcodingapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartcodingapp.R
import com.example.walmartcodingapp.data.model.Country
import com.example.walmartcodingapp.databinding.ItemCountryBinding

class CountryAdapter(private val items: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = items[position]
        with(holder.binding) {
            val context = holder.itemView.context
            tvNameRegion.text = context.getString(
                R.string.country_name_region, country.name, country.region
            )
            tvCode.text = country.code
            tvCapital.text = country.capital
        }
    }

    override fun getItemCount(): Int = items.size
}