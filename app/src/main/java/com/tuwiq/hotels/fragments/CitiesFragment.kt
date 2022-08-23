package com.tuwiq.hotels.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwiq.hotels.R
import com.tuwiq.hotels.adapter.CitiesAdapter
import com.tuwiq.hotels.dataSource.Data
import com.tuwiq.hotels.databinding.FragmentCitiesBinding


class CitiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities, container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val listCities = Data().loadCitiesImages()
        recyclerView = binding.recyclerCities
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CitiesAdapter(listCities )

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}