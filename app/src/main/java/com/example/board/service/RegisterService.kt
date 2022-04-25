package com.example.test.service
import com.example.test.RegisterPostModel
import com.example.test.RegisterPostResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface RegisterService {

    @POST("register")
    @Headers("accept: application/json","content-type: application/json")
    fun post_users(@Body jsonparams: RegisterPostModel): Call<RegisterPostResult>

    companion object { // static 처럼 공유객체로 사용가능함. 모든 인스턴스가 공유하는 객체로서 동작함.
        private const val BASE_URL = "http://192.168.0.3:80/" // 주소

        fun create(): RegisterService {

//            val gson :Gson =   GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(RegisterService::class.java)
        }
    }
}