package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class PlaceRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_registration)

        val registerButton: Button = findViewById(R.id.btn_register)
        val namePlaceET: EditText = findViewById(R.id.et_name_place)
        val infoTV: TextView = findViewById(R.id.tv_info)
        val countryET: TextInputEditText = findViewById(R.id.et_country)
        val hotRB: RadioButton = findViewById(R.id.rb_hot)
        val coldRB: RadioButton = findViewById(R.id.rb_cold)
        val cultureCB: CheckBox = findViewById(R.id.cb_culture)
        val adventureCB: CheckBox = findViewById(R.id.cb_adventure)
        val natureCB: CheckBox = findViewById(R.id.cb_nature)
        val architectureCB: CheckBox = findViewById(R.id.cb_architecture)
        val eventsCB: CheckBox = findViewById(R.id.cb_events)
        val gastronomyCB: CheckBox = findViewById(R.id.cb_gastronomy)
        val typePlaceSpinner: Spinner = findViewById(R.id.spinner_type_place)

        registerButton.setOnClickListener {
            val namePlace = namePlaceET.text.toString()
            val nameCountry = countryET.text.toString()

            val weather: String = if (hotRB.isChecked) getString(R.string.hot)
            else getString(R.string.cold)

            var themes = ""
            if (cultureCB.isChecked) themes = themes + ", " + getString(R.string.culture)
            if (adventureCB.isChecked) themes = themes + ", " + getString(R.string.adventure)
            if (natureCB.isChecked) themes = themes + ", " + getString(R.string.nature)
            if (architectureCB.isChecked) themes = themes + ", " + getString(R.string.archiquecture)
            if (eventsCB.isChecked) themes = themes + ", " + getString(R.string.events)
            if (gastronomyCB.isChecked) themes = themes + ", " + getString(R.string.gastronomy)

            val typeOfPlace = typePlaceSpinner.selectedItem.toString()

            infoTV.text = getString(
                R.string.info_text,
                namePlace,
                nameCountry,
                getString(R.string.weatherIs),
                weather,
                themes,
                typeOfPlace
            )

            val place = Place(namePlace, nameCountry, weather, themes, typeOfPlace, "https://fedelsahostels.com/wp-content/uploads/2020/07/Copy-of-org_c7f0aa8f36491f97_1537962468000-e1598367187404-1.jpg")

        }

    }
}