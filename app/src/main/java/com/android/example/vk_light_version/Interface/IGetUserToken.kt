package com.android.example.vk_light_version.Interface

import android.content.Intent
import android.content.Intent.EXTRA_USER

interface IGetUserToken {

    fun getUserToken(intent:Intent):String{
        var token:String = intent.getStringExtra("token_access")
        return  token
    }





}