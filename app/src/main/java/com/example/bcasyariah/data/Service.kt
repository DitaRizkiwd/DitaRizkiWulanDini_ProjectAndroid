package com.example.bcasyariah.data

import com.example.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {

//    ini untuk ke server
//    retrofit : komunikasi ke http request
    @GET("menu-dahsboard")
    suspend fun getHomeMenu() : Response<MenuDashboardResponse>
}