package com.example.data.models.remote

data class AddressRemote(
    val city: String,
    val geo: GeoRemote,
    val street: String,
    val suite: String,
    val zipcode: String
)