package com.oliferov.test_for_bearscomgames.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oliferov.test_for_bearscomgames.data.network.model.NewsDto
import com.oliferov.test_for_bearscomgames.data.repository.NewsRepositoryImpl
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel(){

private val repository: NewsRepositoryImpl

val newsList = MutableLiveData<List<NewsDto>>()

    init {
        repository = NewsRepositoryImpl()
        viewModelScope.launch {
            newsList.value =  repository.getAllNews()
        }
    }

    fun getAllNews() {
        viewModelScope.launch {
            newsList.value =  repository.getAllNews()
        }
    }

}