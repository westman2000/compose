package com.example.myapplicationxr2

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
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
import androidx.compose.ui.zIndex
import com.example.myapplicationxr2.ui.theme.MyApplicationXR2Theme
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun HexagonGridApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                HexagonGridWithCenterSlider()
            }
        }
    }
}

@Composable
fun HexagonGridWithCenterSlider() {
    var indentSize by remember { mutableStateOf(0f) }

    val gridSize = 7
    val centerIndex = gridSize / 2
    val hexSize = 30.dp

    // Calculate hexagon dimensions for layout
    val hexWidth = hexSize * 2
    val hexHeight = hexSize * sqrt(3f)

    // Horizontal distance between hexagon centers
    val horizontalSpacing = hexWidth * 0.75f + indentSize.dp

    // Vertical distance between hexagon centers
    val verticalSpacing = hexHeight + indentSize.dp

    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)
    ) {
        for (row in 0 until gridSize) {
            val isOddRow = row % 2 != 0
            val rowOffset = if (isOddRow) horizontalSpacing / 2 else 0.dp

            for (col in 0 until gridSize) {
                val xPos = horizontalSpacing * col.toFloat() + rowOffset
                val yPos = verticalSpacing * row.toFloat()

                val isCenter = (row == centerIndex && col == centerIndex)

                Box(
                    modifier = Modifier
                        .offset(x = xPos, y = yPos)
                        .zIndex(if (isCenter) 1f else 0f)
                ) {
                    if (isCenter) {
                        // Center hexagon with slider
                        CenterHexagonWithSlider(
                            size = hexSize * 1.2f,  // Make center hexagon slightly larger
                            spacingValue = indentSize,
                            onSpacingChange = { indentSize = it }
                        )
                    } else {
                        // Regular hexagon
                        Hexagon(
                            size = hexSize,
                            text = "$col,$row"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Hexagon(
    size: androidx.compose.ui.unit.Dp,
    text: String,
    color: Color = Color(0xFF3F51B5)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(size * 2)
    ) {
        // Draw hexagon
        Canvas(modifier = Modifier.size(size * 2)) {
            val radius = size.toPx()
            val centerX = size.toPx()
            val centerY = size.toPx()
            val path = Path()

            for (i in 0 until 6) {
                val angle = (Math.PI / 3 * i).toFloat()
                val x = centerX + radius * cos(angle)
                val y = centerY + radius * sin(angle)

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

@Composable
fun CenterHexagonWithSlider(
    size: androidx.compose.ui.unit.Dp,
    spacingValue: Float,
    onSpacingChange: (Float) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(size * 2)
    ) {
        // Draw hexagon
        Canvas(modifier = Modifier.size(size * 2)) {
            val radius = size.toPx()
            val centerX = size.toPx()
            val centerY = size.toPx()
            val path = Path()

            for (i in 0 until 6) {
                val angle = (Math.PI / 3 * i).toFloat()
                val x = centerX + radius * cos(angle)
                val y = centerY + radius * sin(angle)

                if (i == 0) {
                    path.moveTo(x, y)
                } else {
                    path.lineTo(x, y)
                }
            }
            path.close()

            drawPath(path, Color(0xFFE91E63))
        }

        // Content for center hexagon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = "3,3",
                color = Color.White,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "${spacingValue.toInt()} dp",
                color = Color.White,
                fontSize = 10.sp
            )

            Slider(
                value = spacingValue,
                onValueChange = onSpacingChange,
                valueRange = 0f..48f,
                modifier = Modifier.width(size)
            )
        }
    }
}

@PreviewLightDark
@Composable
fun HexagonGridAppPreview() {
    HexagonGridApp()
}