package com.example.turismtown.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.turismtown.model.Place
import com.example.turismtown.model.PlaceItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var placesLoad: MutableLiveData<ArrayList<PlaceItem>> = MutableLiveData()
    val onPlacesLoaded: LiveData<ArrayList<PlaceItem>> = placesLoad

    fun loadMockPlaceFromJson(placesStream: InputStream?) {
        val placesString = placesStream?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        placesLoad.value = gson.fromJson(placesString, Place::class.java)
    }
}