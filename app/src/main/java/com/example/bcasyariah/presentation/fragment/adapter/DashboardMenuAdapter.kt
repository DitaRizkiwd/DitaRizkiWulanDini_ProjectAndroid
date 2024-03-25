package com.example.bcasyariah.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bcasyariah.R
import com.example.bcasyariah.model.MenuDasboard
import com.example.bcasyariah.model.MenuDashboardModel

class DashboardMenuAdapter(
    private val menuData:List<MenuDasboard>,
    private val context:Context)
    :BaseAdapter() {
        private var image :ImageView?=null
        private var textMenu : TextView? =null
        private var layoutInflater: LayoutInflater? =null
    override fun getCount(): Int {
        return menuData.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {
        var bindingView = convertView
        if(layoutInflater==null){
            layoutInflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (bindingView ==null){
            bindingView=layoutInflater?.inflate(R.layout.item_menu_dashboard,null)
        }
        image = bindingView?.findViewById(R.id.ivmenuT)
        textMenu = bindingView?.findViewById(R.id.tvmenuT)

//        untuk mendapatkan data dari list berdasarkan posisi
        val resultMenu = menuData[position]

//        untuk melakukan set pada masing masing componen di layout
       // image?.setImageResource(resultMenu.ImageMenu)
        textMenu?.text = resultMenu.NameMenu

        return bindingView
    }
}