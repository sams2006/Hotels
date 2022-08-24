package com.tuwiq.hotels.dataSource

import com.tuwiq.hotels.R
import com.tuwiq.hotels.model.Hotel

class Data {


      fun loadLondon():List<Hotel> {
           return listOf(
               Hotel(R.string.sea_container_london , R.string.london , R.drawable.sea_containers_london) ,
               Hotel(R.string.nyx_hotel_london , R.string.london , R.drawable.nyx_hotel_london) ,
               )
       }

    fun loadMaldives():List<Hotel> {
        return listOf(
            Hotel(R.string.amaya_kuda_rah_mald , R.string.maldives , R.drawable.amaya_kuda_rah_mald) ,
            Hotel(R.string.lily_beach_mald , R.string.maldives , R.drawable.lily_beach_mald) ,
        )
    }

    fun loadAmsterdam():List<Hotel> {
        return listOf(
            Hotel(R.string.eden_hotel_amsterdam , R.string.amsterdam, R.drawable.eden_hotel_amsterdam) ,
            Hotel(R.string.double_tree_amsterdam , R.string.amsterdam , R.drawable.doble_tree_by_hiliton)
        )
    }

    fun loadMadrid():List<Hotel> {
        return listOf(
            Hotel(R.string.hotel_mora_madrid , R.string.madrid , R.drawable.hotel_mora) ,
            Hotel(R.string.wellington_hotel , R.string.madrid , R.drawable.wellington_hotel) ,
        )
    }

   }
