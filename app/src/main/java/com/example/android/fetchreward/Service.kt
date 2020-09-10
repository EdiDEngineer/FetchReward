package com.example.android.fetchreward

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RewardService {
    @GET("hiring.json")
    fun getRewards(): Deferred<List<RewardItem>>
}

object Network {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    val rewards = retrofit.create(
        RewardService::class.java)
}
