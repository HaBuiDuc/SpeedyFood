package com.buiducha.speedyfood.ui.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.ui.theme.TextSemiBoldStyle

//@Composable
//fun OrderRecently(
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier
//    ) {
//        Text(
//            text = stringResource(id = R.string.order_recently),
//            style = TextSemiBoldStyle,
//            fontSize = 24.sp
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        LazyRow(
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            items(foodList) {item ->
//                FoodItemVer(
//                    food = item
//                )
//            }
//        }
//    }
//}