package com.buiducha.speedyfood.ui.screens.navigation

sealed class Screen(
    val route: String
) {
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")
    object CartScreen: Screen("cart_screen")
    object FoodByCategory: Screen("food_by_category")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object SearchScreen: Screen("search_screen")
    object AddInfoScreen: Screen("add_info_screen")
    object OrderScreen: Screen("order_screen")
}