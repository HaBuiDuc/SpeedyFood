package com.buiducha.speedyfood.ui.screens.cart_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.ui.screens.home_screen.ItemFood
import com.buiducha.speedyfood.ui.theme.DarkGray
import com.buiducha.speedyfood.ui.theme.TextSemiBoldStyle

@Preview
@Composable
fun CartItemPreview() {
    CartItem(
        food = ItemFood(
            imageId = R.drawable.beef_steak,
            label = "Beef steak",
            price = "36"
        )
    )
}

@Composable
fun CartItem(
    food: ItemFood,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = food.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = food.label,
                    style = TextSemiBoldStyle,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "$${food.price}",
                    style = TextSemiBoldStyle,
                    fontSize = 18.sp
                )
            }
        }
        ChangeQuantityButton()
    }
}

@Preview
@Composable
fun ChangeQuantityButtonPreview() {
    ChangeQuantityButton()
}

@Composable
fun ChangeQuantityButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .padding(
                    end = 16.dp
                )
                .background(
                    Color.Black,
                    RoundedCornerShape(6.dp)
                )
                .width(32.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkGray
                ),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .aspectRatio(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(
                    bottomStart = 6.dp,
                    bottomEnd = 6.dp
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .aspectRatio(1f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = null
                )
            }
        }
    }
}