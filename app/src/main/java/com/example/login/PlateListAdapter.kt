package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlateListAdapter(
    private val dataSet: List<FoodPlate>,
    private val listener: (FoodPlate) -> Unit
): RecyclerView.Adapter<PlateListAdapter.meuViewHolder>() {

    class meuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.img_tumbnail_foodBox)
        private val name: TextView = view.findViewById(R.id.txt_foodDescription_foodBox)

        fun bind(plate: FoodPlate) {
            Picasso.get().load(plate.imageUrl).into(image)
            name.text = plate.name
        }
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_plate_box, parent, false)
        return meuViewHolder(view)
    }

}