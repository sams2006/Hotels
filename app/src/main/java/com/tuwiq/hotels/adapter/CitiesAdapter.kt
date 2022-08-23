package com.tuwiq.hotels.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.tuwiq.hotels.R

class CitiesAdapter( val dataSet:List<Int>, context: Context):RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    inner class CitiesViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val imageView:ImageView = view.findViewById(R.id.city_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_cities_layout , parent ,false)
        return CitiesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val item = dataSet[position]
       holder.imageView.setImageResource(item)
    }

    override fun getItemCount(): Int = dataSet.size


}