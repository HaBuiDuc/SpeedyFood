package com.buiducha.speedyfood.ui.screens.food_by_category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.ui.screens.shareds.SimpleTopBar
import com.buiducha.speedyfood.viewmodel.FoodByCategoryViewModel

@Preview
@Composable
fun FoodByCategoryPreview() {
    FoodByCategory(rememberNavController())
}

@Composable
fun FoodByCategory(
    navController: NavController,
    foodByCategoryViewModel: FoodByCategoryViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                onBackListener = {

                }
            )
        }
    ) {padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

        }
    }
}