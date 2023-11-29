package com.buiducha.speedyfood.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buiducha.speedyfood.ui.screens.auth_screens.create_user_info.AddUserInfo
import com.buiducha.speedyfood.ui.screens.auth_screens.login_screen.LoginScreen
import com.buiducha.speedyfood.ui.screens.auth_screens.register_screen.RegisterScreen
import com.buiducha.speedyfood.ui.screens.splash_screen.SplashScreen

@Composable
fun AuthGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(
                navController = navHostController
            )
        }
        composable(
            route = Screen.RegisterScreen.route
        ) {
            RegisterScreen(
                navController = navHostController
            )
        }
        composable(
            route = Screen.AddInfoScreen.route
        ) {
            AddUserInfo(
                navController = navHostController
            )
        }
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(
                navController = navHostController
            )
        }
    }
}