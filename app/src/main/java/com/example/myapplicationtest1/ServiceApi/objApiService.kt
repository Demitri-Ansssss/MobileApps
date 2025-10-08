package com.example.myapplicationtest1.ServiceApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://df54-2400-9800-7c1-8f4c-a844-a5d1-c9e4-d3ed.ngrok-free.app/api/predict/" // Ganti dengan alamat server Django Anda

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
