package com.oliferov.test_for_bearscomgames.data.repository


import android.util.Log
import com.oliferov.test_for_bearscomgames.data.network.ApiFactory.apiService
import com.oliferov.test_for_bearscomgames.data.network.model.NewsDto
import com.oliferov.test_for_bearscomgames.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl: NewsRepository {

    override suspend fun getAllNews(): List<NewsDto> =
        withContext(Dispatchers.IO){
            Log.d("DxD","list.toString()")
            val list = apiService.getAllNews().body()?.articles ?: emptyList()
            Log.d("DxD",list.toString())
            return@withContext list
        }
}