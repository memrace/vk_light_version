package com.android.example.vk_light_version.Networking


import com.android.example.vk_light_version.Networking.DataVkResponse.DataVkResponse
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.auth.VKAccessToken
import okhttp3.Interceptor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


private const val METHOD_USER: String = "users.get"
private const val VK_V:String = "5.89"
private const val PARAM_USER_ID:String = "user_ids"
private const val ACCESS_TOKEN:String = "access_token"




interface IVkResponseAPI {

    @GET(METHOD_USER)
    fun getUserData (
        @Query(PARAM_USER_ID)user_id:String,
        @Query(ACCESS_TOKEN)access_token:String
    ): Call<DataVkResponse>






}