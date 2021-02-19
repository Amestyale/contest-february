package com.example.contestfebruary.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.contestfebruary.R
import com.example.contestfebruary.helpers.AppDatabaseHelper
import com.example.contestfebruary.db.CountriesDAO
import com.example.contestfebruary.models.Country
import com.google.gson.Gson


class DatePickerActivity : AppCompatActivity() {
    var country : Country = Country(0,"","","","","");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        val jsonCountry: String = intent.getStringExtra("EXTRA_COUNTRY")
        country = Gson().fromJson(jsonCountry,Country::class.java)

        val btn: Button = findViewById<Button>(R.id.button1)

        btn.setOnClickListener(View.OnClickListener { v -> selectDate() })
    }

    fun checkDigit(number: Int): String? {
        return if (number <= 9) "0$number" else number.toString()
    }

    fun selectDate(){
        val datePicker: DatePicker
        datePicker = findViewById<View>(R.id.date_picker) as DatePicker

        val day = checkDigit(datePicker.dayOfMonth)
        val month = checkDigit(datePicker.month + 1)
        val year = checkDigit(datePicker.year)

        country.date = day + "/" + month + "/" + year
        AppDatabaseHelper.getDatabase(this).countriesDAO().insert(country)

        val intent = Intent(this, FavoritesCountriesActivity::class.java).apply {
        }
        startActivity(intent)
    }
}