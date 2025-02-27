package com.example.news_application_using_jetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_application_using_jetpackcompose.domain.usecases.AppEntryUseCases
import com.example.news_application_using_jetpackcompose.persentation.nvgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: Boolean get() = _splashCondition.value

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: String get() = _startDestination.value

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            _startDestination.value = if(shouldStartFromHomeScreen){
                Route.NewsNavigation.route
            }else{
                Route.AppStartNavigation.route
            }
            delay(300)
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}