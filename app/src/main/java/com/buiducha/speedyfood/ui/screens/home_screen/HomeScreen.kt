package com.buiducha.speedyfood.ui.screens.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.ui.screens.navigation.Screen
import com.buiducha.speedyfood.ui.theme.Ivory
import com.buiducha.speedyfood.ui.theme.LightGray
import com.buiducha.speedyfood.viewmodel.HomeViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.FoodViewModel

@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeScreen(
    navController: NavController,
    foodViewModel: FoodViewModel,
    homeViewModel: HomeViewModel = viewModel()
) {
    val homeState by homeViewModel.homeState.collectAsState()
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")
    val focusManager = LocalFocusManager.current

    fun onDetailNavigate(foodData: FoodData) {
        navController.navigate(Screen.DetailScreen.route)
        foodViewModel.foodUpdate(foodData)
    }

    Scaffold(
        topBar = {
            HomeTopBar(
                location = "Thu Duc, Viet Nam",
                modifier = Modifier
                    .padding(
                        all = 16.dp
                    )
            ) {

            }
        },
//        bottomBar = {
//            NavigationBar(
//                containerColor = LightGray,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .clip(RoundedCornerShape(36.dp))
//            ) {
//                items.forEachIndexed { index, item ->
//
//                    NavigationBarItem(
//                        icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
//                        selected = selectedItem == index,
//                        onClick = { selectedItem = index },
//                        modifier = Modifier
//                    )
//                }
//            }
//
//        }
    ) { padding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(scrollState)
                .background(Ivory)
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) {
                    focusManager.clearFocus()
                }
        ) {
            FoodTypesMenu(
                modifier = Modifier
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            RecommendedFoods(
                foodList = homeState.foodList,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {food ->
//                navController.navigate(Screen.DetailScreen.route)
//                foodViewModel.foodUpdate(food)
                onDetailNavigate(food)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color.LightGray)
            )
            NearbyFood(
                foodList = homeState.foodList,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    )
            ) {food ->
                onDetailNavigate(food)
            }
        }
    }
}


