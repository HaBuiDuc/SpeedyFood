package com.buiducha.speedyfood.ui.screens.food_by_category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.ui.screens.shareds.FoodItemHor
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
    foodByCategoryViewModel: FoodByCategoryViewModel = viewModel(),
) {
    val foodByCategoryState by foodByCategoryViewModel.foodByCategoryState.collectAsState()
    Scaffold(
        topBar = {
            SimpleTopBar(
                onBackListener = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    ) {padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            Text(
                text = foodByCategoryState.categoryLabel,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
            LazyColumn {
                items(foodByCategoryState.foodList) {food ->
                    FoodItemHor(
                        foodData = food,
                        onFoodSelect = {
                            
                        }
                    )
                }
            }
        }
    }
}