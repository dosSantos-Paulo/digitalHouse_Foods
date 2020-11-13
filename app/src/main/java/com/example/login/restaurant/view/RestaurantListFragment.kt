package com.example.login.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.restaurant.model.FoodPlate
import com.example.login.restaurant.model.Restaurant
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_FOOD_LIST
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_IMAGE
import com.example.login.restaurant.view.DetalheFragment.Companion.KEY_TITLE

class RestaurantListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plate1 = FoodPlate(
            R.mipmap.ic_oayoma_tumbnail,
            getString(R.string.title_plate1),
            getString(R.string.description_plate1)
        )

        val plate2 = FoodPlate(
            R.mipmap.ic_sisenor_tumbnail,
            getString(R.string.title_plate2),
            getString(R.string.description_plate1)
        )

        val plate3 = FoodPlate(
            R.mipmap.ic_outback_tumbnail,
            getString(R.string.title_plate3),
            getString(R.string.description_plate1)
        )

        val restaurant1 = Restaurant(
            R.mipmap.ic_tonny_tumbnail,
            getString(R.string.rest1_name),
            getString(R.string.rest1_address),
            getString(R.string.rest1_closed),
            listOf(plate1, plate3, plate2, plate1)
        )

        val restaurant2 = Restaurant(
            R.mipmap.ic_oayoma_tumbnail,
            getString(R.string.rest2_name),
            getString(R.string.rest2_address),
            getString(R.string.rest2_closed),
            listOf(plate2, plate3, plate1, plate2, plate1, plate3, plate2, plate2, plate1, plate3, plate3)
        )

        val restaurant3 = Restaurant(
            R.mipmap.ic_outback_tumbnail,
            getString(R.string.rest3_name),
            getString(R.string.rest3_address),
            getString(R.string.rest3_closed),
            listOf(plate3, plate1, plate2, plate2, plate1, plate3, plate2, plate3, plate1, plate3, plate1)
        )

        val restaurant4 = Restaurant(
            R.mipmap.ic_sisenor_tumbnail,
            getString(R.string.rest4_name),
            getString(R.string.rest4_address),
            getString(R.string.rest4_closed),
            listOf(plate1, plate2, plate3)
        )

        val navController = Navigation.findNavController(view)
        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_restaurantList)
        val viewAdapter =
            restaurantAdapter(restaurant1, restaurant2, restaurant3, restaurant4, navController)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun restaurantAdapter(
        restaurant1: Restaurant,
        restaurant2: Restaurant,
        restaurant3: Restaurant,
        restaurant4: Restaurant,
        navController: NavController,
    ): RestaurantListAdapter {
        return RestaurantListAdapter(arrayListOf(restaurant1,
            restaurant2,
            restaurant3,
            restaurant4)) {
            val bundle = bundleOf(
                KEY_TITLE to it.title,
                KEY_IMAGE to it.imageUrl,
                KEY_FOOD_LIST to it.foodList
            )
            navController.navigate(R.id.action_restaurantListFragment_to_detalheFragment, bundle)
        }
    }
}