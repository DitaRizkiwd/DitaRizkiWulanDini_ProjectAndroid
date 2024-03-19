package com.example.bcasyariah.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityDetailTransactionBinding
import com.example.bcasyariah.databinding.ActivityTransaksiBinding
import com.example.bcasyariah.model.TransactionModel
import com.example.bcasyariah.presentation.TransaksiActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)
        binding.tvdatetransaction.text = transaction?.date
        binding.tvamoutntransaction.text=transaction?.amount.toString()
        binding.tvstatustransaction.text=transaction?.transferStatus
        binding.tvtypetransaction.text=transaction?.trasfertype
        binding.tvdestinationtransaction.text=transaction?.transferDestination
    }
}