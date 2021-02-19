package com.example.contestfebruary.db

import androidx.room.*
import com.example.contestfebruary.models.CountryDTO

@Dao
abstract class CountriesDAO
{
    @Query("SELECT * FROM countries")
    abstract fun getListeCountries(): List<CountryDTO>
    @Insert
    abstract fun insert(vararg country: CountryDTO)
    @Update
    abstract fun update(vararg country: CountryDTO)
    @Delete
    abstract fun delete(vararg country: CountryDTO)
}