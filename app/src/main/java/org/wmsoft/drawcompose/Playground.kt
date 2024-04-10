package org.wmsoft.drawcompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview

// region -= ApollonianFractal =-
@Composable
fun Apollonian() {

    var pointerOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }


    Canvas(
        modifier = Modifier.fillMaxSize()
            .pointerInput("dragging") {
                detectDragGestures { change, dragAmount ->
                    pointerOffset += dragAmount
                }
            }

    ) {

        val mainCircleRadius = size.minDimension / 3f

        val mainCircleCenter = Offset(
            size.width / 2,
            size.height / 2
        )

        // draw main circle
        drawCircle(
            color = Color.Red,
            radius = mainCircleRadius,
            center = mainCircleCenter,
            style = Stroke(width = 1f)
        )

        drawApollonian(mainCircleCenter, mainCircleRadius)
    }
}
fun DrawScope.drawApollonian(mainCenter: Offset, mainRadius: Float) {

    val canvasQuadrantSize = size / 2F
    drawRect(
        color = Color.Gray,
        size = canvasQuadrantSize
    )

    val canvasWidth = size.width
    val canvasHeight = size.height
    drawLine(
        start = Offset(x = canvasWidth, y = 0f),
        end = Offset(x = 0f, y = canvasHeight),
        color = Color.Blue
    )

    val path = Path().apply {
        moveTo(0f, 0f)
        lineTo(size.width / 2f, size.height / 2f)
        lineTo(size.width, 0f)
        close()
    }

    drawPath(path, Color.Magenta, style = Stroke(width = 2f))


    // Расстояние от центра к центру касающихся кругов
    val touchingRadius = mainRadius / 2.0f
    val distanceFromCenter = mainRadius - touchingRadius

    if (touchingRadius - 10.0f <= 10.0f )
        return

    val x = mainCenter.x + distanceFromCenter
    val y = mainCenter.y
    val touchingCenter = Offset(x, y)

    drawCircle(
        color = Color(255, 255, touchingRadius.toInt()),
        radius = touchingRadius,
        center = touchingCenter,
        style = Stroke(width = 1f)
    )

    // Рекурсивный вызов для рисования кругов, касающихся вторичных кругов
    drawApollonianFractal(
        Offset(mainCenter.x + distanceFromCenter, mainCenter.y),
        touchingRadius
    )

}
@Preview(showBackground = true)
@Composable
fun ApollonianPreview() {
    Apollonian()
}
// endregion