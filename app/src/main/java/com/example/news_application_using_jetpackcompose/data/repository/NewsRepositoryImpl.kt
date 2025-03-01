package com.example.news_application_using_jetpackcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.news_application_using_jetpackcompose.data.remote.NewsApi
import com.example.news_application_using_jetpackcompose.data.remote.NewsPagingSource
import com.example.news_application_using_jetpackcompose.data.remote.SearchNewsPagingSource
import com.example.news_application_using_jetpackcompose.domain.model.Article
import com.example.news_application_using_jetpackcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return Pager(
           config = PagingConfig(pageSize = 10),
           pagingSourceFactory = {
               NewsPagingSource(
                   newsApi = newsApi,
                   sources = sources.joinToString(separator = ",")
               )
           }
       ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    api = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}