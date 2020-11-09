package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import com.example.login.Restaurant as Restaurant1


class DetalheFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topImage = view.findViewById<ImageView>(R.id.img_tumbnail_detalhe)
        val restaurantName = view.findViewById<TextView>(R.id.txt_title_detalhe)
        val navController = Navigation.findNavController(view)
        val plateList = arguments?.getStringArrayList("PLATE_LIST")

        restaurantName.text = arguments?.getString("TITLE")
        arguments?.getInt("IMAGE")?.let { Picasso.get().load(it).into(topImage) }

        view.findViewById<ImageView>(R.id.img_back_detalhe).setOnClickListener {
            navController.navigate(R.id.action_detalheFragment_to_restaurantListFragment)
        }
    }
}