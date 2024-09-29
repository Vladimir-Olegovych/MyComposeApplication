package com.baron.mycomposeapplication.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baron.domain.model.Coin

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}

@Composable
fun CustomCard(coin: Coin) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Coin: ${coin.name}")
        Text(text = "Value: ${coin.value} рублей")
    }
}