package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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

        val restaurant1 = Restaurant(
            "Nothing",
            "Tony Roma's",
            "Av. Lavandisca, 717, Indianápolis, São Paulo",
            "Fecha às 22:00"
        )

        val restaurant2 = Restaurant(
            "Nothing",
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00"
        )

        val restaurant3 = Restaurant(
            "Nothing",
            "Outback - Moema",
            "Av. Moaci, 187 - Moema, São Paulo",
            "Fecha às 00:00"
        )

        val restaurant4 = Restaurant(
            "Nothing",
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00"
        )

        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_restaurantList)
        val viewAdapter = RestaurantListAdapter(arrayListOf(restaurant1,restaurant2,restaurant3,restaurant4))

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}