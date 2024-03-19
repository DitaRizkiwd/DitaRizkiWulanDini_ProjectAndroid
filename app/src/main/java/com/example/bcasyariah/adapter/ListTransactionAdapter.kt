package com.example.bcasyariah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemListTransaksiBinding
import com.example.bcasyariah.model.TransactionModel

class ListTransactionAdapter: RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {
    private var _data:MutableList<TransactionModel> = mutableListOf()
    private var _onClickTransaction:(TransactionModel)->Unit={

    }
    fun setData(newData:MutableList<TransactionModel>){
        _data = newData
        notifyDataSetChanged()
    }
    fun setonClickTransaction(listener:(TransactionModel)->Unit){
        _onClickTransaction =listener
    }
    inner class TransactionViewHolder(private val binding: ItemListTransaksiBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: TransactionModel, onClickTransaction: (TransactionModel) -> Unit){
            binding.tvTransfertype.text=item.trasfertype
            binding.tvTransferdestination.text=item.transferDestination
            binding.tvdate.text=item.date
            binding.tvamount.text=item.amount.toString()
            binding.tvstatus.text=item.transferStatus
//            invoke untuk callback terhadap item
            binding.root.setOnClickListener{
                onClickTransaction.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(ItemListTransaksiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position],_onClickTransaction)
    }

}