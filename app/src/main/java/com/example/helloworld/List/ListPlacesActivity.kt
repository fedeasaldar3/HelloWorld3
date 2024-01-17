package com.example.helloworld.List

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.datail.DetailActivity
import com.example.helloworld.model.Place
import com.example.helloworld.model.PlaceItem
import com.google.gson.Gson

class ListPlacesActivity : AppCompatActivity() {

    private lateinit var listPlaces: ArrayList<PlaceItem>
    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_places)

        placesRecyclerView = findViewById(R.id.places_rv)

        //listPlaces = createMockPlaces()
        listPlaces = loadMockPlaceFromJson()

        placesAdapter = PlacesAdapter(onItemClicked = { onPlaceClicked(it) }, listPlaces)
        /*placesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )*/
        placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }
        placesRecyclerView.adapter = placesAdapter
    }

    private fun onPlaceClicked(place: PlaceItem) {
        Log.d("Place Name", place.placeName)
        val inten = Intent(this, DetailActivity::class.java)
        inten.putExtra("place", place)
        startActivity(inten)
    }

    private fun loadMockPlaceFromJson(): ArrayList<PlaceItem> {
        val placesString: String =
            applicationContext
                .assets
                .open("places_json.json")
                .bufferedReader()
                .use { it.readText() }

        val gson = Gson()
        val data = gson.fromJson(placesString, Place::class.java)
        return data
    }

    /*private fun createMockPlaces(): ArrayList<PlaceItem> {
        return arrayListOf(
            Place(
                "Medellín",
                "Colombia",
                "Tropical alto",
                "Arte y cultura, vida nocturna, turismo urbano.",
                "Museos, parques, zonas comerciales.",
                "https://www.travelers.com.co/assets/cache/uploads/medellin/1300x868/medellin-travelers-apartamentos-suites-colombia.jpeg"

            ),
            Place(
                "Guatapé",
                "Colombia",
                "Tropical alto",
                "Naturaleza, aventura, turismo rural.",
                "Embalse, piedra del Peñol, miradores.",
                "https://media.tacdn.com/media/attractions-splice-spp-674x446/06/e4/7b/b5.jpg"
            ),
            Place(
                "Jardín",
                "Colombia",
                "Frio",
                "Naturaleza, patrimonio histórico, turismo rural.",
                "Plazas, iglesias, parques naturales.",
                "https://i.ytimg.com/vi/HR4TfljCEn4/hqdefault.jpg"
            ),
            Place(
                "Santa Fé de Antioquia",
                "Colombia",
                "Caliente",
                "Historia, patrimonio arquitectónico, turismo cultural.",
                "Calles coloniales, iglesias, arquitectura histórica.",
                "https://www.panajamtours.com/wp-content/uploads/2018/05/Santa-Fe-de-antioquia-1.jpg"
            ),
            Place(
                "Jericó",
                "Colombia",
                "Frio",
                "Historia, turismo religioso, turismo rural.",
                "Iglesias, museos, paisajes naturales.",
                "https://fedelsahostels.com/wp-content/uploads/2020/07/Copy-of-org_c7f0aa8f36491f97_1537962468000-e1598367187404-1.jpg"
            )
        )

    }*/
}