package org.wmsoft.drawcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.input.pointer.pointerInteropFilter
import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi

import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoverExample()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HoverExample() {
    var hoverPosition by remember { mutableStateOf(Pair(0.0f, 0.0f)) }
    val circleCenter = Pair(200f, 200f) // Примерные координаты центра круга
    val circleRadius = 100f // Радиус круга

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        Canvas(
            modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter { motionEvent ->

                hoverPosition = Pair(motionEvent.x, motionEvent.y)

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
            val isHoveringOverCircle = hoverPosition.distanceTo(circleCenter) <= circleRadius
            drawCircle(
                color = if (isHoveringOverCircle) Color.Green else Color.Red,
                center = Offset(circleCenter.first, circleCenter.second),
                radius = circleRadius
            )

            // Рисуем круг
            drawCircle(
                color = Color.Blue,
                center = center, // Центр Canvas
                radius = 100f, // Радиус круга
                style = Stroke(width = 5f) // Стиль: линия (обводка) толщиной 5
            )

            // Рисуем прямоугольник
            drawRect(
                color = Color.Magenta,
                topLeft = Offset(x = 100f, y = 500f),
                size = Size(width = 200f, height = 150f)
            )
        }
    }
}

// Расширение для вычисления расстояния между двумя точками
fun Pair<Float,Float>.distanceTo(other: Pair<Float,Float>): Float =
    sqrt((this.first - other.first).pow(2) + (this.second - other.second).pow(2)).toFloat()

@Preview(showBackground = true)
@Composable
fun DrawingExamplePreview() {
    HoverExample()
}