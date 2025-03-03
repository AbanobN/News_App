package com.example.news_application_using_jetpackcompose.persentation.details

import com.example.news_application_using_jetpackcompose.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}
