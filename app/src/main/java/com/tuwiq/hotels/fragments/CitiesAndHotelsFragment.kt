package com.tuwiq.hotels.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwiq.hotels.R
import com.tuwiq.hotels.adapter.CitiesAndHotelsAdapter
import com.tuwiq.hotels.dataSource.Data
import com.tuwiq.hotels.databinding.FragmentCitiesAndHotelsBinding
import com.tuwiq.hotels.viewModel.SharedViewModel


class CitiesAndHotelsFragment : Fragment() {

    private lateinit var recyclerViewLondon: RecyclerView
    private lateinit var recyclerViewMaldives: RecyclerView
    private lateinit var recyclerViewAmsterdam: RecyclerView
    private lateinit var recyclerViewMadrid: RecyclerView
    private var _binding: FragmentCitiesAndHotelsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cities_and_hotels, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listLondonHotels = Data().loadLondon()
        val listMaldivesHotels = Data().loadMaldives()
        val listAmsterdamHotels = Data().loadAmsterdam()
        val listMadridHotels = Data().loadMadrid()

        binding.sharedViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        recyclerViewLondon = binding.recyclerLondon
        recyclerViewMaldives = binding.recyclerMaldives
        recyclerViewAmsterdam = binding.recyclerAmsterdam
        recyclerViewMadrid = binding.recyclerMadrid

        recyclerViewLondon.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewMaldives.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAmsterdam.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewMadrid.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        recyclerViewLondon.adapter = CitiesAndHotelsAdapter(viewModel, listLondonHotels)
        recyclerViewMaldives.adapter = CitiesAndHotelsAdapter(viewModel, listMaldivesHotels)
        recyclerViewAmsterdam.adapter = CitiesAndHotelsAdapter(viewModel, listAmsterdamHotels)
        recyclerViewMadrid.adapter = CitiesAndHotelsAdapter(viewModel, listMadridHotels)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}