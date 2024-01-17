package com.example.turismtown.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlaceItem(
    @SerializedName("country")
    val country: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("placeName")
    val placeName: String,
    @SerializedName("themes")
    val themes: String,
    @SerializedName("typeOfPlace")
    val typeOfPlace: String,
    @SerializedName("weather")
    val weather: String
) : Serializable