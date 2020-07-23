package com.android.example.vk_light_version

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.android.example.vk_light_version.databinding.ActivitySettingsBinding
import com.vk.api.sdk.VK
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

class Settings : AppCompatActivity(), ISetUpToolBarAndNavigation {


    private lateinit var viewBinding: ActivitySettingsBinding






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
// Checking VK log

        vkIsLogged(VK.isLoggedIn(), Intent(this,Welcome_login::class.java))


        setUpSupportActionBar(viewBinding.inclToolbar.eternalToolbar)

        val drawable = viewBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(this,viewBinding.drawerLayout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)

        settingDrawerToggle(toggle,drawable, resources)
        settingNavigationListener(viewBinding.inclNav.navView)
    }



    override fun setUpSupportActionBar(toolbar: androidx.appcompat.widget.Toolbar) {
       setSupportActionBar(toolbar)
    }

    override fun settingsBT(view: View) {
        startActivity(Intent(this, Settings::class.java))
    }

    override fun vkIsLogged(loggedIn: Boolean, intent: Intent) {
        if (!loggedIn) startActivity(intent)
    }

    override fun LogOutVk(view: View) {
        VK.logout()
        vkIsLogged(VK.isLoggedIn(), Intent(this,Welcome_login::class.java))
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