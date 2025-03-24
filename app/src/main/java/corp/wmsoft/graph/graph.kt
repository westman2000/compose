package corp.wmsoft.graph

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import corp.wmsoft.drawcompose.example.distanceTo


@Preview(showBackground = true)
@Composable
fun GraphPreview() {
    Graph()
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Graph() {

    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }
    val circleCenter = Offset(200f, 200f) // Примерные координаты центра круга
    val circleRadius = 50f // Радиус круга
    val step = 100 // Шаг сетки в пикселях

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { motionEvent ->

                hoverPositionOffset = Offset(motionEvent.x, motionEvent.y)
                Log.d(
                    "", "tool: " +
                            "${motionEvent.getToolType(0)}\nhober:$hoverPositionOffset"
                )
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // Обработка касания стилусом
                        println("Stylus ACTION_DOWN")
                        true // Возвращаем true, чтобы указать, что событие обработано
                    }

                    MotionEvent.ACTION_UP -> {
                        // Обработка касания стилусом
                        println("Stylus ACTION_UP")
                        true // Возвращаем true, чтобы указать, что событие обработано
                    }

                    MotionEvent.ACTION_MOVE -> {
                        // Обработка движения стилусом
//                        println("Stylus ACTION_MOVE")
                        true
                    }

                    MotionEvent.ACTION_CANCEL -> {
                        // Обработка движения стилусом
                        println("Stylus ACTION_CANCEL")
                        true
                    }

                    MotionEvent.ACTION_OUTSIDE -> {
                        // Обработка движения стилусом
                        println("Stylus ACTION_OUTSIDE")
                        true
                    }

                    else -> false
                }

            }
    ) {

        val center = graph(step)

        val isHoveringOverCircle = hoverPositionOffset
            .distanceTo(center) <= circleRadius

        drawCircle(
            color = if (isHoveringOverCircle) Color.Green else Color.Red,
            center = Offset(center.x, center.y),
            radius = circleRadius
        )

    }
}

fun DrawScope.graph(step:Int = 100) : Offset {

    val center = Offset(
        size.width/2f,
        size.height/2f
    )

    // Рисуем координатную сетку
    for (x in center.x.toInt() until size.width.toInt() step step) {
        drawLine(
            color = Color.Magenta,
            start = Offset(x.toFloat(), 0f),
            end = Offset(x.toFloat(), size.height),
            strokeWidth = 1f
        )
    }
    for (x in center.x.toInt() downTo  0 step step) {
        drawLine(
            color = Color.Cyan,
            start = Offset(x.toFloat(), 0f),
            end = Offset(x.toFloat(), size.height),
            strokeWidth = 1f
        )
    }
    for (y in center.y.toInt() until size.height.toInt() step step) {
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, y.toFloat()),
            end = Offset(size.width, y.toFloat()),
            strokeWidth = 1f
        )
    }
    for (y in center.y.toInt() downTo 0  step step) {
        drawLine(
            color = Color.Blue,
            start = Offset(0f, y.toFloat()),
            end = Offset(size.width, y.toFloat()),
            strokeWidth = 1f
        )
    }

    // OY
    drawLine(
        color = Color.Green,
        start = Offset(size.width/2.0f, 0f),
        end = Offset(size.width/2.0f, size.height),
        strokeWidth = 3f
    )

    // OX
    drawLine(
        color = Color.Green,
        start = Offset(0f, size.height/2.0f),
        end = Offset(size.width, size.height/2.0f),
        strokeWidth = 3f
    )

    return center
}