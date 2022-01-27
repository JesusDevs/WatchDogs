package com.example.watchdogs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchdogs.pojo.DogApiResponseItem
import com.example.watchdogs.remote.RepoDog
import kotlinx.coroutines.launch

class DogBreedViewmodel : ViewModel() {


    private val repositoryDog : RepoDog
    val allDogData : LiveData<List<DogApiResponseItem>>

    init {
        repositoryDog = RepoDog()
        allDogData = repositoryDog.liveDataDogoResponse
    }

    fun getDogoData( attachBreed : Int, page : Int , limit :Int ) =viewModelScope.launch {

        repositoryDog.getDogosFromInternetRepo(attachBreed,page,limit)
    }

}