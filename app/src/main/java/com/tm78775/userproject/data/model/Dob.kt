package com.tm78775.userproject.data.model

import com.google.gson.annotations.SerializedName

data class Dob (
	@SerializedName("date") val date : String,
	@SerializedName("age") val age : Int
)