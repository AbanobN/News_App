package com.example.news_application_using_jetpackcompose.di

import android.app.Application
import com.example.news_application_using_jetpackcompose.data.manger.LocalUserMangerImp
import com.example.news_application_using_jetpackcompose.data.remote.NewsApi
import com.example.news_application_using_jetpackcompose.data.repository.NewsRepositoryImpl
import com.example.news_application_using_jetpackcompose.domain.manger.LocalUserManger
import com.example.news_application_using_jetpackcompose.domain.repository.NewsRepository
import com.example.news_application_using_jetpackcompose.domain.usecases.app_entry.AppEntryUseCases
import com.example.news_application_using_jetpackcompose.domain.usecases.app_entry.ReadAppEntry
import com.example.news_application_using_jetpackcompose.domain.usecases.app_entry.SaveAppEntry
import com.example.news_application_using_jetpackcompose.domain.usecases.news.GetNews
import com.example.news_application_using_jetpackcompose.domain.usecases.news.NewsUseCases
import com.example.news_application_using_jetpackcompose.domain.usecases.news.SearchNews
import com.example.news_application_using_jetpackcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImp(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}