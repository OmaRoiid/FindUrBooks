package com.example.omar_salem.kotlinoverview.model

import com.google.gson.annotations.SerializedName

/**
 * TODO: Add class header
 */
open class ImageLinkes {
    @SerializedName("smallThumbnail")
    var smallImage: String? = null
    @SerializedName("thumbnail")
    var NormalImage:String?=null
}