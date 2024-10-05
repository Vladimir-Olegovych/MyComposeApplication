package com.baron.mycomposeapplication.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baron.domain.model.Coin
import java.math.BigDecimal
import java.math.MathContext

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = {onClick.invoke()},
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
    val value = BigDecimal(coin.value) / BigDecimal(coin.nominal)
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Coin: ${coin.name}")
        Text(text = "Value: ${value.round(MathContext(4))} рублей")
    }
}