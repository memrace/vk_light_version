package com.android.example.vk_light_version

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.android.example.vk_light_version.databinding.ActivitySettingsBinding
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_start.incl_toolbar
import kotlinx.android.synthetic.main.toolbar_main.view.*

class Settings : AppCompatActivity(), ISetUpToolBarAndNavigation {


    private lateinit var viewBinding: ActivitySettingsBinding






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        setUpSupportActionBar()

        val drawable = viewBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(this,viewBinding.drawerLayout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)

        settingDrawerToggle(toggle,drawable, resources)
        settingNavigationListener(viewBinding.navView)
    }



    override fun setUpSupportActionBar() {
       setSupportActionBar(viewBinding.inclToolbar.eternalToolbar)

    }

    override fun settingsBT(view: View) {
        startActivity(Intent(this, Settings::class.java))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> startActivity(Intent(this, NewsFeed::class.java))
            else -> startActivity(Intent(this, NewsFeed::class.java))
        }
        viewBinding.drawerLayout.closeDrawer(GravityCompat.START)
        return item.itemId != null
    }
}