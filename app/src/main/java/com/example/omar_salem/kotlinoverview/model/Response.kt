package com.example.omar_salem.kotlinoverview.model

import com.google.gson.annotations.SerializedName

/**
 * TODO: Add class header
 */
object Response {
    data class BooksResponse(@SerializedName("items") val allItems: ArrayList<AllBooks>)

    data class AllBooks(@SerializedName("volumeInfo") val items: BookDetails)

    data class ImageLinks(@SerializedName("smallThumbnail") val smallImage: String,
                          @SerializedName("thumbnail") val NormalImage: String)

    data class BookDetails(@SerializedName("title") val BookTittle: String,
                           @SerializedName("publisher") val BookPublisher: String,
                           @SerializedName("publishedDate") val publishedDate: String,
                           @SerializedName("imageLinks") val BookImage: ImageLinks)
}
