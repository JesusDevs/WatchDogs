package com.example.watchdogs.ModeloOpcionalDog


import com.google.gson.annotations.SerializedName

data class DogOpcionB(
    @SerializedName("message")
    val dog: Message,
    @SerializedName("status")
    val status: String
)