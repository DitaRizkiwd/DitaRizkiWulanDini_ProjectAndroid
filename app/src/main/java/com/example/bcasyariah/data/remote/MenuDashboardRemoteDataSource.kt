package com.example.bcasyariah.data.remote
import com.example.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response

interface MenuDashboardRemoteDataSource {

    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>
}