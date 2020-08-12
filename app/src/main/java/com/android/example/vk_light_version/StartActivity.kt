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
import androidx.databinding.DataBindingUtil
import com.android.example.vk_light_version.Interface.IGetUserToken
import com.android.example.vk_light_version.Interface.ISetUpToolBarAndNavigation
import com.android.example.vk_light_version.Networking.DataVkResponse.DataUser
import com.android.example.vk_light_version.Networking.DataVkResponse.DataVkResponse
import com.android.example.vk_light_version.Networking.IVkResponseAPI
import com.android.example.vk_light_version.databinding.ActivityStartBinding
import com.android.example.vk_light_version.fragments.PageAdapter
import com.squareup.picasso.Picasso
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.side_menu_nav.view.*
import kotlinx.android.synthetic.main.toolbar_main.view.*
import kotlinx.coroutines.*
import retrofit2.await


class StartActivity : AppCompatActivity(),
    ISetUpToolBarAndNavigation, IGetUserToken{


    private lateinit var dataBinding:ActivityStartBinding

    private  var accessToken:String? = null

    private var avatarURL: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        // Checking VK log
        VK.addTokenExpiredHandler(tokenTracker)
        vkIsLogged(VK.isLoggedIn(), Intent(this,Welcome_login::class.java))

        // Actionbar
        setSupportActionBar(dataBinding.inclToolbar.eternalToolbar)
        // ViewPager
        settingUpViewPager()
        // Toggle for Drawer layout
        val drawable = dataBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(this,dataBinding.drawerLayout,incl_toolbar.eternal_toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer)

        settingDrawerToggle(toggle,drawable, resources)

        // NavigationListener
        settingNavigationListener(dataBinding.inclNav.navView)

        // Vk token test
        getUserToken(accessToken)
        // VK request





    }

    override fun onDestroy() {
        super.onDestroy()
        accessToken = getSharedPreferences("access_token", Context.MODE_PRIVATE).getString("access_token", "BAD").toString()
    }


private suspend fun getUserInfo():List<DataUser> {
    val vkRequest:IVkResponseAPI = IVkResponseAPI.instance
    var response:Deferred<DataVkResponse> = GlobalScope.async(){
        return@async vkRequest.getUserData(accessToken.toString()).await()
        }
    return response.await().response
//    val sPref:SharedPreferences = getSharedPreferences("avatarURL", Context.MODE_PRIVATE)
//    with(sPref.edit()){
//            putString("avatarURL", response.response[0].photoURL)
//        apply()
//    }
    avatarURL = getSharedPreferences("avatarURL", Context.MODE_PRIVATE).getString("avatarURL", "BAD")

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
        else     GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            val response = getUserInfo()
            dataBinding.inclNav.navView.side_menu.fName.text = response[0].fName
            dataBinding.inclNav.navView.side_menu.lastName.text = response[0].lName
            dataBinding.inclNav.navView.side_menu.user_id.text = "@" + response[0].shortID
            Picasso.get().load(response[0].photoURL).into(dataBinding.inclNav.navView.side_menu.AvatarImg)



        }
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
        dataBinding.drawerLayout.closeDrawer(GravityCompat.START)
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
            accessToken = token
            testToken.text = accessToken
        } else
            accessToken = getSharedPreferences("access_token",
                Context.MODE_PRIVATE).getString("access_token", "BAD")
                testToken.text = accessToken
    }


}


