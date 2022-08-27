package com.tuwiq.hotels.adapter

import android.content.Context
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
import com.tuwiq.hotels.viewModel.SharedViewModel
import java.text.NumberFormat

class CitiesAndHotelsAdapter(private val viewModel: SharedViewModel ,val dataSet: List<Hotel> ) :
    RecyclerView.Adapter<CitiesAndHotelsAdapter.CitiesViewHolder>() {

    inner class CitiesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val hotelName:TextView = view.findViewById(R.id.text_view_hotel_name)
        val cityName:TextView = view.findViewById(R.id.text_view_city_name)
        val imageView: ImageView = view.findViewById(R.id.city_image)
        val textViewPriceTitle:TextView = view.findViewById(R.id.price_tex_view_title)
        val textPrice:TextView = view.findViewById(R.id.price)

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
        holder.textViewPriceTitle.setText(item.priceTitle)
        holder.textPrice.text = NumberFormat.getCurrencyInstance().format(item.price)
        holder.view.setOnClickListener {
            viewModel.getPrice(item.price)
            viewModel.getImage( item.hotelImage)
            viewModel.getNameHotel( holder.hotelName.text.toString())
            viewModel.getNameCity(holder.cityName.text.toString())
            viewModel.setQuantity(1)

            holder.view.findNavController().
            navigate(CitiesAndHotelsFragmentDirections.actionCitiesFragmentToHotelsFragment())
        }





    }

    override fun getItemCount(): Int = dataSet.size


}