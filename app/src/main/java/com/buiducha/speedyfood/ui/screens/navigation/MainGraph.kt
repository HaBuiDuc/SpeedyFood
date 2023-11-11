package com.buiducha.speedyfood.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buiducha.speedyfood.ui.screens.detail_screen.DetailScreen
import com.buiducha.speedyfood.ui.screens.home_screen.HomeScreen
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel

@Composable
fun MainGraph(
    navHostController: NavHostController
) {
    val foodViewModel: FoodViewModel = viewModel()
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navHostController,
                foodViewModel = foodViewModel
            )
        }
        composable(
            route = Screen.DetailScreen.route
        ) {
            DetailScreen(
                navHostController = navHostController,
                foodViewModel = foodViewModel
            )
        }

    }
}