package com.buiducha.speedyfood.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buiducha.speedyfood.ui.screens.home_screen.HomeScreen
import com.buiducha.speedyfood.ui.screens.settings_screen.SettingsScreen
import com.buiducha.speedyfood.ui.screens.user_order_screen.UserOrderScreen
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.LocationViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.SelectedFoodViewModel

@Composable
fun BottomNavGraph(
    locationViewModel: LocationViewModel,
    foodViewModel: FoodViewModel,
    navController: NavHostController
) {
    val selectedFoodViewModel: SelectedFoodViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route
    ) {
        composable(
            route = BottomBarScreen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController,
                selectedFoodViewModel = selectedFoodViewModel,
                locationViewModel = locationViewModel,
                foodViewModel = foodViewModel
            )
        }
        composable(
            route = BottomBarScreen.UserOrderScreen.route
        ) {
            UserOrderScreen(

            )
        }
        composable(
            route = BottomBarScreen.SettingsScreen.route
        ) {
            SettingsScreen()
        }
    }
}