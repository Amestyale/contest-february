package com.example.contestfebruary.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contestfebruary.R
import com.example.contestfebruary.adapters.FavoritesCountriesAdapter

import com.example.contestfebruary.helpers.AppDatabaseHelper
import com.example.contestfebruary.models.Country
import kotlinx.android.synthetic.main.activity_favorites_countries.*
import kotlinx.android.synthetic.main.item_favorite_country.*

class FavoritesCountriesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_countries)
        liste_countries.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        liste_countries.layoutManager = layoutManager
        val listeCountries: MutableList<Country> = AppDatabaseHelper.getDatabase(this).countriesDAO().getListeCountries()
        val favoritesCountriesAdapter = FavoritesCountriesAdapter(listeCountries)
        liste_countries.adapter = favoritesCountriesAdapter

        val btn: Button = findViewById<Button>(R.id.button1)

        btn.setOnClickListener(View.OnClickListener { v ->
            val intent = Intent(baseContext, NewCountryActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onBackPressed() {
        // NA
    }
    @Suppress("UNUSED_PARAMETER")
    fun onClickBoutonDelete(view: View?)
    {
        AppDatabaseHelper.getDatabase(this).countriesDAO().delete(Country(0,
            name_country.text.toString(),
            capital_country.text.toString(),
            region_country.text.toString(),
            region_country.text.toString(),
            date_country.text.toString()))
        var Countries = AppDatabaseHelper.getDatabase(this).countriesDAO().getListeCountries()
        FavoritesCountriesAdapter(Countries).updateCountries(Countries)
    }
}