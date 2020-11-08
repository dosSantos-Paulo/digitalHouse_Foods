package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantListAdapter(
    private val dataSet: List<Restaurant>
):RecyclerView.Adapter<RestaurantListAdapter.meuViewHolder>() {

    class meuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.img_tumbnail_restaurantCardBox)
        private val title: TextView = view.findViewById(R.id.txt_title_restaurantCardBox)
        private val address: TextView = view.findViewById(R.id.txt_address_restaurantCardBox)
        private val closedAt: TextView = view.findViewById(R.id.txt_hour_restaurantCardBox)

        fun bind(restaurant: Restaurant) {

//            Picasso.get().load(restaurant.imageUrl).into(image)
            title.text = restaurant.title
            address.text = restaurant.address
            closedAt.text = restaurant.closedAt
        }
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_cardbox, parent, false)

        return meuViewHolder(view)
    }
}