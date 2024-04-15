package corp.wmsoft.drawcompose.example

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import kotlin.math.pow
import kotlin.math.sqrt

// Расширение Для определения нахождения точки внутри произвольного прямоугольника, заданного через
// верхний левый угол (Offset) и размер (Size)
fun Offset.isInsideRectangle(
    rectangleTopLeft: Offset,
    rectangleSize: Size
):Boolean =
    this.x >= rectangleTopLeft.x &&
            this.x <= rectangleTopLeft.x + rectangleSize.width &&
            this.y >= rectangleTopLeft.y &&
            this.y <= rectangleTopLeft.y + rectangleSize.height

// Расширение для вычисления расстояния между двумя точками
fun Offset.distanceTo(other: Offset): Float =
    sqrt((this.x - other.x).pow(2) + (this.y - other.y).pow(2)).toFloat()
