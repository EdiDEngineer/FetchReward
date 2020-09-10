package com.example.android.fetchreward

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RewardItem(
        val id: String,
        val listId: String,
        val name: String? )

