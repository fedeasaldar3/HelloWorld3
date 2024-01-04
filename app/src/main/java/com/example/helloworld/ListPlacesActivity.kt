package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListPlacesActivity : AppCompatActivity() {

    private lateinit var listPlaces: ArrayList<Place>
    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_places)

        placesRecyclerView = findViewById(R.id.places_rv)

        listPlaces = createMockPlaces()

        placesAdapter = PlacesAdapter(listPlaces)
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

    private fun createMockPlaces(): ArrayList<Place> {
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

    }
}