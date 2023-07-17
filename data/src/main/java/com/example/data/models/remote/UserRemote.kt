package com.example.data.models.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRemote(
    val address: AddressRemote,
    val company: CompanyRemote,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)