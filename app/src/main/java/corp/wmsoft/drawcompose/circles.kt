package corp.wmsoft.drawcompose

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
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import corp.wmsoft.komplex.Complex
import corp.wmsoft.komplex.abs
import corp.wmsoft.komplex.exp
import corp.wmsoft.komplex.i
import corp.wmsoft.komplex.plus
import corp.wmsoft.komplex.times
import kotlin.math.PI

// https://www.geogebra.org/m/s4ca4zeb

@Preview(showBackground = true)
@Composable
fun InfinityCirclesPreview() {
    InfinityCircles()
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InfinityCircles() {
    var hoverPositionOffset by remember { mutableStateOf(Offset(0.0f, 0.0f)) }

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
//
//        val a = -5.0
//        val n = 0.0
//        val m = 0.0
//        val angle = 0.0


//        val z1 = i + a
//        val z2 = (1.0/(abs(z1))) * exp(i * (PI /2.0 + z1.arg))
//        val z3 = 0.5 + 1.5 * i + 0.5 * exp(i * angle) + n + i * m
//        val z4 = (1.0/(abs(z3))) * exp(i * (PI /2.0 + z3.arg))

        val list = mutableListOf<Offset>()


        for (m in 0 .. 3) {
            for (n in -3..3) {
                for (a in -3..3) {
                    for (angle in 0..360) {
                        val z1 = i + a
                        val z2 = (1.0 / (abs(z1))) * exp(i * (PI / 2.0 + z1.arg))
                        val z3 = 0.5 + 1.5 * i + 0.5 * exp(i * angle) + n.toDouble() + i * m.toDouble()
                        val z4 = (1.0 / (abs(z3))) * exp(i * (PI / 2.0 + z3.arg))

                        list.add(z1.toOffset())
                        list.add(z2.toOffset())
                        list.add(z3.toOffset())
                        list.add(z4.toOffset())
                    }
                }
            }
        }
        drawPoints(
            points = list,
            pointMode = PointMode.Points,
            color = Color.White,
            strokeWidth = 1f
        )
    }
}

fun Complex.toOffset() : Offset {

    return Offset(
        this.real.toFloat() * 100f + 600, this.img.toFloat() * 100f + 600
    )
}