package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
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

        val img = view.findViewById<ImageView>(R.id.img_tumbnail_detalhe)
        val navController = Navigation.findNavController(view)

        view.findViewById<ImageView>(R.id.img_back_detalhe).setOnClickListener {
            navController.navigate(R.id.action_detalheFragment_to_restaurantListFragment)
        }
    }
}