package com.example.myapplicationxr2

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun HexagonGrid2App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                HoneycombGrid()
            }
        }
    }
}

@Composable
fun HoneycombGrid() {
    val gridSize = 7
    val hexRadius = 30.dp

    // In a honeycomb, distance between centers horizontally is 2*radius
    val horizontalDistance = hexRadius * 2

    // In a honeycomb, distance between centers vertically is sqrt(3)*radius
    val verticalDistance = hexRadius * sqrt(3f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        for (row in 0 until gridSize) {
            for (col in 0 until gridSize) {
                // Offset columns in odd rows to create honeycomb pattern
                val isOddRow = row % 2 == 1
                val xOffset = if (isOddRow) horizontalDistance / 2 else 0.dp

                val xPos = horizontalDistance * col.toFloat() + xOffset
                val yPos = verticalDistance * row.toFloat()

                Box(
                    modifier = Modifier
                        .offset(x = xPos, y = yPos)
                ) {
                    // Highlight the center hexagon with a different color
                    val isCenter = (row == gridSize / 2 && col == gridSize / 2)
                    val hexColor = if (isCenter) Color(0xFFE91E63) else Color(0xFF3F51B5)

                    Hexagon2(
                        radius = hexRadius,
                        text = "$col,$row",
                        color = hexColor
                    )
                }
            }
        }
    }
}

@Composable
fun Hexagon2(
    radius: androidx.compose.ui.unit.Dp,
    text: String,
    color: Color = Color(0xFF3F51B5)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2)
    ) {
        // Draw hexagon
        Canvas(modifier = Modifier.size(radius * 2)) {
            val radiusPx = radius.toPx()
            val centerX = radiusPx
            val centerY = radiusPx
            val path = Path()

            // Create hexagon path - starting at top point and going clockwise
            for (i in 0 until 6) {
                val angle = (Math.PI / 3 * i - Math.PI / 6).toFloat()
                val x = centerX + radiusPx * cos(angle)
                val y = centerY + radiusPx * sin(angle)

                if (i == 0) {
                    path.moveTo(x, y)
                } else {
                    path.lineTo(x, y)
                }
            }
            path.close()

            drawPath(path, color)
        }

        // Position text
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@PreviewLightDark
@Composable
fun HexagonGrid2AppPreview() {
    HexagonGrid2App()
}
