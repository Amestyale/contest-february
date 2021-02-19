package com.example.contestfebruary.db

import androidx.room.*
import com.example.contestfebruary.models.Country

@Dao
abstract class CountriesDAO
{
    @Query("SELECT * FROM countries")
    abstract fun getListeCountries(): MutableList<Country>
    @Insert
    abstract fun insert(vararg country: Country)
    @Update
    abstract fun update(vararg country: Country)
    @Delete
    abstract fun delete(vararg country: Country)
}