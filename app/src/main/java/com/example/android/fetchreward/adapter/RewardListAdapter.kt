package com.example.android.fetchreward.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android.fetchreward.RewardItem
import com.example.android.fetchreward.databinding.RewardItemBinding

class RewardListAdapter : ListAdapter<RewardItem,
        RecyclerView.ViewHolder>(RewardDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(getItem(position) )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: RewardItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RewardItem) {
            binding.reward = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RewardItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}


class RewardDiffCallback : DiffUtil.ItemCallback<RewardItem>() {
    override fun areItemsTheSame(oldItem: RewardItem, newItem: RewardItem): Boolean {
        return oldItem   == newItem
    }

    override fun areContentsTheSame(oldItem: RewardItem, newItem: RewardItem): Boolean {
        return oldItem == newItem
    }
}