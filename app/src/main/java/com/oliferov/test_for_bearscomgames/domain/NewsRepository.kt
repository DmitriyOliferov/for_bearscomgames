package com.oliferov.test_for_bearscomgames.domain

import androidx.lifecycle.LiveData
import com.oliferov.test_for_bearscomgames.data.network.model.NewsDto

interface NewsRepository {

    suspend fun getAllNews() : List<NewsDto>
}