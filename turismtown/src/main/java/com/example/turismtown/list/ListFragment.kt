package com.example.turismtown.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turismtown.databinding.FragmentListBinding
import com.example.turismtown.main.MainActivity
import com.example.turismtown.model.Place
import com.example.turismtown.model.PlaceItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var listPlaces: ArrayList<PlaceItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideIcon()
        listPlaces = loadMockPlaceFromJson()
        placesAdapter = PlacesAdapter(onItemClicked = { onPlaceClicked(it) }, listPlaces)
        listBinding.placesRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPlaceClicked(place: PlaceItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(place))
    }

    private fun loadMockPlaceFromJson(): ArrayList<PlaceItem> {
        val placesString: String =
            context?.assets?.open("places_json.json")?.bufferedReader().use { it!!.readText() }

        val gson = Gson()
        val data = gson.fromJson(placesString, Place::class.java)
        return data
    }
}