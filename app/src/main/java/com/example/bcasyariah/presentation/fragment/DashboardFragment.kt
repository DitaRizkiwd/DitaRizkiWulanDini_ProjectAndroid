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
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.model.AccountBalanceModel
import com.example.bcasyariah.model.MenuDasboard
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.PromoModel
import com.example.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.example.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.bcasyariah.presentation.fragment.adapter.PromoAdapter
import com.example.bcasyariah.presentation.viewmodel.DashboardViewModel
import com.example.bcasyariah.utils.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment: BaseFragment<FragmentDashboardBinding>() {

//    lateinit var untuk meng inisialisasi nilai pada konstruktor
    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountNumberAdapter
    private lateinit var promoAdapter: PromoAdapter

    private val viewModel :DashboardViewModel by viewModels()

    private val horizontalItemDocaration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true
        )
    }
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
     return FragmentDashboardBinding.inflate(inflater,container,false)
    }


    override fun setupView() {
        setUpPromo()

        viewModel.getHomeMenu()
        viewModel.getAccountBalance()
        observeViewModel()
    }

//    baca live data : viewlifecycleowner
    private fun observeViewModel(){
        viewModel.homeMenu.observe(viewLifecycleOwner){
            setUpViewMenu(it.data)
        }
        viewModel.accountBalance.observe(viewLifecycleOwner){
            setUpViewAccountNumber(it)
        }
    }
    private fun setUpViewMenu(data :List<MenuDasboard>?){
//        if(data.isNullOrEmpty()){
//
//        }
//        else{
//
//        }
        menuAdapter = DashboardMenuAdapter(
            menuData =data?: listOf(),
            context = binding.root.context
        )
        binding.componenmenu.gridMenu.adapter=menuAdapter
        binding.componenmenu.gridMenu.onItemClickListener=AdapterView.OnItemClickListener{
                _,_, position, _ ->
            Toast.makeText(
                binding.root.context,
                data?.get(position)?.NameMenu,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun setUpViewAccountNumber(data:List<AccountBalanceModel>){
        accountAdapter = AccountNumberAdapter(data)
        binding.componenbalance.rvAccountBalance.adapter = accountAdapter
        // setting orientasi recycle view menjadi horizontal
        binding.componenbalance.rvAccountBalance.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL,false
        )
        binding.componenbalance.rvAccountBalance.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDocaration)
            }
        }
    }
    private fun setUpPromo(){
        promoAdapter = PromoAdapter(data=populateImagePromo())
        binding.componenpromo.rvpromo.adapter = promoAdapter
        binding.componenpromo.rvpromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL,false
        )
        binding.componenpromo.rvpromo.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDocaration)
            }
        }

    }


    private fun populateImagePromo(): List<PromoModel>{
        return listOf(
            PromoModel(
                imagePromo = R.drawable.image1
            ),
            PromoModel(
                imagePromo = R.drawable.image2
            ),
            PromoModel(
                imagePromo = R.drawable.image3
            ),
            PromoModel(
                imagePromo = R.drawable.image4
            ),
            PromoModel(
                imagePromo = R.drawable.image5
            )

        )
    }

}