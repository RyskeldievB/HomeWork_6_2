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
        "https://bfoto.ru/oboi/oboi_priroda_1440x900.jpg",
        "https://bfoto.ru/images/foto-visokogo-razresheniya-more-gory-1.jpg",
        "https://bfoto.ru/images/foto-visokogo-razresheniya-more-gory-3.jpg",
        "https://bfoto.ru/news/wp-content/uploads/2017/10/fotobank-besplatno-1-250x166.jpg",
        "https://bfoto.ru/images/foto-visokogo-razresheniya-more-gory-1.jpg",
        "https://proprikol.ru/wp-content/uploads/2020/04/krasivye-kartinki-vysokogo-razresheniya-3.jpg",
        "https://funart.pro/uploads/posts/2021-03/1617075679_37-p-oboi-priroda-rossii-foto-visokogo-kachestv-38.jpg",
        "https://pibig.info/uploads/posts/2021-05/1621373530_18-pibig_info-p-priroda-rossii-priroda-krasivo-foto-18.jpg",
        "https://pw.artfile.me/wallpaper/30-09-2013/650x434/rossiya-sankt-peterburg-pavlovsk-priroda-755056.jpg"
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