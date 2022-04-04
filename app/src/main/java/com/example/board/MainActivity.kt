package com.example.board;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.board.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    lateinit var items: MutableList<ItemEntity>
    lateinit var adapter: BoardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init();
    }

    fun init() {
        items = ArrayList()
        for (i in 0..19) {//데이터 생성 영역
            var item = ItemEntity()
            item.title = "$i 번째 글"
            item.contents = "안녕하세요 hjsoft 입니다.\n 리사이클러뷰 아이템을 액티비티에 전달하는 방법 실습"
            item.subTitle = item.contents?.indexOf("\n")?.let { item.contents?.substring(0, it) }
            item.date = System.currentTimeMillis().toString()
            items.add(item)
        }


        adapter = BoardAdapter(this) //리사이클러뷰 사용영역
        adapter.items = items
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding?.reycleView?.layoutManager = linearLayoutManager
        binding?.reycleView?.adapter = adapter
    }
}