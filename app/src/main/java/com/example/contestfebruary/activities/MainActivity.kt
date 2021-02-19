package com.example.contestfebruary.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contestfebruary.R
import com.example.contestfebruary.activities.DatePickerActivity
import com.example.contestfebruary.activities.NewCountryActivity
import com.example.contestfebruary.services.apiService
import com.squareup.okhttp.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, FavoritesCountriesActivity::class.java).apply {
        }
        startActivity(intent)
    }

}
