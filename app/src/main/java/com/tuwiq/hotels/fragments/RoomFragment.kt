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
import com.tuwiq.hotels.databinding.FragmentHotelsDetailsBinding
import com.tuwiq.hotels.databinding.FragmentRoomBinding
import com.tuwiq.hotels.viewModel.SharedViewModel


class RoomFragment : Fragment() {
    private var _binding: FragmentRoomBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedviewModel = viewModel
            roomFragment = this@RoomFragment
        }


    }

    fun goToNextScreen() {
         viewModel.setDate(viewModel.dateOptions[0])
        findNavController().navigate(R.id.action_roomFragment2_to_arrivalFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}