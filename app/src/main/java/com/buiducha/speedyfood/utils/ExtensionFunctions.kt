package com.buiducha.speedyfood.utils

import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.buiducha.speedyfood.data.model.FoodData
import java.util.Locale

fun Modifier.advancedShadow(
    color: Color = Color.Black,
    alpha: Float = 1f,
    cornersRadius: Dp = 0.dp,
    shadowBlurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparentColor = color.copy(alpha = 0f).toArgb()

    drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowBlurRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            cornersRadius.toPx(),
            cornersRadius.toPx(),
            paint
        )
    }
}

fun Location.getThoroughfare(context: Context): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(latitude, longitude, 1)

    if (addresses != null) {
        return if (addresses.isNotEmpty()) {
            val address = addresses[0]
            address.thoroughfare
        } else {
            ""
        }
    }
    return "Location not found"
}

fun Location.getAddress(context: Context): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(latitude, longitude, 1)

    if (addresses != null) {
        return if (addresses.isNotEmpty()) {
            val address = addresses[0]
            "${address.subThoroughfare}, ${address.locality}, ${address.adminArea}"
        } else {
            ""
        }
    }
    return "Location not found"
}

fun Location.getDetailAddress(context: Context): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(latitude, longitude, 1)

    if (addresses != null) {
        return if (addresses.isNotEmpty()) {
            val address = addresses[0]
            "${address.thoroughfare}, ${address.subThoroughfare}, ${address.locality}, ${address.adminArea}, ${address.countryName}"
        } else {
            ""
        }
    }
    return "Location not found"
}

fun FoodData.getPriceLabel() = "$${this.price}"