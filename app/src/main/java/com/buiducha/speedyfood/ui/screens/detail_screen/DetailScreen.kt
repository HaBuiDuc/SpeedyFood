package com.buiducha.speedyfood.ui.screens.detail_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buiducha.speedyfood.R
import com.buiducha.speedyfood.data.model.FoodData
import com.buiducha.speedyfood.ui.theme.Gold
import com.buiducha.speedyfood.utils.advancedShadow
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        food = FoodData(
            name = "Beef "
        )
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    food: FoodData,
    modifier: Modifier = Modifier
) {
    var quantity by remember {
        mutableIntStateOf(0)
    }
    val scrollState = rememberScrollState()
    Scaffold(
        bottomBar = {
            DetailScreenBottomBar()
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                GlideImage(
                    model = food.imageUri,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                DetailScreenTopBar(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ElevatedButton(
                    colors = ButtonDefaults.buttonColors(
                        disabledContainerColor = Color.White
                    ),
                    shape = RoundedCornerShape(20.dp),
                    enabled = false,
                    onClick = {

                    },
                    contentPadding = PaddingValues(
                        vertical = 8.dp,
                        horizontal = 14.dp
                    ),
                    modifier = Modifier
                        .advancedShadow(
                            color = Color.Gray,
                            alpha = 0.2f,
                            cornersRadius = 20.dp,
                            shadowBlurRadius = 20.dp,
                            offsetY = 2.dp,
                            offsetX = 2.dp
                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = stringResource(id = R.string.image_des),
                        tint = Gold
                    )
                    Text(
                        text = "5.0"
                    )
                }
                ElevatedButton(
                    enabled = false,
                    colors = ButtonDefaults.buttonColors(
                        disabledContainerColor = Gold
                    ),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {

                    },
                    contentPadding = PaddingValues(
                        horizontal = 10.dp,
                        vertical = 8.dp
                    ),
                    modifier = Modifier
                        .advancedShadow(
                            color = Color.Gray,
                            alpha = 0.2f,
                            cornersRadius = 20.dp,
                            shadowBlurRadius = 20.dp,
                            offsetY = 2.dp,
                            offsetX = 2.dp
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                if (quantity > 0) {
                                    quantity--
                                }
                            }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = quantity.toString()
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                quantity++
                            }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = food.name!!,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                )
            }
//            OptionalItems()
        }
    }
}