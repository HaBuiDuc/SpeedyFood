package com.buiducha.speedyfood.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buiducha.speedyfood.ui.screens.detail_screen.DetailScreen
import com.buiducha.speedyfood.ui.screens.home_screen.HomeScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
        }
        composable(
            route = Screen.DetailScreen.route
        ) {
//            DetailScreen(
//                food =
//            )
        }
    }
}