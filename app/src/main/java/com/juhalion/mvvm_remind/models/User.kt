package com.juhalion.mvvm_remind.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: Int, @SerializedName("username") val username: String
)