package com.example.contestfebruary.services

import android.app.Activity
import com.squareup.okhttp.*
import java.io.IOException


interface apiService {


    fun callAPI(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(request: Request?, e: IOException?) {}
            override fun onResponse(response: Response?) {
                useResponse(response)
            }

        })
    }

    fun useResponse(response: Response?){
    }

}