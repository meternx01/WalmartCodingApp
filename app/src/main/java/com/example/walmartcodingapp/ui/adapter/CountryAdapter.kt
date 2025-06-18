package com.example.walmartcodingapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartcodingapp.R
import com.example.walmartcodingapp.data.model.Country

class CountryAdapter(private val items: List<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameRegion = itemView.findViewById<TextView>(R.id.tvNameRegion)
        val code       = itemView.findViewById<TextView>(R.id.tvCode)
        val capital    = itemView.findViewById<TextView>(R.id.tvCapital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = items[position]
        holder.nameRegion.text = country.name
        holder.code.text = country.code
        holder.capital.text = country.capital
    }

    override fun getItemCount(): Int = items.size
}