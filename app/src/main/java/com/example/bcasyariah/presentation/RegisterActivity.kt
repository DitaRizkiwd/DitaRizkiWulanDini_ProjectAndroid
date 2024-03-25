package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity :AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var defaultPasswordVisibility=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vComponenTopBarRegis.tvtitle.text="Back"
        binding.vComponenTopBarRegis.Ivback.setOnClickListener(){
            onBackPressed()
        }
        handleregister()
        binding.vidpass1.setOnClickListener{
            defaultPasswordVisibility=!defaultPasswordVisibility
            if(defaultPasswordVisibility){
                binding.vidpass1.setImageResource(R.drawable.ic_baseline_blur_on_24)
                binding.password.inputType = InputType.TYPE_CLASS_TEXT
            }
            else{
                binding.vidpass1.setImageResource(R.drawable.ic_baseline_blur_off_24)
                binding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

        }
        binding.vidpass2.setOnClickListener{
            defaultPasswordVisibility=!defaultPasswordVisibility
            if(defaultPasswordVisibility){
                binding.vidpass2.setImageResource(R.drawable.ic_baseline_blur_on_24)
                binding.passagain.inputType = InputType.TYPE_CLASS_TEXT
            }
            else{
                binding.vidpass2.setImageResource(R.drawable.ic_baseline_blur_off_24)
                binding.passagain.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

        }
        changeStatusBarColor()
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun handleregister(){
//        val btnRegister = findViewById<Button>(R.id.buttonRegister)
        val etname = binding.username
        val etpass = binding.password
        val etpassagain = binding.passagain

        val namevalue = etname.text
        val passval = etpass.text
        val passvala = etpassagain.text

        binding.buttonRegister.setOnClickListener{
            if(namevalue.isEmpty() || passval.isEmpty() || passvala.isEmpty()) {
                showToast("Please complete the field")
            }
            else{
//                showToast("Halo ${namevalue}")
                handleLogin()
                showToast("Success Register")
            }
              // handleLogin(namevalue.toString())

        }
    }

    private fun handleLogin(){
        val intent = intenTo(LoginActivity::class.java)

    }

    private fun intenTo(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)
        finish()
    }


    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color to your desired color
            window.statusBarColor = resources.getColor(R.color.blue, theme)
        }
    }
}