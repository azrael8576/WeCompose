package com.hewei.wecompose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.viewmodels.WeViewModel
import kotlin.math.roundToInt

@Composable
fun ChatPage() {
    val viewModel: WeViewModel = viewModel()
    val offsetPerCentX by animateFloatAsState(if (viewModel.chatting) 0f else 1f, label = "")
    Box(
        Modifier
            .offsetPercent(offsetPerCentX)
            .background(Color.Magenta)
            .fillMaxSize()
    )
}

fun Modifier.offsetPercent(offsetPerCentX: Float = 0f, offsetPerCentY: Float = 0f) =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            val offsetX = (offsetPerCentX * placeable.width).roundToInt()
            val offsetY = (offsetPerCentY * placeable.height).roundToInt()
            placeable.placeRelative(offsetX, offsetY)
        }
    }