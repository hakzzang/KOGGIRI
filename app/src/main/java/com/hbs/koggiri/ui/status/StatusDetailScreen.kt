package com.hbs.koggiri.ui.status

import android.text.TextPaint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.home.HomeUiState
import com.hbs.koggiri.ui.theme.Green500
import com.hbs.koggiri.ui.theme.NeutralVariant95

@Composable
fun StatusDetailScreen(
    uiState: HomeUiState,
    title: String,
    isComplete: Boolean,
    onComplete: (Boolean) -> Unit,
    items: List<Float> = listOf(0.1f, 0.2f, 0.5f, 0.2f),
    colors: List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        Green500
    )
) {
    val scrollState = rememberScrollState()
    val containerColor = animateColorAsState(targetValue = if (isComplete) MaterialTheme.colorScheme.surface else Green500)
    val contentColor = animateColorAsState(if (isComplete) MaterialTheme.colorScheme.primary else Color.White)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NeutralVariant95)
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 96.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 24.dp, bottom = 24.dp)
    ) {
        Row {
            KoggiriMediumTitle(
                title = title,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedCircle(
            "Status",
            items,
            colors,
            Modifier
                .height(300.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = { onComplete(true) },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
            contentPadding = PaddingValues(
                start = 8.dp,
                top = 0.dp,
                end = 8.dp,
                bottom = 0.dp
            ),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = containerColor.value,
                contentColor = contentColor.value
            )
        ) {
            // Inner content including an icon and a text label
            Icon(
                Icons.Filled.CheckCircle,
                contentDescription = "Complete",
                modifier = Modifier.size(28.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Complete", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun AnimatedCircle(
    chartTitle: String,
    proportions: List<Float>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    val currentState = remember {
        MutableTransitionState(AnimatedCircleProgress.START)
            .apply { targetState = AnimatedCircleProgress.END }
    }
    val stroke = with(LocalDensity.current) { Stroke(12.dp.toPx()) }
    val transition = updateTransition(currentState, label = "chart")
    val angleOffset by transition.animateFloat(
        transitionSpec = {
            tween(
                delayMillis = 500,
                durationMillis = 900,
                easing = LinearOutSlowInEasing
            )
        }, label = "chart"
    ) { progress ->
        if (progress == AnimatedCircleProgress.START) {
            0f
        } else {
            360f
        }
    }

    val shift by transition.animateFloat(
        transitionSpec = {
            tween(
                delayMillis = 500,
                durationMillis = 900,
                easing = CubicBezierEasing(0f, 0.75f, 0.35f, 0.85f)
            )
        }, label = "chart"
    ) { progress ->
        if (progress == AnimatedCircleProgress.START) {
            0f
        } else {
            30f
        }
    }

    Canvas(modifier) {
        val innerRadius = (size.minDimension - stroke.width) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - innerRadius,
            halfSize.height - innerRadius
        )
        val size = Size(innerRadius * 2, innerRadius * 2)
        var startAngle = shift - 90f
        proportions.forEachIndexed { index, proportion ->
            val sweep = proportion * angleOffset
            drawArc(
                color = colors[index],
                startAngle = startAngle + DividerLengthInDegrees / 2,
                sweepAngle = sweep - DividerLengthInDegrees,
                topLeft = topLeft,
                size = size,
                useCenter = false,
                style = stroke
            )
            startAngle += sweep
        }
        drawIntoCanvas { canvas ->
            canvas.nativeCanvas.drawText(
                chartTitle,
                0,
                chartTitle.length,
                size.width / 2f + stroke.width,
                size.height / 2f + stroke.width,
                TextPaint().apply {
                    isAntiAlias = true
                    style = android.graphics.Paint.Style.FILL
                    textSize = 64f
                    color = android.graphics.Color.BLACK
                }
            )
        }
    }
}

private enum class AnimatedCircleProgress { START, END }

private const val DividerLengthInDegrees = 1.8f