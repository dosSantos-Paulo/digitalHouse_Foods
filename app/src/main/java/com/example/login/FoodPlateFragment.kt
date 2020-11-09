package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso


class FoodPlateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_plate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val plateImage = view.findViewById<ImageView>(R.id.img_tumbnail_foodPlate)
        val plateTitle = view.findViewById<TextView>(R.id.txt_title_foodPlate)
        val plateDescription = view.findViewById<TextView>(R.id.txt_description_foodPlate)

        arguments?.getInt("IMAGE")?.let { Picasso.get().load(it).into(plateImage) }
        plateTitle.text = arguments?.getString("TITLE")
        plateDescription.text = arguments?.getString("DESCRIPTION")

    }
}