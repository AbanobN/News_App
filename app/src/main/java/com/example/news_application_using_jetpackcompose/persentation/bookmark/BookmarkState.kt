package com.example.news_application_using_jetpackcompose.persentation.bookmark

import com.example.news_application_using_jetpackcompose.domain.model.Article

data class BookmarkState (
    val articles: List<Article> = emptyList()
)