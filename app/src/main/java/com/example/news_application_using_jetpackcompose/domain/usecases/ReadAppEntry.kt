package com.example.news_application_using_jetpackcompose.domain.usecases

import com.example.news_application_using_jetpackcompose.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}