package com.example.contestfebruary.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contestfebruary.R
import com.example.contestfebruary.adapters.FavoritesCountriesAdapter
import com.example.contestfebruary.helpers.AppDatabaseHelper
import com.example.contestfebruary.models.CountryDTO
import kotlinx.android.synthetic.main.activity_favorites_countries.*
import kotlinx.android.synthetic.main.item_favorite_country.*

class FavoritesCountriesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_countries)
        liste_countries.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        liste_countries.layoutManager = layoutManager
        val listeCountries: MutableList<CountryDTO> = AppDatabaseHelper.getDatabase(this).countriesDAO().getListeCountries()
        val favoritesCountriesAdapter = FavoritesCountriesAdapter(listeCountries)
        liste_countries.adapter = favoritesCountriesAdapter

    }
    @Suppress("UNUSED_PARAMETER")
    fun onClickBoutonDelete(view: View?)
    {
        AppDatabaseHelper.getDatabase(this).countriesDAO().delete(CountryDTO(0,
            name_country.text.toString(),
            capital_country.text.toString(),
            region_country.text.toString(),
            region_country.text.toString(),
            date_country.text.toString()))
        var Countries = AppDatabaseHelper.getDatabase(this).countriesDAO().getListeCountries()
        FavoritesCountriesAdapter(Countries).updateCountries(Countries)
    }
}