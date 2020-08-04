package com.android.example.vk_light_version.Interface

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import com.android.example.vk_light_version.databinding.ActivityStartBinding

interface IGetUserToken {

    fun getUserToken(token: String?)

}