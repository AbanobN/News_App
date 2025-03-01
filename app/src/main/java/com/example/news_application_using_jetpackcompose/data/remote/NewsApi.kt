package com.example.news_application_using_jetpackcompose.data.remote

import com.example.news_application_using_jetpackcompose.data.remote.dto.NewsResponse
import com.example.news_application_using_jetpackcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources: String,
        @Query("apikey") apikey: String = API_KEY
    ):NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page : Int,
        @Query("sources") sources: String,
        @Query("apikey") apikey: String = API_KEY
    ):NewsResponse
}