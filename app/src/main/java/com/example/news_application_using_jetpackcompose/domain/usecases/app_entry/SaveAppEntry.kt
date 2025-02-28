package com.example.news_application_using_jetpackcompose.domain.usecases.app_entry

import com.example.news_application_using_jetpackcompose.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}