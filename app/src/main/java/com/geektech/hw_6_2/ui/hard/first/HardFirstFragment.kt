package com.geektech.hw_6_2.ui.hard.first

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.hw_6_2.R
import com.geektech.hw_6_2.databinding.FragmentHardFirstBinding
import com.geektech.hw_6_2.ui.hard.first.adapter.HardFirstAdapter
import com.google.android.material.snackbar.Snackbar

class HardFirstFragment : Fragment() {

    private lateinit var binding: FragmentHardFirstBinding
    private val adapter by lazy { HardFirstAdapter(this::onItemClick) }
    private val selectedImages = arrayListOf<String>()
    private var isImagePermissionGranted = false
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                isImagePermissionGranted = true
            }
        }
    private val pickMultipleMedia =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia()) { uris ->
            if (uris.isNotEmpty()) {
                adapter.addData(uris)
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHardFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        requestPermission()
    }

    private fun initAdapter() {
        binding.rvPhoto.adapter = adapter

    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            isImagePermissionGranted = ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_MEDIA_IMAGES
            ) == PackageManager.PERMISSION_GRANTED

            if (!isImagePermissionGranted) {
                requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
            } else {
                pickMultipleMedia.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }
        }
    }

    private fun onItemClick(uri: Uri) {
        selectedImages.add(uri.toString())
        val snackbar =
            Snackbar.make(requireView(), "Выбрано ${selectedImages.size} фотографии", Snackbar.LENGTH_LONG)
        snackbar.setAction("Готово") {
            findNavController().navigate(
                R.id.hardSecondFragment,
                bundleOf(HARD_SELECTED_IMAGES to selectedImages)
            )
        }
        snackbar.show()
    }

    companion object {
        const val HARD_SELECTED_IMAGES = "hard.selected.images"
    }
}