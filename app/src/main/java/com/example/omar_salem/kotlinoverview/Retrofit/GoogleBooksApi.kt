package com.example.omar_salem.kotlinoverview.Retrofit

import com.example.omar_salem.kotlinoverview.model.BooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO: Add class header
 */
interface GoogleBooksApi {
    @GET("volumes")
    fun getBooks( @Query("q")Key:String ) :Call<BooksResponse>
    //TODO make Debugaing  for app and  check it  work or  not
}