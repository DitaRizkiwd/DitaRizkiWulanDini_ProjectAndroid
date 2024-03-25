package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment: BaseFragment<FragmentHistoryBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater,container,false)
    }

    override fun setupView() {

    }

}