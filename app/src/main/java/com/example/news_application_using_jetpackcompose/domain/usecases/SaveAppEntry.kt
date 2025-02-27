package com.example.news_application_using_jetpackcompose.domain.usecases

import com.example.news_application_using_jetpackcompose.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}