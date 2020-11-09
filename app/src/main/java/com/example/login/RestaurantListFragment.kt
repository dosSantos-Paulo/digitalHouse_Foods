package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plate1 = FoodPlate(
            R.mipmap.ic_oayoma_tumbnail,
            "Salada com molho de gengibre"
        )

        val restaurant1 = Restaurant(
            R.mipmap.ic_tonny_tumbnail,
            "Tony Roma's",
            "Av. Lavandisca, 717, Indianápolis, São Paulo",
            "Fecha às 22:00",
            listOf(plate1, plate1, plate1, plate1)
        )

        val restaurant2 = Restaurant(
            R.mipmap.ic_oayoma_tumbnail,
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            listOf(plate1, plate1)
        )

        val restaurant3 = Restaurant(
            R.mipmap.ic_outback_tumbnail,
            "Outback - Moema",
            "Av. Moaci, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            listOf(plate1, plate1, plate1, plate1, plate1, plate1, plate1, plate1)
        )

        val restaurant4 = Restaurant(
            R.mipmap.ic_sisenor_tumbnail,
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            listOf(plate1, plate1, plate1)
        )

        val navController = Navigation.findNavController(view)
        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_restaurantList)
        val viewAdapter = RestaurantListAdapter(arrayListOf(restaurant1,restaurant2,restaurant3,restaurant4)){
            val bundle = bundleOf(
                "TITLE" to it.title,
                "IMAGE" to it.imageUrl,
                "FOOD_LIST" to it.foodList
            )
            navController.navigate(R.id.action_restaurantListFragment_to_detalheFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}