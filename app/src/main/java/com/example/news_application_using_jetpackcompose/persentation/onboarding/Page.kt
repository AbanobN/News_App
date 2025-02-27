package com.example.news_application_using_jetpackcompose.persentation.onboarding

import androidx.annotation.DrawableRes
import com.example.news_application_using_jetpackcompose.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)


val pages = listOf(
    Page(title = "Lorem Ipsum dummy", description = "Lorem Ipsum is somply dummy text of the printing and typsetting industry.", image = R.drawable.onboarding1),
    Page(title = "Lorem Ipsum dummy", description = "Lorem Ipsum is somply dummy text of the printing and typsetting industry.", image = R.drawable.onboarding2),
    Page(title = "Lorem Ipsum dummy", description = "Lorem Ipsum is somply dummy text of the printing and typsetting industry.", image = R.drawable.onboarding3)
)
