package com.example.watchdogs.pojo


import com.google.gson.annotations.SerializedName

data class DogApiResponseItem(
    @SerializedName("bred_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String,
    @SerializedName("country_code")
    val countryCode: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("reference_image_id")
    val referenceImageId: String,
    @SerializedName("temperament")
    val temperament: String,

)