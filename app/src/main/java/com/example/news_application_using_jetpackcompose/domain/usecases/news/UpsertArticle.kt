package com.example.news_application_using_jetpackcompose.domain.usecases.news

import com.example.news_application_using_jetpackcompose.domain.model.Article
import com.example.news_application_using_jetpackcompose.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article)
    }
}