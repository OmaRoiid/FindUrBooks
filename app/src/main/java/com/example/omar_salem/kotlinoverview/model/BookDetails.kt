package com.example.omar_salem.kotlinoverview.model

import com.google.gson.annotations.SerializedName

/**
 * TODO: Add class header
 */
open class BookDetails {

        @SerializedName("title")
        var BookTittle:String?=null
        @SerializedName("publisher")
        var BookPublisher :String?=null
        @SerializedName("publishedDate")
        var publishedDate:String?=null
        @SerializedName("imageLinks")
        var BookImage :ImageLinkes?=null


}
