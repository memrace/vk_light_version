package com.android.example.vk_light_version.Networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VkNetworkService {
    // Json Converter
    private val jsonConverter: GsonConverterFactory = GsonConverterFactory.create()
    // Base URL
    private val baseURL:String = "https://api.vk.com/method/"
    // Retrofit
    private lateinit var mRetrofit: Retrofit


    fun getRetrofit(client: OkHttpClient):Retrofit {
        mRetrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseURL)
            .addConverterFactory(jsonConverter)
            .build()
        return mRetrofit
    }




}