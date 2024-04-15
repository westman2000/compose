package corp.wmsoft.apolo


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
import corp.wmsoft.drawcompose.example.ACircle
import kotlin.math.PI
import kotlin.random.Random
import kotlin.math.cos
import kotlin.math.sin

import kotlin.math.sqrt
import kotlin.math.abs

// Defines an array list to hold all circles in the gasket
var allCircles = mutableListOf<Circle>()
// Queue for circles to process for the next generation
var queue = mutableListOf<List<Circle>>()
// Tolerance for calculating tangency and overlap
val epsilon = 0.1

data class Vector(var x: Double, var y: Double) {
    fun magnitude(): Double = kotlin.math.sqrt(x * x + y * y)
}
fun setup(canvas: DrawScope) {
    val width = canvas.size.width// canvas.width.toFloat()
    val height = canvas.size.height// canvas.height.toFloat()

    // Initialize first circle centered on canvas
    val c1 = Circle(-1.0 / (width / 2.0), width / 2.0, height / 2.0)
    val r2 = Random.nextDouble(100.0, c1.radius / 2)
    var angle = Random.nextDouble(2 * PI)
    var v = Vector(cos(angle) * (c1.radius - r2), sin(angle) * (c1.radius - r2))

    // Second circle positioned randomly within the first
    val c2 = Circle(1 / r2, width / 2 + v.x, height / 2 + v.y)
    val r3 = v.magnitude()
    angle += PI
    v = Vector(cos(angle) * (c1.radius - r3), sin(angle) * (c1.radius - r3))

    // Third circle also positioned relative to the first
    val c3 = Circle(1 / r3, width / 2 + v.x, height / 2 + v.y)
    allCircles = mutableListOf(c1, c2, c3)
    // Initial triplet for generating next generation of circles
    queue = mutableListOf(listOf(c1, c2, c3))
}

// Check if the potential new circle is valid
fun validate(c4: Circle, c1: Circle, c2: Circle, c3: Circle): Boolean {
    // Discards too small circles to avoid infinite recursion
    if (c4.radius < 2) return false

    for (other in allCircles) {
        val d = c4.dist(other)
        val radiusDiff = abs(c4.radius - other.radius)
        // Ensures new circle doesn't overlap or is too close to existing circles
        if (d < epsilon && radiusDiff < epsilon) {
            return false
        }
    }

    // Check if all 4 circles are mutually tangential
    if (!isTangent(c4, c1)) return false
    if (!isTangent(c4, c2)) return false
    if (!isTangent(c4, c3)) return false

    return true
}

// Determine if two circles are tangent to each other
fun isTangent(c1: Circle, c2: Circle): Boolean {
    val d = c1.dist(c2)
    val r1 = c1.radius
    val r2 = c2.radius
    // Tangency check based on distances and radii
    val a = abs(d - (r1 + r2)) < epsilon
    val b = abs(d - abs(r2 - r1)) < epsilon
    return a || b
}

// Complex calculations based on Descartes' theorem for circle generation
fun complexDescartes(c1: Circle, c2: Circle, c3: Circle, k4: List<Double>): List<Circle> {
    val k1 = c1.bend
    val k2 = c2.bend
    val k3 = c3.bend
    val z1 = c1.center
    val z2 = c2.center
    val z3 = c3.center

    val zk1 = z1.scale(k1)
    val zk2 = z2.scale(k2)
    val zk3 = z3.scale(k3)
    val sum = zk1.add(zk2).add(zk3)

    val root = zk1.mult(zk2).add(zk2.mult(zk3)).add(zk1.mult(zk3))
    val scaledRoot = root.sqrt().scale(2.0)
    val center1 = sum.add(scaledRoot).scale(1 / k4[0])
    val center2 = sum.sub(scaledRoot).scale(1 / k4[0])
    val center3 = sum.add(scaledRoot).scale(1 / k4[1])
    val center4 = sum.sub(scaledRoot).scale(1 / k4[1])

    return listOf(
        Circle(k4[0], center1.a, center1.b),
        Circle(k4[0], center2.a, center2.b),
        Circle(k4[1], center3.a, center3.b),
        Circle(k4[1], center4.a, center4.b)
    )
}

// Calculate curvatures (k-values) for new circles using Descartes' theorem
fun descartes(c1: Circle, c2: Circle, c3: Circle): List<Double> {
    val k1 = c1.bend
    val k2 = c2.bend
    val k3 = c3.bend
    val sum = k1 + k2 + k3
    val product = abs(k1 * k2 + k2 * k3 + k1 * k3)
    val root = 2 * sqrt(product)
    return listOf(sum + root, sum - root)
}

// Continues to process new generations of circles
fun nextGeneration() {
    val nextQueue = mutableListOf<List<Circle>>()
    for (triplet in queue) {
        val (c1, c2, c3) = triplet
        // Calculate curvature for the next circle
        val k4 = descartes(c1, c2, c3)
        // Generate new circles based on Descartes' theorem
        val newCircles = complexDescartes(c1, c2, c3, k4)

        Log.d("TAG", "nextGeneration: newCircles:${newCircles.size}")

        for (newCircle in newCircles) {
            if (validate(newCircle, c1, c2, c3)) {
                Log.d("TAG", "ADD newCircle:$newCircle")
                allCircles.add(newCircle)
                // New triplets formed with the new circle for the next generation
                val t1 = listOf(c1, c2, newCircle)
                val t2 = listOf(c1, c3, newCircle)
                val t3 = listOf(c2, c3, newCircle)
                nextQueue.addAll(listOf(t1, t2, t3))
            }
        }
    }
    queue = nextQueue
}

fun draw(canvas: DrawScope) {

    // Current total circles
    val len1 = allCircles.size

    Log.d("TAG", "draw: len1:$len1")
    // Generate next generation of circles
    nextGeneration()

    // New total circles
    val len2 = allCircles.size
    Log.d("TAG", "draw: len2:$len2")

    // Stop drawing when no new circles are added
    if (len1 == len2) {
        Log.d("TAG", "done ($len1 == $len2)")
        return
        // Assuming a function `noLoop()` to stop the drawing loop, replace with appropriate control mechanism
    }

    if (len2 > 9000)
        return


    // Display all circles
    for (c in allCircles) {
        c.show(canvas)
    }

    draw(canvas)
}



@Preview(showBackground = true)
@Composable
fun ApolloPreview() {
    Apollo()
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Apollo() {
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

        setup(this)
        draw(this)
    }
}