package com.example.board

import okhttp3.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    //보드 값 가져오기
    @GET("board/read")
    fun getBoardList(@Body board : Map<String, String>):Call<String>
}