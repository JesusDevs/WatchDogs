package com.example.watchdogs.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object{
        const val BASE_URL = "https://api.thedogapi.com/v1/"
        fun retrofitInstance(): IServiceApi {
            val retrofitClient = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitClient.create(IServiceApi::class.java)
        }
    }
}