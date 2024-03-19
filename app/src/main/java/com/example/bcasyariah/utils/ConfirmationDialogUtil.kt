package com.example.bcasyariah.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.DialogueLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {
    fun showConfirmationDialog(title: String,
                               icon:Int?=null,
                               onConfirm:()->Unit,
                               onCancel:()->Unit){
        val dialogBuilder= AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView =LayoutInflater.from(context).inflate(R.layout.dialogue_layout,null)
        val binding =DialogueLayoutBinding.bind(dialogView)
        binding.tvlog.text =title

        if(icon != null){
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        }
        else{
            binding.ivIconDialog.visibility=View.GONE
        }
        alertDialog.setView(dialogView)
        binding.yesbtn.setOnClickListener{
            onConfirm.invoke()
            alertDialog.dismiss()
        }
        binding.nobtn.setOnClickListener {
            onCancel.invoke()
            alertDialog.dismiss()}
        alertDialog.show()
    }

}