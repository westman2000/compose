package corp.wmsoft.drawcompose.example

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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import corp.wmsoft.complex.Complex
import corp.wmsoft.complex.complex
import corp.wmsoft.complex.sqrt
import kotlin.math.abs

class ACircle(
    val pos : Offset,
    val bend : Double
) {

    private val radius : Double = abs(1.0/bend)

    val cmp = complex(pos.x, pos.y)

    fun draw(scope: DrawScope, color : Color = Color.Yellow ) {
        scope.drawCircle(
            color =  color,
            center = Offset(pos.x.toFloat(), pos.y.toFloat()), // Центр Canvas
            radius = radius.toFloat(), // Радиус круга
            style = Stroke(width = 1f) // Стиль: линия (обводка) толщиной 5
        )
    }
}

// Calculate curvatures (k-values) for new circles using Descartes' theorem
fun descartes(c1:ACircle, c2:ACircle, c3:ACircle) : Pair<Double,Double> {
    val k1 = c1.bend
    val k2 = c2.bend
    val k3 = c3.bend

    // Sum and product of curvatures for Descartes' theorem
    val sum = k1 + k2 +k3
    val product = abs(k1 * k2 + k2 * k3 + k1 * k3)
    val root = 2 * Math.sqrt(product)

    return Pair(sum+root, sum-root)
}
// Complex calculations based on Descartes' theorem for circle generation
// https://en.wikipedia.org/wiki/Descartes%27_theorem
fun complexDescartes(
    c1:ACircle,
    c2:ACircle,
    c3:ACircle,
    k4:Pair<Double,Double>
) : Complex {
    // Curvature and center calculations for new circles
    val k1 = c1.bend
    val k2 = c2.bend
    val k3 = c3.bend
    val z1 = c1.cmp
    val z2 = c2.cmp
    val z3 = c3.cmp

    val zk1 = z1 * k1
    val zk2 = z2 * k2
    val zk3 = z3 * k3
    val sum = zk1 + zk2 + zk3

    var root = zk1 * zk2 + zk2 * zk3 + zk1 * zk3
    root = sqrt(root) * 2

    val center1 = sum + (root) * (1.0 / k4.first)
    val center2 = sum - (root) * (1.0 / k4.first)
    Log.d("TAG", "complexDescartes: center1:$center1")
    Log.d("TAG", "complexDescartes: center2:$center2")

//    val center3 = sum+(root)*(1.0 / k4.first)
//    val center4 = sum-(root)*(1.0 / k4.first)

    return center1
}


@Preview(showBackground = true)
@Composable
fun ApollonianFractalPrev() {
    ApollonianCircles()
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ApollonianCircles() {
    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }
    val c1 = ACircle(Offset(600f,600f), -1.0/200.0)
    val c2 = ACircle(Offset(700f,600f), 1.0/100.0)
    val c3 = ACircle(Offset(500f,600f), 1.0/100.0)

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

        c1.draw(this)
        c2.draw(this)
        c3.draw(this)

        val k4 = descartes(c1,c2,c3)
        val r4 = abs(1.0/k4.first)

        val c4 = complexDescartes(c1, c2, c3, k4)

        Log.d("TAG", "c4: $c4")
        Log.d("TAG", "c3: ${c3.cmp}")
        Log.d("TAG", "c2: ${c2.cmp}")
        Log.d("TAG", "c1: ${c1.cmp}")

        drawCircle(
            color =  Color.White,
            center = Offset(c4.re.toFloat(), c4.im.toFloat()), // Центр Canvas
            radius = (r4 * 2).toFloat(), // Радиус круга
            style = Stroke(width = 2f) // Стиль: линия (обводка) толщиной 5
        )
    }
}