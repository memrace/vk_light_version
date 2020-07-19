package com.android.example.vk_light_version

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import com.android.example.vk_light_version.fragments.PageAdapter
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

class StartActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityStartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityStartBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        // Actionbar
        setSupportActionBar(incl_toolbar.eternal_toolbar)
        // ViewPager
        settingUpViewPager()
        // Toggle for Drawer layout
        settingDrawerToggle()


    }

    private fun settingUpViewPager() {
        view_pager.adapter = PageAdapter(supportFragmentManager,2)
        tabs.setupWithViewPager(view_pager)
        
    }

    private fun settingDrawerToggle(){
        val toggle = ActionBarDrawerToggle(this,drawer_layout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)
        drawer_layout.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.colorAccent)
        toggle.syncState()
    }

}


