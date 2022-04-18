package com.example.board

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.board.activity.ItemDetailActivity
import com.example.board.databinding.ItemEntityBinding
import com.example.board.entity.ItemEntity


class BoardAdapter(private val context: Context) : ListAdapter<ItemEntity, BoardAdapter.EmgMedViewHolder>(EmgmedCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmgMedViewHolder {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmgMedViewHolder(binding)

    }

    override fun onBindViewHolder(holder: EmgMedViewHolder, position: Int) {
            holder.bind(context,position,getItem(position))
    }

    inner class EmgMedViewHolder(private val binding: ItemEntityBinding) :
        RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private var context: Context? = null
        private var pos: Int = 0
        private var itemEntity: ItemEntity? = null

        init{
            init()
        }

        fun bind(context: Context, pos: Int, itemEntity: ItemEntity) {
            this.context = context
            this.pos = pos
            this.itemEntity = itemEntity
            with(binding) {
                title.text = itemEntity.title
                content.text = itemEntity.content
                nickname.text = itemEntity.nickname
                executePendingBindings()
            }
        }
        fun init(){
            binding.viewGroup.setOnClickListener(this)
            binding.title.isClickable = false
            binding.content.isClickable = false
            binding.nickname.isClickable = false
        }
        override fun onClick(v: View) {
            when(v.id){
                R.id.viewGroup -> {
                    val intent = Intent(context, ItemDetailActivity::class.java)
                    intent.putExtra("item", itemEntity)
                    context?.startActivity(intent)
                }
            }
        }

    }
    companion object {
        private val EmgmedCallback = object : DiffUtil.ItemCallback<ItemEntity>() {
            override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}

