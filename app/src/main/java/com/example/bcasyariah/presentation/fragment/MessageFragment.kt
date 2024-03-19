package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.adapter.MessageTabAdapter
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : BaseFragment<FragmentMessageBinding>() {
    private var adapterMessage :MessageTabAdapter?=null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        setUpTabView()
    }
    private fun setUpTabView(){
        val tabLayout =binding.tabMessage
        val viewPager =binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryFragment())
        viewPager.adapter = adapterMessage
        TabLayoutMediator(tabLayout,viewPager){
            tab, position ->
                when(position){
                    0 ->{
                        tab.text ="Notification"
                    }
                    1->{
                        tab.text ="History"
                    }
                }
        }.attach()
    }
}