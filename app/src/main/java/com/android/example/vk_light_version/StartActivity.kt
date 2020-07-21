package com.android.example.vk_light_version

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import com.android.example.vk_light_version.fragments.PageAdapter
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

class StartActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
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
        // NavigationListener
        settingNavigationListener()

    }

    private fun settingUpViewPager() {
        view_pager.adapter = PageAdapter(supportFragmentManager,2)
        tabs.setupWithViewPager(view_pager)
        
    }

    private fun settingDrawerToggle(){
        val toggle = ActionBarDrawerToggle(this,drawer_layout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)
        drawer_layout.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.colorAccent)
        toggle.drawerArrowDrawable.gapSize = 15f
        toggle.syncState()
    }

    private fun settingNavigationListener() {
        viewBinding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> startActivity(Intent(this, NewsFeed::class.java))
            else -> startActivity(Intent(this, NewsFeed::class.java))
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return item.itemId != null
    }


}


