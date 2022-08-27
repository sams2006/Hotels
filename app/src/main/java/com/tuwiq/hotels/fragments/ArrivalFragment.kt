package com.tuwiq.hotels.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.tuwiq.hotels.R
import com.tuwiq.hotels.databinding.FragmentArrivalBinding
import com.tuwiq.hotels.databinding.FragmentRoomBinding
import com.tuwiq.hotels.viewModel.SharedViewModel


class ArrivalFragment : Fragment() {

    private var _binding: FragmentArrivalBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_arrival, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedviewModel = viewModel
            arrivalFragment = this@ArrivalFragment
        }


    }

    fun goToNextScreen() {

        findNavController().navigate(R.id.action_arrivalFragment_to_bookingFragment)
    }

    fun cancelOrder() {

        viewModel.resetOrder()
        findNavController().navigate(R.id.action_arrivalFragment_to_citiesFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

