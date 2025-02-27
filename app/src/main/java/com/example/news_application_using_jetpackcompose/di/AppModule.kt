package com.example.news_application_using_jetpackcompose.di

import android.app.Application
import com.example.news_application_using_jetpackcompose.data.manger.LocalUserMangerImp
import com.example.news_application_using_jetpackcompose.domain.manger.LocalUserManger
import com.example.news_application_using_jetpackcompose.domain.usecases.AppEntryUseCases
import com.example.news_application_using_jetpackcompose.domain.usecases.ReadAppEntry
import com.example.news_application_using_jetpackcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}