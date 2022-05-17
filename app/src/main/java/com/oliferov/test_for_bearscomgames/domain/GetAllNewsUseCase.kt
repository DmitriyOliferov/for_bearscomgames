package com.oliferov.test_for_bearscomgames.domain

class GetAllNewsUseCase (
    private val repository: NewsRepository
) {
    suspend operator fun invoke() = repository.getAllNews()
}