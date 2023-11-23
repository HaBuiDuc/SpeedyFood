package com.buiducha.speedyfood.ui.screens.root_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.ui.screens.navigation.BottomBarScreen
import com.buiducha.speedyfood.ui.screens.navigation.MainGraph
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.LocationViewModel

@Composable
fun MainScreen(
    locationViewModel: LocationViewModel,
    foodViewModel: FoodViewModel,
) {
    val navController = rememberNavController()
    var selectedScreen by remember {
        mutableStateOf(BottomBarScreen.HomeScreen as BottomBarScreen)
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                selectedScreen = selectedScreen,
                onSelectedScreen = {screen ->
                    selectedScreen = screen
                }
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
//            when (selectedScreen) {
//                BottomBarScreen.HomeScreen -> {
//
//                }
//                BottomBarScreen.SettingsScreen -> {
//
//                }
//                BottomBarScreen.UserOrderScreen -> {
//
//                }
//            }
//            BottomNavGraph(
//                locationViewModel = locationViewModel,
//                foodViewModel = foodViewModel,
//                navController = navController
//            )
            MainGraph(
                navHostController = navController,
                locationViewModel = locationViewModel,
                foodViewModel = foodViewModel
            )
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    selectedScreen: BottomBarScreen,
    onSelectedScreen: (BottomBarScreen) -> Unit
) {
    val screens = listOf(
        BottomBarScreen.HomeScreen,
        BottomBarScreen.UserOrderScreen,
        BottomBarScreen.SettingsScreen,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == screen.route
                    } == true,
                    onClick = {
                        navController.navigate(screen.route)
//                    onSelectedScreen(screen)
                    },
                    icon = {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = screen.title
                        )
                    }
                )
            }
        }
    }


}