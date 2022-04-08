package com.example.board;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.board.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    lateinit var items: MutableList<ItemEntity>
    lateinit var adapter: BoardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitBuilder.api.getBoardList().enqueue(object  : Callback<List<ItemEntity>>{
            override fun onResponse(call: Call<List<ItemEntity>>, response: Response<List<ItemEntity>>) {

                Log.d("response","성공: ${response.body()}")
            }

            override fun onFailure(call: Call<List<ItemEntity>>, t: Throwable) {
                Log.d("error", "에러"+t.message.toString())
            }
        })


    }
}