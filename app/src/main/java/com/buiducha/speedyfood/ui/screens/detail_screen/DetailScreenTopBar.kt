package com.buiducha.speedyfood.ui.screens.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.buiducha.speedyfood.ui.screens.shareds.TopBarButton
import com.buiducha.speedyfood.utils.advancedShadow

@Preview
@Composable
fun DetailScreenTopBarPreview() {
    DetailScreenTopBar()
}

@Composable
fun DetailScreenTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        TopBarButton(
            imageVector = Icons.Filled.ArrowBackIosNew,
            onClick = {

            }
        )
    }
}