package com.android.example.vk_light_version.Networking


import com.android.example.vk_light_version.Networking.DataVkResponse.DataVkResponse
import com.vk.api.sdk.VK
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


private const val METHOD_USER: String = "users.get"
private const val VK_V:String = "5.89"
private const val PARAM_USER_ID:String = "user_ids"
private const val ACCESS_TOKEN:String = "access_token"
private val FIELDS_ARRAY:List<String> = listOf("photo_50", "domain")


/*
https://api.vk.com/method/users.get?user_ids=USER_ID&fields=FIELDS&access_token=ACCESS_TOKEN&v=V
 */

interface IVkResponseAPI {

    @GET(METHOD_USER)
    fun getUserData(

        @Query(ACCESS_TOKEN) token: String

    ): Call<DataVkResponse>

    companion object {
        val instance:IVkResponseAPI by lazy {
            val requestInterceptor = Interceptor {
                chain -> val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("user_ids", VK.getUserId().toString())
                .addQueryParameter("v", "5.89")
                .addQueryParameter("fields", "${FIELDS_ARRAY[0]},${FIELDS_ARRAY[1]}")
                .build()
                    val request =  chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient =OkHttpClient.Builder().addInterceptor(requestInterceptor).build()
            VkNetworkService.getRetrofit(okHttpClient).create(IVkResponseAPI::class.java)
        }

    }


}