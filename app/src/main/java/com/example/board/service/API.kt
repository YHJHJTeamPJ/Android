package com.example.board.service

import com.example.board.entity.ItemEntity
import com.example.board.entity.RegisterPostModel
import com.example.board.entity.RegisterPostResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface API {
    //보드 값 가져오기
    @GET("board")
    fun getBoardList():Call<List<ItemEntity>>

    @POST("reg")
    @Headers("accept: application/json","content-type: application/json")
    fun BoardRegister(@Body jsonparams: RegisterPostModel)
            : Call<RegisterPostResult>
}