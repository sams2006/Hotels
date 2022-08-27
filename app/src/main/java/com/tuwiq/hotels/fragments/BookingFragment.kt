package com.tuwiq.hotels.fragments

import android.content.Intent
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
import com.tuwiq.hotels.databinding.FragmentBookingBinding
import com.tuwiq.hotels.viewModel.SharedViewModel


class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedviewModel = viewModel
            bookingFragment = this@BookingFragment

        }

    }

    fun sendOrder() {

        val numberOfNights = viewModel.quantity.value ?: 0
        val orderSummary = getString(
            R.string.booking_details,
            resources.getQuantityString(R.plurals.nights, numberOfNights, numberOfNights),
            viewModel.nameCity.value.toString(),
            viewModel.date.value.toString(),
            viewModel.total.value.toString()
        )

        // Create an ACTION_SEND implicit intent with order details in the intent extras
        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_booking_order))
            .putExtra(Intent.EXTRA_TEXT, orderSummary)

        // Check if there's an app that can handle this intent before launching it
        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            // Start a new activity with the given intent (this may open the share dialog on a
            // device if multiple apps can handle this intent)
            startActivity(intent)
        }
    }


    fun cancelOrder() {
        viewModel.resetOrder()
        findNavController().navigate(R.id.action_bookingFragment_to_citiesFragment)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}