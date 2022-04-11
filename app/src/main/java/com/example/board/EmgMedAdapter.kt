package com.example.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.board.databinding.ItemEntityBinding

class BoardAdapter : ListAdapter<ItemEntity, BoardAdapter.EmgMedViewHolder>(EmgmedCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmgMedViewHolder {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmgMedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmgMedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EmgMedViewHolder(private val binding: ItemEntityBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: ItemEntity) {
            with(binding) {
                title.text = item.title
                content.text = item.content
                nickname.text = item.nickname
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