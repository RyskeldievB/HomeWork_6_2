package com.geektech.hw_6_2.ui.easy.secondScreen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.hw_6_2.databinding.ItemSecondEasyBinding

class EasySecondAdapter :
    Adapter<EasySecondAdapter.EasySecondViewHolder>() {

    private val data = arrayListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newData:ArrayList<String>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EasySecondViewHolder {
        return EasySecondViewHolder(
            ItemSecondEasyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EasySecondViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class EasySecondViewHolder(private val binding: ItemSecondEasyBinding) :
        ViewHolder(binding.root) {
        fun bind(url: String) {
            binding.ivImage.load(url)
        }
    }
}