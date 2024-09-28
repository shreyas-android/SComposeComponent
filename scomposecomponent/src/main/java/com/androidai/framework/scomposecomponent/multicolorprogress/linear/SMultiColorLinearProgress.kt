package com.androidai.framework.scomposecomponent.multicolorprogress.linear

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp

@Composable
fun InfiniteMultiColorLinearProgressIndicator(
        modifier : Modifier, thickness : Dp,
        colors : List<Color>, strokeCap : StrokeCap = StrokeCap.Butt,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val screenSize = remember { mutableStateOf(0f) }

    val offset by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = screenSize.value, // Move based on screen width
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing), // Duration for movement
            repeatMode = RepeatMode.Restart))

    Canvas(modifier = modifier) {
        if(screenSize.value == 0f) {
            screenSize.value = size.width
        }

        val segmentWidth = (size.width / colors.size)
        val spacing = 0f // No spacing between segments
        val totalSegmentWidth = segmentWidth + spacing
        val lineWidth = thickness.toPx()

        val totalSegments = colors.size

        for(i in 0 until totalSegments) {

            val color = colors[i] // Repeat the colors cyclically
            drawLine(
                color = color, start = Offset(
                    x = (i * totalSegmentWidth) + offset, y = size.height / 2), end = Offset(
                    x = (i * totalSegmentWidth) + offset + segmentWidth, y = size.height / 2),
                strokeWidth = lineWidth, cap = strokeCap)
        }
        var startPos = (offset - segmentWidth)
        var endPos = offset
        for(i in totalSegments - 1 downTo 0) {

            val color = colors[i]

            drawLine(
                color = color, start = Offset(
                    x = startPos, y = size.height / 2), end = Offset(
                    x = endPos, y = size.height / 2), strokeWidth = lineWidth, cap = strokeCap)
            startPos -= segmentWidth
            endPos -= segmentWidth
        }
    }
}

@Composable
fun MultiColorLinearProgressIndicator(
        progress : Float, modifier : Modifier, thickness : Dp, backgroundColor : Color,
        colors : List<Color>, strokeCap : StrokeCap = StrokeCap.Butt) {
    val screenSize = remember { mutableStateOf(0f) }

    Canvas(modifier = modifier) {
        if(screenSize.value == 0f) {
            screenSize.value = size.width
        }

        val segmentWidth = (size.width / colors.size)
        val spacing = 0f
        val totalSegmentWidth = segmentWidth + spacing
        val lineWidth = thickness.toPx()

        val oneProgressWidth = screenSize.value

        val totalSegments = colors.size

        drawLine(
            color = backgroundColor, start = Offset(
                x = 0f, y = size.height / 2), end = Offset(
                x = screenSize.value, y = size.height / 2), strokeWidth = lineWidth,
            cap = strokeCap)

        for(i in 0 until totalSegments) {

            val color = colors[i] // Repeat the colors cyclically
            val start = i * totalSegmentWidth
            val totalProgressWidth = progress * oneProgressWidth
            var segmentEnd = start + segmentWidth
            if(segmentEnd > totalProgressWidth) {
                segmentEnd = totalProgressWidth
            }

            drawLine(
                color = color, start = Offset(
                    x = start, y = size.height / 2), end = Offset(
                    x = segmentEnd, y = size.height / 2), strokeWidth = lineWidth, cap = strokeCap)
        }
    }
}