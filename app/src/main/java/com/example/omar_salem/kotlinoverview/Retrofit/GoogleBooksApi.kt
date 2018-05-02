package com.example.omar_salem.kotlinoverview.Retrofit

import com.example.omar_salem.kotlinoverview.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO: Add class header
 */
interface GoogleBooksApi {
    @GET("volumes")
    fun getBooks( @Query("q")Key:String ) :Call<Response.BooksResponse>
}