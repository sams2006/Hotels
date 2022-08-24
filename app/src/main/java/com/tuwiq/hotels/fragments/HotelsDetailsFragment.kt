package com.tuwiq.hotels.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tuwiq.hotels.R
import com.tuwiq.hotels.databinding.FragmentCitiesBinding
import com.tuwiq.hotels.databinding.FragmentHotelsBinding


class HotelsDetailsFragment : Fragment() {
    private var _binding: FragmentHotelsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotels, container, false)
        return binding.root
    }


}