package com.example.watchdogs.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.watchdogs.pojo.DogApiResponseItem

class RepoDog {
//crear instancia de retrofitInstance
private val retrofit = Retrofit.retrofitInstance()
    //observa el repo
    val liveDataDogoResponse = MutableLiveData<List<DogApiResponseItem>>()
   private val apikey = "250e4bc4-76e1-4ea4-89e9-7ca12c644022"


    suspend fun getDogosFromInternetRepo(  ){
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = retrofit.getDogosFromInternet( )

            when(response.isSuccessful) {

                true -> response.body()?.let {
                   liveDataDogoResponse.value = it
                    //Aca se debe insertar body en la Base de datos
                    Log.d("repo1", "breeds + $it")


                }
                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()} ")
            }
        } catch (t: Throwable){
            Log.e("ERROR CORUTINA", t.message.toString())
        }
    }
/*
    suspend fun getDogosFromInternetRepo( attachBreed : Int, page : Int , limit :Int ){
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = retrofit.getDogosFromInternet( attachBreed,limit,page,apikey)

            when(response.isSuccessful) {

                true -> response.body()?.let {
                    //Aca se debe insertar body en la Base de datos
                    Log.d("repo1", "breeds + $it")


                }
                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()} ")
            }
        } catch (t: Throwable){
            Log.e("ERROR CORUTINA", t.message.toString())
        }
    }*/
}


