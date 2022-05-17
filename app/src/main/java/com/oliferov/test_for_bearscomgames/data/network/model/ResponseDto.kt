package com.oliferov.test_for_bearscomgames.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @Expose
    @SerializedName("articles")
    val articles: List<NewsDto>
)