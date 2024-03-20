package com.example.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemAccountBalanceBinding
import com.example.bcasyariah.model.AccountBalanceModel

class AccountNumberAdapter(private val data: List<AccountBalanceModel>) :
    RecyclerView.Adapter<AccountNumberAdapter.AccountNumberViewHolder>() {


    inner class AccountNumberViewHolder(
        val binding: ItemAccountBalanceBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AccountBalanceModel) {
            binding.tvsavingtype.text = data.savingType
            binding.tvnorek.text = data.noRek.toString()
            binding.tvbalancenumber.text = data.balanceAmout
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return AccountNumberViewHolder(
            ItemAccountBalanceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(data[position])
    }
}