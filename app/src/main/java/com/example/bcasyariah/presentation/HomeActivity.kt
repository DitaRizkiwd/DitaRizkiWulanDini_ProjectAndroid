package com.example.bcasyariah.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityHomeBinding
import com.example.bcasyariah.presentation.fragment.AdminFragment
import com.example.bcasyariah.presentation.fragment.DashboardFragment
import com.example.bcasyariah.presentation.fragment.InboxFragment
import com.example.bcasyariah.presentation.fragment.MessageFragment
import com.example.bcasyariah.utils.ConfirmationDialogUtil
import com.example.bcasyariah.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil
    private lateinit var sharePref : SharePrefHelper
    private val onNavigationItemSelectedListener=
        BottomNavigationView.OnNavigationItemSelectedListener{item->
            when(item.itemId){
                R.id.navigationHome->{
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationInbox->{
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationAdmin->{
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationMessage->{
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationLogout-> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false

                }

            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)
        confirmationDialogUtil = ConfirmationDialogUtil(this)


        binding.bottomNavigation.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)
        if (savedInstanceState==null){
            binding.bottomNavigation.selectedItemId=R.id.navigationHome
        }
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
    private fun showConfirmation(){
        val title = "Apakah anda ingin keluar ?"
        val icon =R.drawable.bcasyariaha

        confirmationDialogUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                finish()
            },
            onCancel = {

            }

        )
    }
}