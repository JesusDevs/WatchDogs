package com.example.watchdogs.remote

import com.example.watchdogs.pojo.DogApiResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IServiceApi {

   /* @GET("breeds")
    suspend fun getDogosFromInternet(@Query("atachBreed") value:Int,
                                      @Query("limit") limit :Int,
                                      @Query("page") page :Int,
                                      @Header("x-api-key") apiKey: String ):
            Response<List<DogApiResponseItem>>*/


    @GET("breeds")
    suspend fun getDogosFromInternet():
            Response<List<DogApiResponseItem>>

}

