package com.example.bcasyariah.utils

import android.content.Context
import android.content.SharedPreferences

class SharePrefHelper(context : Context) {
    private val sharePref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token:String){
        sharePref.edit().putString(TOKEN_KEY,token).apply()
    }

    fun getToken():String{
        return sharePref.getString(TOKEN_KEY, null)?:""
    }

    fun clearDataPref(){
        val editor =sharePref.edit()
        editor.clear()
        editor.apply()
    }

    companion object{
        const val PREF_NAME="pref_name"
        const val TOKEN_KEY="token_key"
    }
}