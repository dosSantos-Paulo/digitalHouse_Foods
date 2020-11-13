package com.example.login.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.restaurant.model.FoodPlate
import com.squareup.picasso.Picasso


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
        val plateList = arguments?.get(KEY_FOOD_LIST)

        restaurantName.text = arguments?.getString(KEY_TITLE)
        arguments?.getInt(KEY_IMAGE)?.let { Picasso.get().load(it).into(topImage) }

        val viewManager = GridLayoutManager(view.context, 2)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_detalhe)
        val viewAdapter = PlateListAdapter(plateList as List<FoodPlate>){
            val bundle = bundleOf(
                KEY_IMAGE to it.imageUrl,
                KEY_TITLE to it.name,
                KEY_DESCRIPTION to it.description
            )
            navController.navigate(R.id.action_detalheFragment_to_foodPlateFragment, bundle)
        }

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        view.findViewById<ImageView>(R.id.img_back_detalhe).setOnClickListener {
            navController.popBackStack()
        }
    }

    companion object {
        const val KEY_FOOD_LIST = "FOOD_LIST"
        const val KEY_TITLE = "TITLE"
        const val KEY_IMAGE = "IMAGE"
        const val KEY_DESCRIPTION = "DESCRIPTION"
    }
}