package com.tm78775.userproject.data.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("gender") val gender : String,
    @SerializedName("name") val name : Name,
    @SerializedName("email") val email : String,
    @SerializedName("dob") val dob : Dob,
    @SerializedName("phone") val phone : String,
    @SerializedName("cell") val cell : String,
    @SerializedName("id") val id : Id,
    @SerializedName("picture") val picture : Picture,
    @SerializedName("nat") val nat : String
)