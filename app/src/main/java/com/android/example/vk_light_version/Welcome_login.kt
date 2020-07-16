package com.android.example.vk_light_version

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.vk_light_version.databinding.ActivityLoginBinding
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.activity_login.*

class Welcome_login : AppCompatActivity() {
	private lateinit var dataBinding: ActivityLoginBinding


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


		dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

		// 2 VK.addTokenExpiredHandler(tokenTracker)


	}
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		val callback = object: VKAuthCallback {
			override fun onLogin(token: VKAccessToken) {
				startActivity(Intent(this@Welcome_login,NewsFeed::class.java).run {
					putExtra(Intent.EXTRA_USER, 3).also { startActivity(it) }
				})
			}

			override fun onLoginFailed(errorCode: Int) {
				tv_loginBad.visibility = View.VISIBLE
				tv_welcome.visibility = View.GONE
				button_login.text = "Try Again"
			}
		}
		if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
			super.onActivityResult(requestCode, resultCode, data)
		}
	}

	 fun vkLogin(view: View) {
		VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
	}

	// Refactor to startActivity
//	private val tokenTracker = object: VKTokenExpiredHandler {
//		override fun onTokenExpired() {
//			startActivity(Intent(this,Welcome_login::class.java))
//		}
//	}

}