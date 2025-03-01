package com.example.news_application_using_jetpackcompose.persentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchNews : SearchEvent()
}