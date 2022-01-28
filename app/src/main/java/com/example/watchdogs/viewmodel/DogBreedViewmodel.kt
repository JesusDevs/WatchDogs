package com.example.watchdogs.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchdogs.pojo.DogApiResponseItem
import com.example.watchdogs.remote.RepoDog
import kotlinx.coroutines.launch

class DogBreedViewmodel(application: Application) : AndroidViewModel(application) {


    private val repositoryDog : RepoDog = RepoDog()
    val allDogData : LiveData<List<DogApiResponseItem>>

    init {
        allDogData = repositoryDog.liveDataDogoResponse
    }

    fun getDogoData(value:Int,
                    limit :Int,
                    page :Int ) =viewModelScope.launch {
        Log.d("viewmodel", "breeds + $")
        repositoryDog.getDogosFromInternetRepo(
            value,
            limit,
            page
        )


       /* fun getDogoData() = viewModelScope.launch {
            Log.d("viewmodel", "breeds + $")
            repositoryDog.getDogosFromInternetRepo()
        }*/
    }
}