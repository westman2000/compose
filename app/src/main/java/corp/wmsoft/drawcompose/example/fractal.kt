package corp.wmsoft.drawcompose.example

import android.graphics.Typeface
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
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.drawText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.math.floor
import kotlin.random.Random


// region fractal animation

@Preview(showBackground = true)
@Composable
fun FractalsPreview() {
    Fractals()
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Fractals() {
    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { motionEvent ->

                hoverPositionOffset = Offset(motionEvent.x, motionEvent.y)
                Log.d("","tool: ${motionEvent.getToolType(0)}")
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
        // Рисуем координатную сетку
        val step = 50f // Шаг сетки в пикселях
        for (x in 0 until size.width.toInt() step step.toInt()) {
            drawLine(
                color = Color.Gray,
                start = Offset(x.toFloat(), 0f),
                end = Offset(x.toFloat(), size.height),
                strokeWidth = 1f
            )
        }
        for (y in 0 until size.height.toInt() step step.toInt()) {
            drawLine(
                color = Color.Gray,
                start = Offset(0f, y.toFloat()),
                end = Offset(size.width, y.toFloat()),
                strokeWidth = 1f
            )
        }

        drawFractal(
            Color.White,
            center,
            30f,
            0,
            0.0
        )
    }
}


val textPaint = Paint().asFrameworkPaint().apply {
    isAntiAlias = false
    textSize = 11F
    color = android.graphics.Color.WHITE
    typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
}
fun DrawScope.drawFractal(
    circleColor : Color,
    circleCenter : Offset = center,
    circleRadius : Float,
    n : Int,
    angle : Double
) {
    if (angle <= 350) {

        // Рисуем круг
        drawCircle(
            color = Color.Yellow,
            center = circleCenter, // Центр Canvas
            radius = circleRadius, // Радиус круга
            style = Stroke(width = 1f) // Стиль: линия (обводка) толщиной 5
        )
        // draw text label
        drawIntoCanvas {
            it.nativeCanvas.drawText(
                "$n",
                circleCenter.x - circleRadius + 3,            // x-coordinates of the origin (top left)
                circleCenter.y + 4, // y-coordinates of the origin (top left)
                textPaint
            )
        }

        val newAngle = angle + 10  // Увеличиваем угол на 10 градусов на каждом шаге
        val newRadius = circleRadius// * 0.9f  // Уменьшаем радиус на 10%
        val nextX = circleCenter.x + Math.cos(Math.toRadians(newAngle)) * newRadius * 2  // Новая x-координата
        val nextY = circleCenter.y + Math.sin(Math.toRadians(newAngle)) * newRadius * 2  // Новая y-координата

        // recursion
        drawFractal(
            circleColor,
            Offset(nextX.toFloat(), nextY.toFloat()),
            newRadius,
            n + 1,
            newAngle
        )
//        drawFractal(
//            circleColor,
//            Offset(
//                circleCenter.x+circleRadius * 2,
//                circleCenter.y
//            ),
//            circleRadius,
//            n-1,
//            angle+5
//        )
    }
}
// endregion