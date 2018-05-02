package com.example.omar_salem.kotlinoverview.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * TODO: Add class header
 */
class RetrofitClient {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"
    var retrofit: Retrofit? = null
    val clint: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
}