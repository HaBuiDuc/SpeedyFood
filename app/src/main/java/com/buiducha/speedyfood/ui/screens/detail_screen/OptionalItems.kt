package com.buiducha.speedyfood.ui.screens.detail_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.data.model.OptionalItemData
import com.buiducha.speedyfood.ui.theme.TextNormalStyle
import com.buiducha.speedyfood.ui.theme.TextSemiBoldStyle

//val optionalList = listOf(
//    OptionalItemData(
//        name = "Trung chien",
//        price = 5000f.toDouble()
//    ),
//    OptionalItemData(
//        name = "Canh them",
//        price = 3000f.toDouble()
//    ),
//    OptionalItemData(
//        name = "Thit them",
//        price = 15000f.toDouble()
//    ),
//    OptionalItemData(
//        name = "Nuoc dung",
//        price = 6000f.toDouble()
//    ),
//    OptionalItemData(
//        name = "Rau",
//        price = 4000f.toDouble()
//    )
//)

@Preview
@Composable
fun OptionalItemsPreview() {
//    OptionalItems()
}

@Composable
fun OptionalItems(
    optionalList: List<OptionalItemData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.toppings),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 8.dp
                )
        )
        Column {
            optionalList.forEach { item ->
                OptionalItemView(optionalItem = item)
            }
        }
    }
}

@Preview
@Composable
fun OptionalItemPreview() {
    OptionalItemView(
        optionalItem = OptionalItemData(
            name = "Trung ga chien",
            price = 5000f.toDouble()
        )
    )
}

@Composable
fun OptionalItemView(
    optionalItem: OptionalItemData
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    val textStyle by remember {
        derivedStateOf {
            if (isChecked) {
                TextSemiBoldStyle
            } else {
                TextNormalStyle
            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isChecked = !isChecked
            }
            .padding(end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
            Text(
                text = optionalItem.name,
                style = textStyle
            )
        }
        Text(
            text = optionalItem.getPriceTag(),
            style = textStyle
        )
    }
}