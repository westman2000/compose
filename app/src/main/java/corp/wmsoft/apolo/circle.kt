package corp.wmsoft.apolo

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.abs

// Defines a circle in terms of its bend (curvature) and center point
class Circle(bend: Double, x: Double, y: Double) {
    // Center is stored as a Complex number
    val center = Complex(x, y)
    val bend = bend
    // Radius is derived from the absolute value of the reciprocal of bend
    val radius = abs(1 / bend)

    fun show(d:DrawScope) {
        // In Kotlin, graphical functions such as `stroke`, `noFill`,
        // and `circle` would typically be handled in a graphical framework context.
        // Assuming a function
        // `drawCircle(centerX: Double, centerY: Double, diameter: Double)` exists:
        // drawCircle(center.a, center.b, radius * 2)
        d.drawCircle(
            color =  Color.White,
            center = Offset(center.a.toFloat(), center.b.toFloat()), // Центр Canvas
            radius = radius.toFloat(), // Радиус круга
            style = Stroke(width = 1f) // Стиль: линия (обводка) толщиной 5
        )
    }

    // Computes the distance between this circle and another circle
    fun dist(other: Circle): Double {
        // Assuming a function `calculateDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double` exists:
        //return dist(
//            this.center.a, this.center.b, other.center.a, other.center.b
//        )
        return 10.0
    }
}
