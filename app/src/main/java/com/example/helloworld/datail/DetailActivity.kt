package com.example.helloworld.datail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityDetailBinding
import com.example.helloworld.model.PlaceItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val place: PlaceItem = intent.extras?.getSerializable("place") as PlaceItem
        with(detailBinding) {
            namePlaceTv.text = place.placeName
            descriptionPlaceTv.text = place.typeOfPlace
            Picasso.get().load(place.imageUrl).into(imagePlaceTv)
        }
    }
}
//config develop