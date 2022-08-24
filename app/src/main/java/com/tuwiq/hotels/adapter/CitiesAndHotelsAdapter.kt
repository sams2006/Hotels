package com.tuwiq.hotels.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tuwiq.hotels.R
import com.tuwiq.hotels.fragments.CitiesAndHotelsFragmentDirections
import com.tuwiq.hotels.model.Hotel

class CitiesAndHotelsAdapter(val dataSet: List<Hotel>) :
    RecyclerView.Adapter<CitiesAndHotelsAdapter.CitiesViewHolder>() {

    inner class CitiesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val hotelName:TextView = view.findViewById(R.id.text_view_hotel_name)
        val cityName:TextView = view.findViewById(R.id.text_view_city_name)
        val imageView: ImageView = view.findViewById(R.id.city_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_hotels_layout, parent, false)
        return CitiesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val item = dataSet[position]
        holder.hotelName.setText(item.nameHotel)
        holder.cityName.setText(item.nameCity)
        holder.imageView.setImageResource(item.hotelImage)
        holder.imageView.setOnClickListener {

            holder.view.findNavController().navigate(CitiesAndHotelsFragmentDirections.actionCitiesFragmentToHotelsFragment())
        }
    }

    override fun getItemCount(): Int = dataSet.size


}