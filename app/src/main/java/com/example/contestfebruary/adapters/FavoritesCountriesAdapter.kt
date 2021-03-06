package com.example.contestfebruary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contestfebruary.R
import com.example.contestfebruary.models.Country
import com.squareup.picasso.Picasso

class FavoritesCountriesAdapter (private var listeCountries: MutableList<Country>):
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
        val url : String = "https://static.vecteezy.com/system/resources/previews/000/630/479/original/vector-trash-can-icon-symbol-illustration.jpg";
        Picasso.get().load(url).resize(50, 50).centerCrop().into(holder.imageViewtrash)
        val urlt : String = "http://www.geognos.com/api/en/countries/flag/"+ listeCountries[position].code + ".png";
        Picasso.get().load(urlt).resize(160, 80).centerCrop().into(holder.imageViewFlagCountry)
    }
    fun updateCountries(listeCountry: MutableList<Country>)
    {
        this.listeCountries = listeCountry
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listeCountries.size
    // ViewHolder :
    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewNameCountry: TextView = itemView.findViewById(R.id.name_country)
        val textViewCapitalCountry: TextView = itemView.findViewById(R.id.capital_country)
        val textViewRegionCountry: TextView = itemView.findViewById(R.id.region_country)
        val textViewDateCountry: TextView = itemView.findViewById(R.id.date_country)
        val imageViewFlagCountry: ImageView = itemView.findViewById(R.id.country_flag)
        val imageViewtrash: ImageView = itemView.findViewById(R.id.delete_button)
    }

}