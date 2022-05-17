package com.oliferov.test_for_bearscomgames.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsDto (
    @Expose
    @SerializedName("author")
    val author: String?,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("urlToImage")
    val urlToImage: String,
    @Expose
    @SerializedName("publishedAt")
    val publishedAt: String,
    @Expose
    @SerializedName("content")
    val content: String,
        )