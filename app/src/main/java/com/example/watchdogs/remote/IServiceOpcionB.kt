package com.example.watchdogs.remote

import com.example.watchdogs.ModeloOpcionalDog.DogList
import retrofit2.http.GET
import retrofit2.http.Path

interface IServiceOpcionB {

    @GET("breeds/list/")
    suspend fun fetchBreedList(): retrofit2.Response<DogList>

}