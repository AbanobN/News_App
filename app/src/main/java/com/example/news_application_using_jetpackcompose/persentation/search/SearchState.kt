package com.example.news_application_using_jetpackcompose.persentation.search

import androidx.paging.PagingData
import com.example.news_application_using_jetpackcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>?= null
)