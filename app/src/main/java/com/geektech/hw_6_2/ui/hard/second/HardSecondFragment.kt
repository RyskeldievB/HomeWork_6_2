package com.geektech.hw_6_2.ui.hard.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.hw_6_2.databinding.FragmentHardSecondBinding
import com.geektech.hw_6_2.ui.hard.first.HardFirstFragment.Companion.HARD_SELECTED_IMAGES
import com.geektech.hw_6_2.ui.hard.second.adapter.HardSecondAdapter

class HardSecondFragment : Fragment() {
    private lateinit var binding: FragmentHardSecondBinding
    private val adapter by lazy { HardSecondAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHardSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addData()
        initClicker()
    }

    private fun initAdapter() {
        binding.rvPhoto.adapter = adapter
    }

    private fun addData() {
        val data = arguments?.getStringArrayList(HARD_SELECTED_IMAGES)
        if (data != null) {
            adapter.addData(data)
        }
    }

    private fun initClicker() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}