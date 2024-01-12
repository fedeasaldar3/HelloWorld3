package com.example.turismtown.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turismtown.databinding.FragmentListBinding
import com.example.turismtown.main.MainActivity
import com.example.turismtown.model.PlaceItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var placesAdapter: PlacesAdapter
    private var listPlaces: ArrayList<PlaceItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideIcon()

        listViewModel.loadMockPlaceFromJson(context?.assets?.open("places_json.json"))

        listViewModel.onPlacesLoaded.observe(viewLifecycleOwner) {
            onPlacesLoadedSubscribe(it)
        }

    }

    private fun onPlacesLoadedSubscribe(listPlaces: ArrayList<PlaceItem>) {
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


}