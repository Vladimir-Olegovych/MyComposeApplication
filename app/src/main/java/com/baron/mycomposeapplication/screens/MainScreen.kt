package com.baron.mycomposeapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.baron.mycomposeapplication.navigation.NavigationGraph
import com.baron.mycomposeapplication.screens.model.MainViewModel
import com.baron.mycomposeapplication.ui.theme.CustomButton
import com.baron.mycomposeapplication.ui.theme.CustomCard

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.getResponse()
    }
    val response by viewModel.response.collectAsState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            contentPadding = PaddingValues(5.dp)
        ) {
            items(response.stats.toList()) { item ->
                CustomCard(coin = item.second)
            }
        }
        CustomButton(
            text = "Go to settings",
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            navController.navigate(NavigationGraph.SECOND_SCREEN.name)
        }
    }
}