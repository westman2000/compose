package corp.wmsoft.apolo

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.atan2

// Defines a complex number and its operations
class Complex(val a: Double, val b: Double) {  // Constructor to create a complex number with real (a) and imaginary (b) parts

    // Adds this complex number with another
    fun add(other: Complex): Complex {
        return Complex(this.a + other.a, this.b + other.b)
    }

    // Subtracts another complex number from this one
    fun sub(other: Complex): Complex {
        return Complex(this.a - other.a, this.b - other.b)
    }

    // Scales this complex number by a real number value
    fun scale(value: Double): Complex {
        return Complex(this.a * value, this.b * value)
    }

    // Multiplies this complex number with another, using the formula (ac-bd) + (ad+bc)i
    fun mult(other: Complex): Complex {
        val a = this.a * other.a - this.b * other.b
        val b = this.a * other.b + other.a * this.b
        return Complex(a, b)
    }

    // Calculates the square root of this complex number
    fun sqrt(): Complex {
        // Convert to polar form
        val m = sqrt(this.a * this.a + this.b * this.b)
        val angle = atan2(this.b, this.a)
        // Calculate square root of magnitude and use half the angle for square root
        val magnitude = sqrt(m)
        val halfAngle = angle / 2
        // Back to rectangular form
        return Complex(magnitude * cos(halfAngle), magnitude * sin(halfAngle))
    }
}