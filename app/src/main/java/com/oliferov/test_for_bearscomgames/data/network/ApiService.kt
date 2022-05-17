package com.oliferov.test_for_bearscomgames.data.network

import com.oliferov.test_for_bearscomgames.data.network.model.ResponseDto
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

//    @Headers(
//        "X-Api-Key: a2f301dc7b0a405d93265821681010ba"
//    )
    @GET("top-headlines")
    suspend fun getAllNews(
        @Query(QUERY_PARAM_COUNTRY) country: String = COUNTRY,
        @Query(QUERY_PARAM_PAGE_SIZE) pageSize: String = PAGE_SIZE,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = MY_API_KEY
    ): Response<ResponseDto>

    companion object{
        private const val QUERY_PARAM_API_KEY = "apiKey"

        private const val QUERY_PARAM_COUNTRY = "country"
        private const val QUERY_PARAM_PAGE_SIZE = "pageSize"

        private const val COUNTRY = "ru"
        private const val PAGE_SIZE = "100"

        private const val MY_API_KEY = "a2f301dc7b0a405d93265821681010ba"

    }
}