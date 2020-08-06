package com.android.example.vk_light_version

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.android.example.vk_light_version.Interface.IGetUserToken
import com.android.example.vk_light_version.Interface.ISetUpToolBarAndNavigation
import com.android.example.vk_light_version.Networking.IVkResponseAPI
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import com.android.example.vk_light_version.fragments.PageAdapter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.side_menu_nav.view.*
import kotlinx.android.synthetic.main.toolbar_main.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await


class StartActivity : AppCompatActivity(),
    ISetUpToolBarAndNavigation, IGetUserToken{


    private lateinit var viewBinding:ActivityStartBinding

    private  var accessToken:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityStartBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        // Checking VK log
        VK.addTokenExpiredHandler(tokenTracker)
        vkIsLogged(VK.isLoggedIn(), Intent(this,Welcome_login::class.java))

        // Actionbar
        setSupportActionBar(viewBinding.inclToolbar.eternalToolbar)
        // ViewPager
        settingUpViewPager()
        // Toggle for Drawer layout
        val drawable = viewBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(this,viewBinding.drawerLayout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)

        settingDrawerToggle(toggle,drawable, resources)

        // NavigationListener
        settingNavigationListener(viewBinding.inclNav.navView)

        // Vk token test
        getUserToken(accessToken)
        // VK request

        GlobalScope.launch {
            val vkRequest: IVkResponseAPI = IVkResponseAPI.instance
                val response = vkRequest.getUserData(accessToken).await()
            viewBinding.inclNav.navView.side_menu.user_name.text = response.responseUser[0].fName

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        accessToken = getSharedPreferences("access_token", Context.MODE_PRIVATE).getString("access_token", "BAD").toString()
    }



    private fun settingUpViewPager() {
        view_pager.adapter = PageAdapter(supportFragmentManager,2)
        tabs.setupWithViewPager(view_pager)
        
    }

    override fun setUpSupportActionBar(toolbar:Toolbar) {
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



    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            val intent = Intent(this@StartActivity, Welcome_login::class.java)
            startActivity(intent)

        }
    }

    override fun getUserToken(token: String?) {
        if (token!=null) {

        } else
            accessToken = getSharedPreferences("access_token",
                Context.MODE_PRIVATE).getString("access_token", "BAD")
    }


}


