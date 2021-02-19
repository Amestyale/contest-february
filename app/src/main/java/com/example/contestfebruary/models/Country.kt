package com.example.contestfebruary.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
class Country(
    @PrimaryKey(autoGenerate = true)
    val id: Long  = 0,
    val name: String,
    val capital: String,
    val region: String,
    var date: String? = null,
    val code: String
)
