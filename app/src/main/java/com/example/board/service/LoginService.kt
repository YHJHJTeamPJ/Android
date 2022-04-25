package com.example.test.service
import com.example.test.LoginPostModel
import com.example.test.LoginPostResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @POST("login")
    @Headers("accept: application/json","content-type: application/json")
    fun post_users(@Body jsonparams: LoginPostModel)
        : Call<LoginPostResult>

    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http://192.168.1.74:80/" // 주소

        fun create(): LoginService {


            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(LoginService::class.java)
        }
    }
}