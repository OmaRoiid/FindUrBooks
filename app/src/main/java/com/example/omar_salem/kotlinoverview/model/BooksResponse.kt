package com.example.omar_salem.kotlinoverview.model

import com.google.gson.annotations.SerializedName

/**
 * TODO: Add class header
 */
class BooksResponse {
    @SerializedName("items")
    var allItems:ArrayList<AllBooks>?=null
}