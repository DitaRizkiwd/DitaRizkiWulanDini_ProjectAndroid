package com.example.bcasyariah.presentation.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter

class DashboardFragment: BaseFragment<FragmentDashboardBinding>() {

//    lateinit var untuk meng inisialisasi nilai pada konstruktor
    private lateinit var menuAdapter: DashboardMenuAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
     return FragmentDashboardBinding.inflate(inflater,container,false)
    }


    override fun setupView() {
        menuAdapter = DashboardMenuAdapter(
            menuData =populatedataView(),
            context = binding.root.context
        )
        binding.componenmenu.gridMenu.adapter=menuAdapter
        binding.componenmenu.gridMenu.onItemClickListener=AdapterView.OnItemClickListener{
            _,_, position, _ ->
            Toast.makeText(
                binding.root.context,
                populatedataView()[position].menuName,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun populatedataView():List<MenuDashboardModel>{
        return listOf(
            MenuDashboardModel(
                image= R.drawable.telegram, menuName = "Transfer"),
            MenuDashboardModel(
                image= R.drawable.pembelian, menuName = "Pembelian"),
            MenuDashboardModel(
                image= R.drawable.pembayaran, menuName = "Pembayaran"),
            MenuDashboardModel(
                image= R.drawable.cardless, menuName = "Cardless"),
            MenuDashboardModel(
                image= R.drawable.historitransaksi, menuName = "Histori Transaksi"),
            MenuDashboardModel(
                image= R.drawable.mutasirekening, menuName = "Mutasi Rekening"),
            MenuDashboardModel(
                image= R.drawable.jadwalsholat, menuName = "Jadwal Sholat")
        )

    }
}