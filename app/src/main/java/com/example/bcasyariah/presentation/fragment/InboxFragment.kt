package com.example.bcasyariah.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.adapter.ListTransactionAdapter
import com.example.bcasyariah.databinding.FragmentInboxBinding
import com.example.bcasyariah.model.TransactionModel
import com.example.bcasyariah.presentation.DetailTransactionActivity
import com.example.bcasyariah.presentation.TransaksiActivity

class InboxFragment:Fragment() {
    private var _binding:FragmentInboxBinding?=null
    private val binding get()= _binding!!
    private var transactionAdapter= ListTransactionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvlistTransaction.adapter=transactionAdapter
        transactionAdapter.setData(createDummyTransaction())
        transactionAdapter.setonClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }
    }
    private fun navigateToDetailTransaction(data:TransactionModel){
        val intent = Intent(getActivity(), DetailTransactionActivity::class.java)
        intent.putExtra(TransaksiActivity.TRANSACTION_KEY,data)
        startActivity(intent)
//
//
    }
    private fun createDummyTransaction():MutableList<TransactionModel>{
        return mutableListOf(
            TransactionModel(
                trasfertype = "Pembayaran Qr",
                transferDestination = "Mandiri",
                date = "13/03/2024",
                transferStatus = "Failed",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
            TransactionModel(
                trasfertype = "Pembayaran Qr lagi",
                transferDestination = "bcasyariah",
                date = "13/03/2024",
                transferStatus = "success",
                amount = 20000.00
            ),
        )

    }
}