package com.android.example.vk_light_version

import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
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
    fun setUpSupportActionBar(){
    }
    // NV Listener
    fun  settingNavigationListener(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener(this)
    }

    // Settings BT
    fun settingsBT(view: View)


}