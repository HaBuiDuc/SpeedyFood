package com.buiducha.speedyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.ui.screens.navigation.AuthGraph
import com.buiducha.speedyfood.ui.theme.SpeedyFoodTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedyFoodTheme {
                AuthGraph(navHostController = rememberNavController())
            }
        }
    }
}