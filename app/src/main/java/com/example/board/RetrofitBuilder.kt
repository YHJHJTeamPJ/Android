package com.example.board

import com.example.board.service.API
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    var api : API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.3:80/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
}