package com.example.contestfebruary.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contestfebruary.models.Country

@Database(entities = [Country::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun countriesDAO(): CountriesDAO
}
