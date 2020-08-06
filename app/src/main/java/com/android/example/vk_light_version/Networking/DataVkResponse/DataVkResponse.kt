package com.android.example.vk_light_version.Networking.DataVkResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataVkResponse (
    @SerializedName("response")
    val responseUser:List<DataUser>)


data class DataUser (
    @SerializedName("id")

        val id:Int,
    @SerializedName("first_name")

        val fName:String,
    @SerializedName("last_name")

        val lName:String,
    @SerializedName("domain")

        val shortID:String,
    @SerializedName("photo_50")

        val photoURL:String,
    @SerializedName("online")

        val online:Byte,
    @SerializedName("last_seen")

        val lastSeen:List<LastSeen>
)

data class LastSeen(
    @SerializedName("time")

    val time:Int,
    @SerializedName("platform")

    val platform:Byte
)