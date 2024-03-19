package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.adapter.ListTransactionAdapter
import com.example.bcasyariah.databinding.ActivityTransaksiBinding
import com.example.bcasyariah.model.TransactionModel

class TransaksiActivity:AppCompatActivity() {
    private lateinit var binding: ActivityTransaksiBinding
    private var transactionAdapter=ListTransactionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTransaksiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvlistTransaction.adapter=transactionAdapter
        transactionAdapter.setData(createDummyTransaction())
        transactionAdapter.setonClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }
    }
    private fun navigateToDetailTransaction(data:TransactionModel){
        val intent = Intent(this,DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY,data)
        startActivity(intent)

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
    companion object{
        const val TRANSACTION_KEY ="transaction_key"
    }

}