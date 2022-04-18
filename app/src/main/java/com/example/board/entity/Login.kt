package com.example.test

data class LoginPostModel(
    var email : String?=null,
    var password : String? =null
)

data class LoginPostResult(
    var status:String? = "",
    var token:String? = ""
)
