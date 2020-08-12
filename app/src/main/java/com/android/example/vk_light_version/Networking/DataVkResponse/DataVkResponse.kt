package com.android.example.vk_light_version.Networking.DataVkResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class DataVkResponse (
    @SerializedName("response")
    @Expose
    val response:List<DataUser>)


data class DataUser (
    @SerializedName("id")
    @Expose
        val id:Int,
    @SerializedName("first_name")
    @Expose
        val fName:String,
    @SerializedName("last_name")
    @Expose
        val lName:String,
    @SerializedName("domain")
    @Expose
        val shortID:String,
    @SerializedName("photo_100")
    @Expose
        val photoURL:String,
    @SerializedName("online")
    @Expose
        val online:Byte,
    @SerializedName("last_seen")
    @Expose
        val lastSeen:List<LastSeen>
)

data class LastSeen(
    @SerializedName("time")
    @Expose
    val time:Int,
    @SerializedName("platform")
    @Expose
    val platform:Byte
)