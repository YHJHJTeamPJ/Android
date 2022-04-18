package com.example.board.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.board.entity.ItemEntity
import com.example.board.R
import com.example.board.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailBinding
    lateinit var item: ItemEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_detail)
        init()
    }

    fun init(){
        item = intent.extras!!.get("item") as ItemEntity
        binding.title.setText(item.title)
        binding.content.setText(item.content)
        binding.nickname.setText(item.nickname)
    }
}