package com.example.news_application_using_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.news_application_using_jetpackcompose.persentation.onboarding.OnBoardingScreen
import com.example.news_application_using_jetpackcompose.ui.theme.News_Application_Using_JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()
        setContent {
            News_Application_Using_JetpackComposeTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background))
                {
                    OnBoardingScreen()
                }

            }
        }
    }
}
