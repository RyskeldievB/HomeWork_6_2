package com.geektech.hw_6_2.ui.hard.second.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.hw_6_2.databinding.ItemSecondHardBinding

class HardSecondAdapter :
    Adapter<HardSecondAdapter.HardSecondViewHolder>() {

    private val data = arrayListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newData:List<String>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HardSecondViewHolder {
        return HardSecondViewHolder(
            ItemSecondHardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HardSecondViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class HardSecondViewHolder(private val binding: ItemSecondHardBinding) :
        ViewHolder(binding.root) {
        fun bind(uri: String) {
            binding.ivImage.load(uri.toUri())
        }
    }
}