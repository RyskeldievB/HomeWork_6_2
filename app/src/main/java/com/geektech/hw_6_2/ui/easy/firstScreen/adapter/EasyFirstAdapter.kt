package com.geektech.hw_6_2.ui.easy.firstScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.hw_6_2.databinding.ItemFirstEasyBinding

class EasyFirstAdapter(val onItemClick: (url: String) -> Unit) :
    Adapter<EasyFirstAdapter.EasyFirstViewHolder>() {

    private val data = arrayListOf(
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
        "https://i.pinimg.com/474x/2b/dc/6f/2bdc6f7fc1ed0660a2dc205c3217670d.jpg",
        "https://i.pinimg.com/474x/8e/ce/a9/8ecea9ce11cfa6106c0977d940358307.jpg",
        "https://i.pinimg.com/564x/2a/8e/af/2a8eafa61a9016cd0e67435148dcd3dd.jpg",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EasyFirstViewHolder {
        return EasyFirstViewHolder(
            ItemFirstEasyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: EasyFirstViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class EasyFirstViewHolder(private val binding: ItemFirstEasyBinding) :
        ViewHolder(binding.root) {
        fun bind(url: String) {
            with(binding) {
                ivImage.load(url)
                ivImage.setOnClickListener {
                    if (ivFade.visibility == View.GONE) {
                        ivFade.visibility = View.VISIBLE
                        onItemClick(url)
                    }
                }
            }
        }
    }
}