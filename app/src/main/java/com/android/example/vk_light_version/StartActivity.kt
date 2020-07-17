package com.android.example.vk_light_version

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import com.android.example.vk_light_version.fragments.PageAdapter
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_start.view.*

class StartActivity : AppCompatActivity() {
    private lateinit var dataBinding:ActivityStartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_start)






    }

    private fun settingUpViewPager() {
        view_pager.adapter = PageAdapter(supportFragmentManager,2)
        view_pager.currentItem = 0
        
    }

}


