package com.example.watchdogs.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.watchdogs.pojo.DogApiResponseItem
import retrofit2.http.Header
import retrofit2.http.Query

class RepoDog {
//crear instancia de retrofitInstance
private val retrofit = Retrofit.retrofitInstance()
    //observa el repo
    val liveDataDogoResponse = MutableLiveData<List<DogApiResponseItem>>()
   private val apikey = "250e4bc4-76e1-4ea4-89e9-7ca12c644022"


    suspend fun getDogosFromInternetRepo(value:Int,
                                         limit :Int,
                                         page :Int){
        try {
            val response = retrofit.getDogosFromInternet(value,limit,page,apikey)

            when(response.isSuccessful) {

                true -> response.body()?.let {

                    //observando response.body con liveData
                   liveDataDogoResponse.value = it

                    //Aca se debe insertar body en la Base de datos pendiente
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


