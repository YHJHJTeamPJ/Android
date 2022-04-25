package com.example.board.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.board.RetrofitBuilder
import com.example.board.databinding.ActivityBoardregBinding
import com.example.board.entity.RegisterPostModel
import com.example.board.entity.RegisterPostResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BoardRegActivity : AppCompatActivity() {
    private val binding: ActivityBoardregBinding by lazy {
        ActivityBoardregBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val service = RetrofitBuilder.api
        binding.postbutton.setOnClickListener {

            val intent = Intent(this, BoardActivity::class.java)

            val data = RegisterPostModel(binding.boardTitle.text.toString(),binding.boardContent.text.toString(),binding.boardNickname.text.toString())
            service.BoardRegister(data).enqueue(object : Callback<RegisterPostResult> {
                override fun onResponse(
                    call: Call<RegisterPostResult>,
                    response: Response<RegisterPostResult>
                ) {
                    Log.d("log",response.toString())
                    Log.d("log", response.body().toString())


                    if(response.isSuccessful) {
                        startActivity(intent)
                        finish()
                    }


                }

                override fun onFailure(call: Call<RegisterPostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }

            })
        }
    }
}