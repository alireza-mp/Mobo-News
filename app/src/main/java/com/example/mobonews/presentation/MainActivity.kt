package com.example.mobonews.presentation

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mobonews.presentation.navigation.baseNavigation.MoboNewsNavigation
import com.example.mobonews.presentation.theme.MoboNewsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAppLanguage(this)

        setContent {
            MoboNewsTheme {
                SetStatusBarColor()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MoboNewsNavigation()
                }
            }
        }
    }
}

private fun setAppLanguage(activity: Activity) {
    val locale = Locale("fa")
    Locale.setDefault(locale)
    val config: Configuration = activity.resources.configuration
    config.setLocale(locale)
    activity.resources.updateConfiguration(config, activity.resources.displayMetrics)
}

@Composable
private fun SetStatusBarColor() {
    val uiController = rememberSystemUiController()
    uiController.setStatusBarColor(color = MaterialTheme.colors.background)
}