package com.example.login.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.login.R
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_DESCRIPTION
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_IMAGE
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_TITLE
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

        val plateImage = view.findViewById<ImageView>(R.id.img_tumbnail_foodPlate)
        val plateTitle = view.findViewById<TextView>(R.id.txt_title_foodPlate)
        val plateDescription = view.findViewById<TextView>(R.id.txt_description_foodPlate)
        val navController = Navigation.findNavController(view)

        arguments?.getInt(KEY_IMAGE)?.let { Picasso.get().load(it).into(plateImage) }
        plateTitle.text = arguments?.getString(KEY_TITLE)
        plateDescription.text = arguments?.getString(KEY_DESCRIPTION)

        view.findViewById<ImageView>(R.id.img_back_plate).setOnClickListener {
            navController.popBackStack()
        }

    }
}