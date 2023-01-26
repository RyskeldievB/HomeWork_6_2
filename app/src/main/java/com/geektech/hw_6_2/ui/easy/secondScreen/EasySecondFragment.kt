package com.geektech.hw_6_2.ui.easy.secondScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.hw_6_2.databinding.FragmentEasySecondBinding
import com.geektech.hw_6_2.ui.easy.firstScreen.EasyFirstFragment.Companion.EASY_SELECTED_IMAGES
import com.geektech.hw_6_2.ui.easy.secondScreen.adapter.EasySecondAdapter


class EasySecondFragment : Fragment() {
    private lateinit var binding: FragmentEasySecondBinding
    private val adapter by lazy { EasySecondAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEasySecondBinding.inflate(inflater, container, false)
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
        val data = arguments?.getStringArrayList(EASY_SELECTED_IMAGES)
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