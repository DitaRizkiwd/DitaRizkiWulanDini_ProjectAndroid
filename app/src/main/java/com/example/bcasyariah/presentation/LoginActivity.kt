package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.utils.SharePrefHelper
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var sharePref : SharePrefHelper
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
            sharePref = SharePrefHelper(this)
            checkToken()
            handleProfile()
            handleRegister()
            changeStatusBarColor()
            HandlePass()

        }



    private fun handleRegister(){
        binding.directregist.setOnClickListener {
            intenTo(RegisterActivity::class.java)
        }
    }

    private fun handleProfile(){
        val etnamelog = binding.etLogname
        val etpasslog = binding.etLogpass

        val namelog = etnamelog.text
        val passlog = etpasslog.text

        binding.buttonlogin.setOnClickListener(){
            val token = UUID.randomUUID().toString()

            if(namelog.isEmpty().not() || passlog.isEmpty().not()) {
                sharePref.saveToken(token)
                intenTolog(HomeActivity::class.java, namelog.toString())
                showToast("Login Success")
            }
            else{
                    showToast("Please complete the field")


            }
        }

    }
    private fun checkToken(){
        val etnamelog = binding.etLogname
        val namelog = etnamelog.text
        val getToken =sharePref.getToken()
        if(getToken.isNotEmpty()){
            intenTolog(HomeActivity::class.java,namelog.toString())
        }
    }
    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun intenTo(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }
    private fun intenTolog(clazz:Class<*>, name:String){
        val intent = Intent(this,clazz)
        intent.putExtra(key_name,name)
        startActivity(intent)
        finish()
    }
    companion object{
        const val key_name = "key_name"

    }

    private fun HandlePass(){
        binding.cblogin.setOnClickListener{
            val cbPass=binding.cblogin
            if(cbPass.isChecked){
                binding.etLogpass.inputType=InputType.TYPE_CLASS_TEXT
            }
            else{
                binding.etLogpass.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color to your desired color
            window.statusBarColor = resources.getColor(R.color.blue, theme)
        }
    }

//    private fun intentTo(clazz:class<*>){
//
//    }



}