package com.example.contestfebruary.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contestfebruary.R
import com.example.contestfebruary.adapters.FavoritesCountriesAdapter
import com.example.contestfebruary.models.CountryDTO
import kotlinx.android.synthetic.main.activity_favorites_countries.*

class FavoritesCountriesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_countries)
        liste_countries.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        liste_countries.layoutManager = layoutManager
        val listeCountries: MutableList<CountryDTO> = ArrayList()

        listeCountries.add(CountryDTO(0, "France", "Paris", "Europe", "10/03/2021", "FR"))

        val favoritesCountriesAdapter = FavoritesCountriesAdapter(listeCountries)
        liste_countries.adapter = favoritesCountriesAdapter

    }
}