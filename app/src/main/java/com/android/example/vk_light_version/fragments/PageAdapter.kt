package com.android.example.vk_light_version.fragments

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm:FragmentManager,  count:Int): FragmentPagerAdapter(fm,count) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> Messages()
            1 -> Recomendations()
            else -> Recomendations()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Сообщения" + "      |"
            1-> "Рекомендации"
            else -> ""
        }
    }



}
