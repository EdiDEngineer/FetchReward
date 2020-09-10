package com.example.android.fetchreward.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.fetchreward.RewardItem

@BindingAdapter("listRewardData")
fun RecyclerView.bindRecyclerView(data: List<RewardItem>?) {
    val adapter = adapter as RewardListAdapter
    adapter.submitList(data) {
        scrollToPosition(0)
    }
}
