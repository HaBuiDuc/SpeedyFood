package com.buiducha.speedyfood.ui_test

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.buiducha.speedyfood.ui.screens.cart_screen.CartScreen
import org.junit.Rule

class CartScreenTest {
    @get:Rule
    val rule = createComposeRule()

    fun isSubmitButtonEnabled() {
        rule.setContent { CartScreen(navController = rememberNavController()) }
        rule.onNodeWithTag("Submit")
    }
}