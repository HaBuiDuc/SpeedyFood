package com.buiducha.speedyfood.ui.screens.cart_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.ui.screens.home_screen.foodList
import com.buiducha.speedyfood.ui.theme.TextBoldStyle
import com.buiducha.speedyfood.ui.theme.TextNormalStyle

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen()
}

@Composable
fun CartScreen() {
    Scaffold(
        topBar = {
            CartScreenTopBar(
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.my),
                    style = TextBoldStyle,
                    fontSize = 32.sp
                )
                Text(
                    text = stringResource(id = R.string.cart_list),
                    style = TextNormalStyle,
                    fontSize = 32.sp
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                items(foodList) {food ->
                    CartItem(
                        food = food
                    )
                }
            }
        }
    }
}