package com.example.myapplicationxr2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.math.sqrt
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.foundation.layout.size
import androidx.compose.ui.input.pointer.pointerInteropFilter
import android.view.MotionEvent
import androidx.compose.ui.tooling.preview.PreviewScreenSizes


class HexagonShape : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val path = Path().apply {
            val radius = size.minDimension / 2
            for (i in 0..5) {
                val angle = Math.toRadians((60.0 * i - 30))
                val x = size.width / 2 + radius * cos(angle).toFloat()
                val y = size.height / 2 + radius * sin(angle).toFloat()
                if (i == 0) moveTo(x, y) else lineTo(x, y)
            }
            close()
        }
        return Outline.Generic(path)
    }
}

@Composable
fun HexagonShapeComposable(
    size: Dp = 330.dp,
    color: Color = Color.Cyan
) {
    // Usage
    Box(
        modifier = Modifier
            .size(size)
            .clip(HexagonShape())
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text("Hex UI", color = Color.White)
    }
}

@PreviewLightDark
@Composable
fun HexagonShapeComposablePreview() {
    HexagonShapeComposable()
}

@Composable
fun HoneycombGrid(
    rows: Int = 7,
    columns: Int = 7,
    hexagonSize: Dp = 80.dp,
    hexagonSpacing: Dp = 4.dp,
    hexagonColor: Color = Color.Cyan
) {
    val hexHeight = hexagonSize.value
    val hexWidth = sqrt(3f) / 2 * hexHeight
    val verticalSpacing = (hexHeight * 0.75f + hexagonSpacing.value).dp
    val horizontalSpacing = (hexWidth + hexagonSpacing.value).dp

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(hexagonSpacing)
    ) {
        for (row in 0 until rows) {
            val offsetX = if (row % 2 == 0) 0.dp else (hexWidth / 2 + hexagonSpacing.value / 2).dp
            Row(
                modifier = Modifier
                    .offset(x = offsetX),
                horizontalArrangement = Arrangement.spacedBy(hexagonSpacing)
            ) {
                for (col in 0 until columns) {
                    HexagonShapeComposable(
                        size = hexagonSize,
                        color = hexagonColor
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height((verticalSpacing - hexagonSize)
                        .coerceAtLeast(0.dp)
                    )
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun HoneycombGridPreview() {
    HoneycombGrid()
}


@Composable
fun AdaptiveHoneycombGrid(
    rows: Int,
    columns: Int,
    hexagonSpacing: Dp = 4.dp,
    hexagonColor: Color = Color(0xFF03A9F4),
    onHexagonClick: (row: Int, col: Int) -> Unit,
    onHexagonHover: (row: Int, col: Int, hovered: Boolean) -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp - 32.dp // padding
    val hexWidth = (screenWidth.value - (columns - 1) * hexagonSpacing.value) / (columns + 0.5f)
    val hexHeight = (hexWidth * (2 / sqrt(3f)))

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(hexagonSpacing)
    ) {
        for (row in 0 until rows) {
            val offsetX = if (row % 2 == 0) 0.dp else (hexWidth / 2 + hexagonSpacing.value / 2).dp
            Row(
                modifier = Modifier.offset(x = offsetX),
                horizontalArrangement = Arrangement.spacedBy(hexagonSpacing)
            ) {
                for (col in 0 until columns) {
                    InteractiveHexagon(
                        size = hexHeight.dp,
                        color = hexagonColor,
                        label = "$row,$col",
                        onClick = { onHexagonClick(row, col) },
                        onHover = { hovered -> onHexagonHover(row, col, hovered) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(((hexHeight * 0.25f).dp + hexagonSpacing)))
        }
    }
}

@Composable
fun InteractiveHexagon(
    size: Dp,
    color: Color,
    label: String,
    onClick: () -> Unit,
    onHover: (Boolean) -> Unit
) {
    var hovered by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .size(size)
            .clip(HexagonShape())
            .background(if (hovered) color.copy(alpha = 0.7f) else color)
            .pointerInteropFilter { motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_HOVER_ENTER -> {
                        hovered = true
                        onHover(true)
                    }
                    MotionEvent.ACTION_HOVER_EXIT -> {
                        hovered = false
                        onHover(false)
                    }
                }
                false
            }
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = Color.White)
    }
}

@Composable
fun HoneycombExampleScreen() {
    val (clickedHex, setClickedHex) = remember { mutableStateOf("None") }
    val (hoveredHex, setHoveredHex) = remember { mutableStateOf("None") }

    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            AdaptiveHoneycombGrid(
                rows = 4,
                columns = 5,
                hexagonSpacing = 4.dp,
                hexagonColor = Color(0xFF6200EE),
                onHexagonClick = { row, col ->
                    setClickedHex("Clicked hexagon: [$row, $col]")
                },
                onHexagonHover = { row, col, hovered ->
                    if (hovered)
                        setHoveredHex("Hovered hexagon: [$row, $col]")
                    else
                        setHoveredHex("None")
                }
            )
            Spacer(Modifier.height(20.dp))
            Text(clickedHex, modifier = Modifier.padding(16.dp))
            Text(hoveredHex, modifier = Modifier.padding(16.dp))
        }
    }
}

@PreviewLightDark
@Composable
fun HoneycombExampleScreenPreview() {
    HoneycombExampleScreen()
}
