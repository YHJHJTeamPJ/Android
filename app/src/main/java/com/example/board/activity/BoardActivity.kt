package com.example.board.activity;

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.board.BoardAdapter
import com.example.board.entity.ItemEntity
import com.example.board.RetrofitBuilder
import com.example.board.databinding.ActivityBoardBinding
import com.example.board.databinding.ActivityBoardregBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BoardActivity : AppCompatActivity(){
    private val binding: ActivityBoardBinding by lazy {
        ActivityBoardBinding.inflate(layoutInflater)
    }
    private val emgMedAdapter by lazy {
        BoardAdapter(context = this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.reycleView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = emgMedAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
            retrofitWork()
        binding.reycleView.layoutManager = LinearLayoutManager(this)
        binding.reycleView.adapter = emgMedAdapter

        binding.btnReg.setOnClickListener {
            val intent = Intent(this, BoardRegActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun retrofitWork() {
        val service = RetrofitBuilder.api

        service.getBoardList().enqueue(object : Callback<List<ItemEntity>>{
            override fun onResponse(
                call: Call<List<ItemEntity>>,
                response: Response<List<ItemEntity>>
            ) {
                if (response.isSuccessful) {
//                        Log.d("TAG", response.body().toString())
                    val result = response.body()
                    emgMedAdapter.submitList(result)
                }
            }

            override fun onFailure(call: Call<List<ItemEntity>>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
}
