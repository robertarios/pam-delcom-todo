package com.ifs21024.delcomtodo.data.remote.resoponse

import com.google.gson.annotations.SerializedName

data class DelcomResponse(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)
