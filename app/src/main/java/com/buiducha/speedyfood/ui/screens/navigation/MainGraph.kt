package com.buiducha.speedyfood.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buiducha.speedyfood.ui.screens.cart_screen.CartScreen
import com.buiducha.speedyfood.ui.screens.detail_screen.DetailScreen
import com.buiducha.speedyfood.ui.screens.food_by_category.FoodByCategory
import com.buiducha.speedyfood.ui.screens.home_screen.HomeScreen
import com.buiducha.speedyfood.ui.screens.order_screen.OrderScreen
import com.buiducha.speedyfood.ui.screens.search_screen.SearchScreen
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.SelectedFoodViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.LocationViewModel

@Composable
fun MainGraph(
    navHostController: NavHostController,
    locationViewModel: LocationViewModel,
    foodViewModel: FoodViewModel
) {
    val selectedFoodViewModel: SelectedFoodViewModel = viewModel()
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navHostController,
                selectedFoodViewModel = selectedFoodViewModel,
                locationViewModel = locationViewModel,
                foodViewModel = foodViewModel
            )
        }
        composable(
            route = Screen.DetailScreen.route
        ) {
            DetailScreen(
                navHostController = navHostController,
                foodViewModel = selectedFoodViewModel
            )
        }
        composable(
            route = Screen.FoodByCategory.route
        ) {
            FoodByCategory(
                navController = navHostController
            )
        }
        composable(
            route = Screen.CartScreen.route
        ) {
            CartScreen(
                navController = navHostController
            )
        }
        composable(
            route = Screen.SearchScreen.route
        ) {
            SearchScreen(
                navController = navHostController,
                foodViewModel = foodViewModel,
                selectedFoodViewModel = selectedFoodViewModel
            )
        }
        composable(
            route = Screen.OrderScreen.route
        ) {
            OrderScreen(
                locationViewModel = locationViewModel,
                navController = navHostController
            )
        }
    }
}