package com.geektech.hw_6_2.ui.hard.first.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.geektech.hw_6_2.databinding.ItemFirstHardBinding

class HardFirstAdapter(val onItemClick: (url: Uri) -> Unit) :
    Adapter<HardFirstAdapter.HardFirstViewHolder>() {

    private val data = arrayListOf<Uri>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(newData:List<Uri>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HardFirstViewHolder {
        return HardFirstViewHolder(
            ItemFirstHardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HardFirstViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class HardFirstViewHolder(private val binding: ItemFirstHardBinding) :
        ViewHolder(binding.root) {
        fun bind(uri: Uri) {
            with(binding) {
                ivImage.load(uri)
                ivImage.setOnClickListener {
                    if (ivFade.visibility == View.GONE) {
                        ivFade.visibility = View.VISIBLE
                        onItemClick(uri)
                    }
                }
            }
        }
    }
}