package com.example.news_application_using_jetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String
)