package com.example.board

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    var api : API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.10:8080/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
}

//package com.example.board
//
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//
//object RetrofitBuilder {
//    private const val BASE_URL = "http://192.168.0.3:8080/"
//
//    private val okHttpClient: OkHttpClient by lazy {
//        OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            })
//            .build()
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .addConverterFactory(MoshiConverterFactory.create())
//            .client(okHttpClient)
//            .baseUrl(BASE_URL)
//            .build()
//    }
//    val api : API by lazy {
//        retrofit.create(api::class.java)
//    }
//}