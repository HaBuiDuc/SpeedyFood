package com.buiducha.speedyfood.ui.screens.user_order_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.buiducha.speedyfood.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackBottomSheet() {
    ModalBottomSheet(
        onDismissRequest = { /*TODO*/ }
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.feedback_this_order)
            )
            TextField(
                value = "",
                onValueChange = {

                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                ),
                modifier = Modifier
            )
        }
    }
}