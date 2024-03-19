package com.example.bcasyariah.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bcasyariah.R

class DashboardMenuAdapter(private val context:Context):BaseAdapter() {
    private var layoutInflater: LayoutInflater? =null
    override fun getCount(): Int {
        return 0
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
        return bindingView
    }
}