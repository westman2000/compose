package corp.wmsoft.drawcompose

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
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.withTransform

import kotlin.math.sqrt
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InvertedYAxisCanvas()
        }
    }
}

@Composable
fun InvertedYAxisCanvas() {
    Canvas(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        // Применяем преобразование ко всему, что рисуется внутри
        withTransform(
            // Сначала сдвигаем, потом масштабируем
            transformBlock = {
                // Отражаем по оси Y, чтобы Y шла вверх
                scale(1f, -1f)
                // Сдвигаем канву вниз после отражения
//                translate(0f, -centerY)
            },
            drawBlock = {
                // Теперь рисуем с учётом изменённых осей
                // Нарисуем линию, чтобы показать, что ось Y теперь направлена вверх
//                drawLine(
//                    start = Offset(centerX, size.height), // Теперь это нижняя точка
//                    end = Offset(centerX, 0f), // Теперь это верхняя точка
//                    color = Color.Red,
//                    strokeWidth = 5f
//                )
//                drawCircle(
//                    color = Color.Green,
//                    center = Offset(centerX, centerY),
//                    radius = 100.0f
//                )
//                val rectOffset = Offset(centerX + 100, centerY)
//                val rectSize = Size(width = 200f, height = 150f)
//                drawRect(
//                    color = Color.Magenta,
//                    topLeft = rectOffset,
//                    size = rectSize
//                )

                drawLine(
                    start = center,
                    end = Offset(center.x + size.width, center.y),
                    color = androidx.compose.ui.graphics.Color.Red
                )
                drawLine(
                    start = center,
                    end = Offset(center.x, center.y + size.height),
                    color = androidx.compose.ui.graphics.Color.Green
                )
            }
        )
    }
}

// region -= CenteredCanvas =-
@Composable
fun CenteredCanvas() {
    val density = LocalDensity.current.density

    // Вы можете задать размеры Canvas здесь, если нужен не весь экран
    val canvasWidth: Dp = 300.dp
    val canvasHeight: Dp = 300.dp
    val canvasWidthPx = canvasWidth.value * density
    val canvasHeightPx = canvasHeight.value * density

    Canvas(modifier = Modifier.fillMaxSize()) {
        // Центр Canvas
        val centerX = size.width / 2
        val centerY = size.height / 2

        // Теперь у нас есть центр Canvas как центр координат
        val center = Offset(centerX, centerY)

        // Используйте center для рисования
        drawSomething(center)
    }
}
fun DrawScope.drawSomething(center: Offset) {
    // Рисуйте что-либо с учётом центра как начала координат
    // Например, рисуем линию от центра вправо
    drawLine(
        start = center,
        end = Offset(center.x + 100, center.y),
        color = androidx.compose.ui.graphics.Color.Red
    )
    drawLine(
        start = center,
        end = Offset(center.x, center.y + 100),
        color = androidx.compose.ui.graphics.Color.Green
    )
}
@Preview(showBackground = true)
@Composable
fun CenteredCanvasPreview() {
    CenteredCanvas()
}
// endregion


// region -= ApollonianFractal =-
@Composable
fun ApollonianFractal() {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val mainCircleRadius = size.minDimension / 3f

        val mainCircleCenter = Offset(size.width / 2, size.height / 2)

        // draw main circle
        drawCircle(
            color = Color.Red,
            radius = mainCircleRadius,
            center = mainCircleCenter,
            style = Stroke(width = 1f)
        )

        drawApollonianFractal(mainCircleCenter, mainCircleRadius)
    }
}
fun DrawScope.drawApollonianFractal(mainCenter: Offset, mainRadius: Float) {

    // Расстояние от центра к центру касающихся кругов
    val touchingRadius = mainRadius / 2.0f
    val distanceFromCenter = mainRadius - touchingRadius

    if (touchingRadius - 1.0f <= 3.0f )
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
    drawApollonianFractal(
        Offset(mainCenter.x - distanceFromCenter, mainCenter.y),
        touchingRadius
    )

}
@Preview(showBackground = true)
@Composable
fun ApollonianFractalPreview() {
    ApollonianFractal()
}
// endregion


//////////////////////////////////////////////
@Composable
fun ApollonianGasket() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val mainCircleRadius = size.minDimension / 3f
        val mainCircleCenter = Offset(size.width / 2, size.height / 2)
        drawCircle(Color.White, mainCircleRadius, mainCircleCenter)
        drawTouchingCircles(mainCircleCenter, mainCircleRadius, 3)
    }
}

fun DrawScope.drawTouchingCircles(center: Offset, radius: Float, depth: Int) {
    if (depth == 0) return

    // Рассчитываем радиусы и позиции касающихся кругов
    val touchingRadius = radius / 2
    val distanceFromCenter = radius + touchingRadius
    val angles = listOf(0, 120, 240)

    angles.forEach { angle ->
        val radian = Math.toRadians(angle.toDouble()).toFloat()
        val x = center.x + distanceFromCenter * kotlin.math.cos(radian)
        val y = center.y + distanceFromCenter * kotlin.math.sin(radian)
        val touchingCenter = Offset(x, y)
        drawCircle(Color.White, touchingRadius, touchingCenter)

        // Рекурсивный вызов для рисования дальнейших касающихся кругов
        drawTouchingCircles(touchingCenter, touchingRadius, depth - 1)
    }
}

@Preview(showBackground = true)
@Composable
fun ApollonianGasketPreview() {
    ApollonianGasket()
}

//////////////////////////////////////////////
@Composable
fun InfiniteCircles() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 4
        drawCircleRecursive(center, radius, 5) // Начинаем с 5 итераций
    }
}

fun DrawScope.drawCircleRecursive(center: Offset, radius: Float, depth: Int) {
    if (depth == 0) return

    // Рисуем текущий круг
    drawCircle(
        color = androidx.compose.ui.graphics.Color.White,
        center = center,
        radius = radius,
        style = Stroke(width = 5f)
    )

    // Количество кругов увеличивается с каждой итерацией
    val numberOfCircles = 6
    val angleIncrement = 360f / numberOfCircles

    for (i in 0 until numberOfCircles) {
        val angle = Math.toRadians((angleIncrement * i).toDouble()).toFloat()
        val nextCenter = Offset(
            center.x + kotlin.math.cos(angle) * radius * 1.5f,
            center.y + kotlin.math.sin(angle) * radius * 1.5f
        )
        // Рекурсивно рисуем следующие круги меньшего размера
        drawCircleRecursive(nextCenter, radius / 2f, depth - 1)
    }
}

@Preview(showBackground = true)
@Composable
fun InfiniteCirclesPreview() {
    InfiniteCircles()
}

//////////////////////////////////////////////
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HoverExample() {

    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }

    val circleCenter = Offset(200f, 200f) // Примерные координаты центра круга
    val circleRadius = 100f // Радиус круга
    val rectOffset = Offset(x = 100f, y = 500f)
    val rectSize = Size(width = 200f, height = 150f)

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
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
            val isHoveringOverCircle = hoverPositionOffset.distanceTo(circleCenter) <= circleRadius
            drawCircle(
                color = if (isHoveringOverCircle) Color.Green else Color.Red,
                center = Offset(circleCenter.x, circleCenter.y),
                radius = circleRadius
            )

            val isHoveringOverCircle2 = hoverPositionOffset.distanceTo(center) <= circleRadius
            // Рисуем круг
            drawCircle(
                color = if (isHoveringOverCircle2) Color.Green else Color.Blue,
                center = center, // Центр Canvas
                radius = circleRadius, // Радиус круга
                style = Stroke(width = 5f) // Стиль: линия (обводка) толщиной 5
            )

            // Рисуем прямоугольник
            drawRect(
                color = if (hoverPositionOffset.isInsideRectangle(rectOffset,rectSize)) Color.Green else Color.Magenta,
                topLeft = rectOffset,
                size = rectSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawingExamplePreview() {
    HoverExample()
}