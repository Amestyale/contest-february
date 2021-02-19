package com.example.contestfebruary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contestfebruary.R
import com.example.contestfebruary.models.CountryDTO

class FavoritesCountriesAdapter (private var listeCountries: MutableList<CountryDTO>):
    RecyclerView.Adapter<FavoritesCountriesAdapter.CountryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder
    {
        val viewCountry = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_country, parent, false)
        return CountryViewHolder(viewCountry)
    }

    // Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int)
    {
        holder.textViewNameCountry.text = listeCountries[position].name
        holder.textViewCapitalCountry.text = listeCountries[position].capital
        holder.textViewRegionCountry.text = listeCountries[position].region
        holder.textViewDateCountry.text = listeCountries[position].date
    }

    override fun getItemCount(): Int = listeCountries.size
    // ViewHolder :
    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewNameCountry: TextView = itemView.findViewById(R.id.name_country)
        val textViewCapitalCountry: TextView = itemView.findViewById(R.id.capital_country)
        val textViewRegionCountry: TextView = itemView.findViewById(R.id.region_country)
        val textViewDateCountry: TextView = itemView.findViewById(R.id.date_country)
    }

}