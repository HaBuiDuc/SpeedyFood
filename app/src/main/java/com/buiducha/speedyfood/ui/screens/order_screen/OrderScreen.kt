package com.buiducha.speedyfood.ui.screens.order_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.buiducha.speedyfood.ui.screens.shareds.HorizontalLine
import com.buiducha.speedyfood.ui.theme.Shade
import com.buiducha.speedyfood.viewmodel.OrderViewModel
import com.buiducha.speedyfood.viewmodel.shared_viewmodel.LocationViewModel

@Preview
@Composable
fun OrderScreenPreview() {
//    OrderScreen()
}

@Composable
fun OrderScreen(
    navController: NavController,
    locationViewModel: LocationViewModel,
    orderViewModel: OrderViewModel = viewModel { OrderViewModel(locationViewModel) }
) {
    val context = LocalContext.current
    orderViewModel.getLocation(context)
    val scrollState = rememberScrollState()
    val orderState by orderViewModel.orderState.collectAsState()
    Scaffold(
        topBar = {
            OrderTopBar(
                onClose = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            OrderScreenBottomBar(
                total = orderState.totalPrice,
                onPlaceOrder = {

                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(scrollState)
        ) {
            AddressSection(
                thoroughfare = orderState.thoroughfare,
                address = orderState.address
            )
            HorizontalLine(
                weight = 6.0,
                color = Shade
            )
            if (orderState.foodItems.isNotEmpty()) {
                OrderSection(
                    cartList = orderState.cartItems,
                    foodList = orderState.foodItems,
                    subTotal = orderState.subTotal,
                    deliveryFee = orderState.deliveryFee
                )
            }
            NoteSection(
                note = orderState.note,
                onNoteChange = {note ->
                    orderViewModel.setNote(note)
                }
            )
        }
    }
}