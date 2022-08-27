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
import com.tuwiq.hotels.R
import com.tuwiq.hotels.databinding.FragmentHotelsDetailsBinding
import com.tuwiq.hotels.model.Hotel
import com.tuwiq.hotels.viewModel.SharedViewModel


class HotelsDetailsFragment : Fragment() {
    private var _binding: FragmentHotelsDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_hotels_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedviewModel = viewModel
            detailsFragment = this@HotelsDetailsFragment
        }

        viewModel.imageHotel.observe(viewLifecycleOwner) { image ->
            binding.imageHotel.setImageResource(image)
        }

    }


    fun goToNextScreen() {
        viewModel.setRoom(1)
        findNavController().navigate(R.id.action_hotelsFragment_to_roomFragment2)
    }

    fun cancelOrder() {
        viewModel.resetOrder()
        findNavController().navigate(R.id.action_hotelsFragment_to_citiesFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}