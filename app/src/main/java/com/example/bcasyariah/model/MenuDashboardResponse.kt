package com.example.bcasyariah.model

import com.google.gson.annotations.SerializedName

data class MenuDashboardResponse (
    @SerializedName("data")
    val data:List<MenuDasboard>
)

data class MenuDasboard(
    @SerializedName("image_menu")
    val ImageMenu: String?,
    @SerializedName("name_menu")
    val NameMenu: String?
)