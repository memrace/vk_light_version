package com.android.example.vk_light_version.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm:FragmentManager,  count:Int): FragmentPagerAdapter(fm,count) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> Messages()
            1 -> Recomendations()
            else -> Messages()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    fun getPageTittle(position: Int): String {
        return when(position) {
            0 -> "Messages"
            1 -> "Recommendations"
            else -> "null"
        }
    }



}
