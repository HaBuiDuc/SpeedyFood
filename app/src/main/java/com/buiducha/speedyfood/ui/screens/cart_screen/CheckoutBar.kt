package com.buiducha.speedyfood.ui.screens.cart_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CheckoutBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        
    }
}

@Composable
fun BillingItem(
    fieldName: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = fieldName
        )
        Text(
            text = value
        )
    }
}