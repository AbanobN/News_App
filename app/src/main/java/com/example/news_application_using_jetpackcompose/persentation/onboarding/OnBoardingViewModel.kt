package com.example.news_application_using_jetpackcompose.persentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_application_using_jetpackcompose.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.saveAppEntry ->{
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry(){
       viewModelScope.launch {
           appEntryUseCases.saveAppEntry()
       }
    }
}