package com.example.data.entity

import com.google.gson.annotations.SerializedName
import java.io.File

data class UserEntity(
    @SerializedName("name")
    val name: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("userId")
    val phone: String?,

    @SerializedName("address")
    val address: UserAddressEntity?
)