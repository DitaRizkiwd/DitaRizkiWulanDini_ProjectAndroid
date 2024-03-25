package com.example.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.databinding.FragmentAdminBinding
import com.example.bcasyariah.presentation.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminFragment:Fragment() {
    private var _binding:FragmentAdminBinding?=null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdminBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getName = getActivity()?.getIntent()?.getStringExtra(LoginActivity.key_name)
//        binding.vComponenTopBar.tvtitle.text="Profile Feature"
//        binding.vComponenTopBar.Ivback.setOnClickListener(){
////            onBackPressed()
//        }


    }

}