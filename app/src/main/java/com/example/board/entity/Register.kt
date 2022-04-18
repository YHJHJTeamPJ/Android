package com.example.test

data class RegisterPostModel(
    var name : String? =null ,
    var email : String?=null,
    var password : String? =null
)

data class RegisterPostResult(
    var email: String? = ""
)
