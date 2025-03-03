package com.example.news_application_using_jetpackcompose.domain.usecases.news

import com.example.news_application_using_jetpackcompose.domain.model.Article
import com.example.news_application_using_jetpackcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
     operator fun invoke() : Flow<List<Article>>{
        return newsRepository.selectArticles()
    }
}