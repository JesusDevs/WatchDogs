package com.example.watchdogs.extensions


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)