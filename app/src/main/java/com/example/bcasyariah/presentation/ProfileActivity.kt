package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.presentation.LoginActivity.Companion.key_name
import com.example.bcasyariah.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getName = intent.getStringExtra(key_name)
        binding.tvLabelName.text="Nama : "+getName
        binding.vComponenTopBar.tvtitle.text="Profile Feature"
        binding.vComponenTopBar.Ivback.setOnClickListener(){
            onBackPressed()
        }
//        setContentView(R.layout.activity_profile)
        handleLogout()
        changeStatusBarColor()


    }
    private fun handleLogout(){
        val btnlogout = findViewById<Button>(R.id.buttonLogout)
        btnlogout.setOnClickListener{intenTo(LoginActivity::class.java)}
    }

    private fun intenTo(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }





    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color to your desired color
            window.statusBarColor = resources.getColor(R.color.blue, theme)
        }
    }


}