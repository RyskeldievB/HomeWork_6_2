package com.geektech.hw_6_2.ui.easy.firstScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geektech.hw_6_2.R
import com.geektech.hw_6_2.databinding.FragmentEasyFirstBinding
import com.geektech.hw_6_2.ui.easy.firstScreen.adapter.EasyFirstAdapter

class EasyFirstFragment : Fragment() {
    private lateinit var binding: FragmentEasyFirstBinding
    private val selectedImages = arrayListOf<String>()
    private val adapter by lazy { EasyFirstAdapter(this::onItemClick) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEasyFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClicker()
    }


    private fun initAdapter() {
        binding.rvPhoto.adapter = adapter
    }

    private fun initClicker() {
        binding.btnSelect.setOnClickListener {
            findNavController().navigate(
                R.id.easySecondFragment,
                bundleOf(EASY_SELECTED_IMAGES to selectedImages.toString())
            )
        }
    }

    private fun onItemClick(url: String) {
        selectedImages.add(url)
        if (selectedImages.size > 0) {
            binding.btnSelect.visibility = View.VISIBLE
        } else {
            binding.btnSelect.visibility = View.GONE
        }
    }

    companion object {
        const val EASY_SELECTED_IMAGES = "selected.images"
    }
}