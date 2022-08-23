package com.tuwiq.hotels.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tuwiq.hotels.R
import com.tuwiq.hotels.fragments.CitiesFragmentDirections

class CitiesAdapter(val dataSet: List<Int>) :
    RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    inner class CitiesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.city_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_cities_layout, parent, false)
        return CitiesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val item = dataSet[position]
        holder.imageView.setImageResource(item)
        holder.imageView.setOnClickListener {
            val action = CitiesFragmentDirections.actionCitiesFragmentToHotelsFragment()
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = dataSet.size


}