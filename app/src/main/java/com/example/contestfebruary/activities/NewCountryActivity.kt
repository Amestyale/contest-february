package com.example.contestfebruary.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contestfebruary.R
import com.example.contestfebruary.adapters.ApiCountryAdapter
import com.example.contestfebruary.models.Country
import com.example.contestfebruary.services.apiService
import com.google.gson.Gson
import com.squareup.okhttp.Response
import kotlinx.android.synthetic.main.activity_new_country.*
import org.json.JSONArray
import org.json.JSONObject


class NewCountryActivity : AppCompatActivity(), apiService {
    var CList: MutableList<Country> = ArrayList()
    val countriesAdapter = ApiCountryAdapter(CList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_country)

        coutries_list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        coutries_list.layoutManager = layoutManager
        coutries_list.adapter = countriesAdapter

        countriesAdapter.onItemClick = { country ->

            // do something with your item
            selectCountry(country)
        }
        getCountries("https://restcountries.eu/rest/v2/all");

        val yourEditText : EditText = findViewById<EditText>(R.id.search_bar)
        val button: Button = findViewById<View>(R.id.button1) as Button
        button.setOnClickListener {
            val s = yourEditText.text.toString()
            if(s.length>0){
                getCountries("https://restcountries.eu/rest/v2/name/"+s)
            } else {
                getCountries("https://restcountries.eu/rest/v2/all");
            }
        }
    }

    fun getCountries(search: String){
        callAPI(search);
    }

    override fun useResponse(response: Response?) {
        var apir = response?.body()?.string()

        countriesAdapter.notifyItemRangeRemoved(0,CList.size)
        CList.clear()

        if(apir.toString().first().toString() == "[".toString() ) {
            var countries = JSONArray(apir)
            for (i in 0 until countries.length()) {
                val item = countries.getJSONObject(i)
                CList.add( Country(0,item.getString("name"),item.getString("capital"),item.getString("region"),"",item.getString("alpha2Code")))
                countriesAdapter.notifyItemInserted(CList.size-1)
                // Your code here
            }
            if(countries.length()>0){
                showNoResult(View.GONE)
            }
        } else {
            var country = JSONObject(apir)
            if(country.getString("status").equals("404")){
                showNoResult(View.VISIBLE)
            }
        }

    }

    fun showNoResult(vis: Int){
        Handler(Looper.getMainLooper()).post(Runnable {
            findViewById<TextView>(R.id.text_noresult).visibility = vis
        })
    }

    fun selectCountry(country: Country){
        val countryJson: String = Gson().toJson(country)
        val intent = Intent(baseContext, DatePickerActivity::class.java)
        intent.putExtra("EXTRA_COUNTRY", countryJson)
        startActivity(intent)
    }

}