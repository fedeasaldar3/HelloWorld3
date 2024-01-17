package com.example.turismtown.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turismtown.R
import com.example.turismtown.model.PlaceItem
import com.squareup.picasso.Picasso

class PlacesAdapter(
    private val onItemClicked: (PlaceItem) -> Unit,
    private val placesList: ArrayList<PlaceItem>
) :
    RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_place_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placesList[position]
        holder.itemView.setOnClickListener { onItemClicked(placesList[position]) }
        holder.bind(place)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.name_tv)
        private var climateTextView: TextView = itemView.findViewById(R.id.climate_tv)
        private var placeImageView: ImageView = itemView.findViewById(R.id.picture_iv)
        fun bind(place: PlaceItem) {
            nameTextView.text = place.placeName
            climateTextView.text = place.weather
            Picasso.get().load(place.imageUrl).into(placeImageView)

        }
    }

}