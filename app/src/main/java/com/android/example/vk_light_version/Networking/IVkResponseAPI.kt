package com.android.example.vk_light_version.Networking


import com.android.example.vk_light_version.Networking.DataVkResponse.DataVkResponse
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiConfig
import okhttp3.Interceptor
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


private const val METHOD_USER: String = "users.get"
private const val VK_V:String = "5.89"
private const val PARAM_USER_ID:String = "user_ids"



interface IVkResponseAPI {

    @GET(METHOD_USER)
    fun getUserData (
        @Query(PARAM_USER_ID)user_id:String
    ): Call<DataVkResponse>


//companion object {
//    val instance: IVkResponseAPI by lazy {
//        val requestInterceppto = Interceptor {
//            chain ->val url = chain.request()
//            .url()
//            .newBuilder()
//            .addEncodedQueryParameter("access_token",)
//        }
//    }
//}

}