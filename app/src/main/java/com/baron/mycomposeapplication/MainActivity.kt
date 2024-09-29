package com.baron.mycomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baron.mycomposeapplication.screens.MainScreen
import com.baron.mycomposeapplication.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme { AppSetup() }
        }
    }

}

@Composable
fun AppSetup() {

    val navController = rememberNavController()
    NavHost(navController, startDestination = "MainScreen") {
        composable("MainScreen") { MainScreen(hiltViewModel()) }
    }
}