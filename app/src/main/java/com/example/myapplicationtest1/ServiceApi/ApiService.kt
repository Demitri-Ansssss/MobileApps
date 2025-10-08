package com.example.myapplicationtest1.ServiceApi
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Multipart
    @POST("predict") // Pastikan path URL sesuai dengan endpoint Django Anda
    fun uploadImage(
        @Part image: MultipartBody.Part
    ): Call<PredictionResponse>

    @GET("predict")
    fun getPredictions(): Call<List<PredictionLog>>
}

data class PredictionResponse(
    val message: String,
    val predicted_class: String,
    val confidence: Double,
    val file_path: String
)

data class PredictionLog(
    val predicted_class: String,
    val confidence: Double,
    val file_path: String
)
