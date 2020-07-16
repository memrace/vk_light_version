package com.android.example.vk_light_version.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
       return when(position) {
            0 ->  Messages()

           else -> Recomendations()
       }
    }

    override fun getCount(): Int {
        return 2
    }
}