package com.example.news_application_using_jetpackcompose.data.remote.dto

import com.example.news_application_using_jetpackcompose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)