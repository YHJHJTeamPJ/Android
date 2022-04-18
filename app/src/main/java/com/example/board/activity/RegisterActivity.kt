package com.example.board.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.board.R
import com.example.board.databinding.ActivityRegisterBinding
import com.example.test.RegisterPostModel
import com.example.test.RegisterPostResult
import com.example.test.service.RegisterService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {
    val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater)}
    val api = RegisterService.create();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.postbutton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            val data = RegisterPostModel(binding.nameedt.text.toString(),binding.emailedt.text.toString(),binding.pwdedt.text.toString())
            api.post_users(data).enqueue(object : Callback<RegisterPostResult> {
                override fun onResponse(call: Call<RegisterPostResult>, response: Response<RegisterPostResult>) {
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



