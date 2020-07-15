package com.android.example.vk_light_version

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vk.api.sdk.VK

class NewsFeed : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news__feed)
        checkIsLoggingIn()


    }


    private fun checkIsLoggingIn() {
        if (!VK.isLoggedIn()){
         startActivity(Intent(this,Welcome_login::class.java))
        }
    }

    fun logout(view: View){
        VK.logout()
        checkIsLoggingIn()
    }
}