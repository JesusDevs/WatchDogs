package com.example.watchdogs.pojo


import com.google.gson.annotations.SerializedName

data class Height(
    @SerializedName("imperial")
    val imperial: String,
    @SerializedName("metric")
    val metric: String
)