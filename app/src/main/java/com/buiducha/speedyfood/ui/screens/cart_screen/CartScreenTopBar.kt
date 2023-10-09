package com.buiducha.speedyfood.ui.screens.cart_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.buiducha.speedyfood.ui.screens.shareds.TopBarButton
import com.buiducha.speedyfood.utils.advancedShadow

@Preview
@Composable
fun CartScreenTopBarPreview() {
    CartScreenTopBar()
}

@Composable
fun CartScreenTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        TopBarButton(
            imageVector = Icons.Filled.ArrowBackIosNew,
            onClick = {

            }
        )
        TopBarButton(
            imageVector = Icons.Outlined.Delete,
            onClick = {

            }
        )
    }
}