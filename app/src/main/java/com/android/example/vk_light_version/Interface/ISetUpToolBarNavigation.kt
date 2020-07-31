package com.android.example.vk_light_version.Interface

import android.content.Intent
import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.android.example.vk_light_version.R
import com.google.android.material.navigation.NavigationView


interface ISetUpToolBarAndNavigation: NavigationView.OnNavigationItemSelectedListener {

    // Drawer Toggle
     fun settingDrawerToggle(toggle: ActionBarDrawerToggle, drawable: DrawerLayout, resources: Resources) {
         drawable.addDrawerListener(toggle)
         toggle.drawerArrowDrawable.color = resources.getColor(R.color.colorAccent)
         toggle.drawerArrowDrawable.gapSize = 15f
         toggle.syncState()
    }


    // ActionBar
    fun setUpSupportActionBar(toolbar: androidx.appcompat.widget.Toolbar)
    // NV Listener
    fun  settingNavigationListener(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener(this)
    }

    // Settings BT
    fun settingsBT(view: View)


    // !!! VK !!!!

    fun vkIsLogged(loggedIn:Boolean, intent:Intent)
    fun LogOutVk(view:View)

}