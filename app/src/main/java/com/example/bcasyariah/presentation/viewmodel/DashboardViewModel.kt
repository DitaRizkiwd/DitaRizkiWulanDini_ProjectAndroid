package com.example.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.R
import com.example.bcasyariah.model.AccountBalanceModel
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.PromoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _homeMenu = MutableLiveData<List<MenuDashboardModel>>()
    private val _accountBalance = MutableLiveData<List<AccountBalanceModel>>()
    private val _promo = MutableLiveData<List<PromoModel>>()

//    untu membawa data dari variabel private
    val homeMenu: LiveData<List<MenuDashboardModel>>
        get()= _homeMenu

    val accountBalance:LiveData<List<AccountBalanceModel>>
        get()= _accountBalance

    val promo: LiveData<List<PromoModel>>
        get() = _promo
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

    private fun populateDataAccountNumber(): List<AccountBalanceModel>{
        return listOf(
            AccountBalanceModel(
                savingType = "Tahapan Wadiah Non Bonus",
                noRek = 121343535,
                balanceAmout = "Rp. 30.000.000"
            ),
            AccountBalanceModel(
                savingType = "Tahapan Wadiah Non Bonus",
                noRek = 121343535,
                balanceAmout = "Rp. 30.000.000"
            ),
            AccountBalanceModel(
                savingType = "Tahapan Wadiah Non Bonus",
                noRek = 121343535,
                balanceAmout = "Rp. 30.000.000"
            )
        )
    }

    fun getHomeMenu() =viewModelScope.launch(Dispatchers.IO){
        _homeMenu.postValue(populatedataView())
    }
    fun getAccountBalance()=viewModelScope.launch (Dispatchers.IO){
        _accountBalance.postValue(populateDataAccountNumber())
    }


}