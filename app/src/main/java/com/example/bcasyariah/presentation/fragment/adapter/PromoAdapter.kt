package com.example.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemPromoBinding
import com.example.bcasyariah.model.PromoModel

class PromoAdapter(private val data:List<PromoModel>)
    :RecyclerView.Adapter<PromoAdapter.promoViewHolder>(){

        inner class promoViewHolder(
            val binding :ItemPromoBinding
        ):RecyclerView.ViewHolder(binding.root){
            fun bind(data:PromoModel){
                binding.imagepromo.setImageResource(data.imagePromo)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): promoViewHolder {
        return promoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=data.size
    override fun onBindViewHolder(holder: promoViewHolder, position: Int) {
        holder.bind(data[position])
    }
}