package com.buiducha.speedyfood.ui.screens.user_order_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.data.model.CartItemData
import com.buiducha.speedyfood.data.model.OrderData
import com.buiducha.speedyfood.ui.screens.shareds.HorizontalLine
import com.buiducha.speedyfood.ui.theme.DarkGreen

@Composable
fun OrderItem(
    orderItem: OrderData
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.order_id)
            )
            Text(
                text = orderItem.orderId
            )
        }
        Text(
            text = orderItem.orderDate
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${orderItem.totalPrice}$"
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (orderItem.orderStatus) Icons.Default.CheckCircle else Icons.Default.Cancel,
                    contentDescription = null,
                    tint = if (orderItem.orderStatus) DarkGreen else Color.Gray
                )
                Text(
                    text = stringResource(
                        id = if (orderItem.orderStatus) R.string.accomplished else R.string.processing
                    ),
                    color = if (orderItem.orderStatus) DarkGreen else Color.Gray
                )
            }
        }
    }
}

@Composable
private fun ExpandSection(
    orderItem: OrderData
) {
    var isExpand by remember {
        mutableStateOf(false)
    }
    Column {
        HorizontalLine(
            weight = 0.2,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isExpand = !isExpand
                }
        ) {
            Text(
                text = stringResource(id = R.string.order)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        if (isExpand) {
            DeliveryAddress(
                deliveryAddress = orderItem.address
            )
            ItemList(
                itemList = orderItem.itemList
            )
        }
    }
}

@Composable
private fun ItemList(
    itemList: List<CartItemData>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.item_list)
        )
        itemList.forEach {item ->
            SingleItem(item = item)
        }
    }
}

@Composable
private fun SingleItem(
    item: CartItemData
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${item.quantity}x"
            )
            Text(
                text = item.foodId
            )
        }
        Text(
            text = "${item.price}$"
        )
    }
}

@Composable
fun DeliveryAddress(
    deliveryAddress: String
) {
    Column {
        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                tint = Color.Red
            )
            Text(
                text = stringResource(id = R.string.delivery_address),
                fontWeight = FontWeight.Medium
            )
        }
        Text(
            text = deliveryAddress,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}