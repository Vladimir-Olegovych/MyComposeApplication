package com.baron.mycomposeapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.baron.mycomposeapplication.navigation.NavigationGraph
import com.baron.mycomposeapplication.ui.theme.CustomButton

@Composable
fun SecondScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        CustomButton(
            text = "Go back",
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = {
                navController.popBackStack()
            }
        )
    }
}