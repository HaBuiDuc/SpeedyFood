package com.buiducha.speedyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.ui.screens.navigation.MainGraph
import com.buiducha.speedyfood.ui.theme.SpeedyFoodTheme

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedyFoodTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//                RegisterScreen()
//                LoginScreen()
                navHostController = rememberNavController()
                MainGraph(navHostController = navHostController)
            }
        }
    }
}