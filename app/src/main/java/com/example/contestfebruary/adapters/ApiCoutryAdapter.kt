package com.example.contestfebruary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contestfebruary.R
import com.example.contestfebruary.models.Country;
import com.squareup.picasso.Picasso

class ApiCountryAdapter(private var listeCountries: MutableList<Country>) : RecyclerView.Adapter<ApiCountryAdapter.ApiCountryViewHolder>()
{
    var onItemClick: ((Country) -> Unit)? = null
    // Crée chaque vue item à afficher :
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiCountryViewHolder      {
        val viewCourse = LayoutInflater.from(parent.context).inflate(R.layout.item_api_country, parent, false)
        return ApiCountryViewHolder(viewCourse)
    }
// Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: ApiCountryViewHolder, position: Int)      {

    holder.textViewNameCountry .text = listeCountries[position].name
    holder.textViewCapitalCountry.text = listeCountries[position].capital
    holder.textViewRegionCountry.text = listeCountries[position].region
    holder.textViewDateCountry.text = listeCountries[position].date

    val url : String = "http://www.geognos.com/api/en/countries/flag/"+ listeCountries[position].code + ".png";
    Picasso.get().load(url).resize(160, 80).centerCrop().into(holder.imageViewFlagCountry)
    }
    override fun getItemCount(): Int = listeCountries.size

// ViewHolder :
    inner class ApiCountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)      {
        val textViewNameCountry: TextView = itemView.findViewById(R.id.name_country)
        val textViewCapitalCountry: TextView = itemView.findViewById(R.id.capital_country)
        val textViewRegionCountry: TextView = itemView.findViewById(R.id.region_country)
        val textViewDateCountry: TextView = itemView.findViewById(R.id.date_country)
        val imageViewFlagCountry: ImageView = itemView.findViewById(R.id.country_flag)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listeCountries[adapterPosition])
            }
        }
    }


}