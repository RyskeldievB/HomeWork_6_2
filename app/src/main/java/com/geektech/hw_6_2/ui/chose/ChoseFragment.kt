package com.geektech.hw_6_2.ui.chose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.hw_6_2.R
import com.geektech.hw_6_2.databinding.FragmentChoseBinding

class ChoseFragment : Fragment() {
    private lateinit var binding: FragmentChoseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChoseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            btnEasy.setOnClickListener {
                findNavController().navigate(R.id.easyFirstFragment)
            }
            btnHard.setOnClickListener {
                findNavController().navigate(R.id.hardFirstFragment)
            }
        }
    }
}