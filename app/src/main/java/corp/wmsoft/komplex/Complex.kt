package corp.wmsoft.komplex

import kotlin.math.*

fun isEven(i: Int) = i % 2 == 0


/**
 * Complex unit = 0 + i
 */
val i = Complex(0.0, 1.0)

/**
 * Complex norm
 */
fun abs(c: Complex): Double = c.abs()

/**
 * Complex exponential
 */
fun exp(c: Complex): Complex {
    val e = exp(c.real)
    return Complex(e * cos(c.img), e * sin(c.img))
}

/**
 * Hyperbolic sine
 */
fun sinh(c: Complex) = (exp(c) - exp(-c)) / 2

/**
 * Hyperbolic cosine
 */
fun cosh(c: Complex) = (exp(c) + exp(-c)) / 2

/**
 * Hyperbolic tangent
 */
fun tanh(c: Complex) = sinh(c) / cosh(c)

/**
 * Hyperbolic cotangent
 */
fun coth(c: Complex) = cosh(c) / sinh(c)

/**
 * Complex cosine
 */
fun cos(c: Complex) = (exp(i * c) + exp(-i * c)) / 2.0

/**
 * Complex sine
 */
fun sin(c: Complex) = i * (exp(-i * c) - exp(i * c)) / 2.0

/**
 * Complex tangent
 */
fun tan(c: Complex) = sin(c) / cos(c)

/**
 * Complex cotangent
 */
fun cot(c: Complex) = cos(c) / sin(c)

/**
 * Complex secant
 */
fun sec(c: Complex) = Complex.ONE / cos(c)

/**
 * The natural logarithm on the principal branch
 */
fun ln(c: Complex) = Complex(ln(c.abs()), c.phase())

/**
 * Roots of unity
 */
fun roots(n: Int) =
    (1 ..n).map { exp(i *2*PI*it/n) }

operator fun Number.plus(c: Complex) = Complex(this.toDouble() + c.real, c.img)

operator fun Number.minus(c: Complex) = Complex(this.toDouble() - c.real, -c.img)

operator fun Number.times(c: Complex) = Complex(this.toDouble() * c.real, this.toDouble() * c.img)

operator fun Number.div(c: Complex) = Complex.ONE / c

/**
 * Defines complex numbers and their algebraic operations
 * @param real the real component
 * @param img the imaginary component
 */
class Complex(val real: Double, val img: Double) {

    constructor(real: Number, img: Number) : this(real.toDouble(), img.toDouble())

    override fun equals(other: Any?): Boolean {
        return (other is Complex && real == other.real && img == other.img)
    }

    override fun hashCode(): Int {
        return real.hashCode() * 31 + img.hashCode()
    }

    operator fun unaryMinus() = Complex(-real, -img)

    operator fun plus(c: Complex) = Complex(real + c.real, img + c.img)

    operator fun plus(n: Number) = Complex(real + n.toDouble(), img)

    operator fun minus(c: Complex) = Complex(real - c.real, img - c.img)

    operator fun minus(n: Number) = Complex(real - n.toDouble(), img)

    operator fun times(c: Complex) = Complex(real * c.real - img * c.img, real * c.img + img * c.real)

    operator fun times(n: Number) = Complex(n.toDouble() * real, n.toDouble() * img)

    operator fun div(n: Number) = Complex(real / n.toDouble(), img / n.toDouble())

    operator fun div(c: Complex): Complex {
        val den = c.normSquared()
        if (isPracticallyZero(den)) {
            return this / 0 //TO make this consistent with division by zero number
        }
        val num = this * c.conjugate()
        return num / den
    }

    operator fun component1() = real
    operator fun component2() = img

    /**
     * Complex conjugate = x-y*i
     */
    fun conjugate() = Complex(real, -img)

    fun normSquared() = real * real + img * img

    fun abs(): Double = sqrt(this.normSquared())

    fun phase(): Double = atan(img / real)

    fun pow(a: Double) = exp(ln(this) * a)

    fun pow(a: Number) = exp(ln(this) * a)

    fun pow(a: Complex) = exp(ln(this) * a)

    override fun toString(): String {
        return when {
            isPracticallyZero(img) -> "$real"
            isPracticallyZero(real) -> "${img}i"
            img < 0 -> "$real-${-img}i"
            else -> "${real}+${img}i"
        }
    }

    private fun isPracticallyZero(d: Double) = abs(d) < DEFAULT_TOLERANCE

    companion object {
        /**
         * Complex 0 = 0 + 0i
         */
        val ZERO = Complex(0.0, 0.0)
        /**
         * Complex 1 = 1 + 0i
         */
        val ONE = Complex(1.0, 0.0)

        /** "Not a number" represents a essential singularity */
        val NaN = Complex(Double.NaN, Double.NaN)

        /** Infinity represents the north pole of the complex sphere. */
        val INF = Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)

        const val DEFAULT_TOLERANCE = 1.0E-15

        fun fromNumber(n: Number) = Complex(n.toDouble(), 0.0)

        fun fromPolar(radius: Double, theta: Double) : Complex =radius* exp(i *theta)

    }

    /**
     * Tests if the norm of the complex number is smaller than the given tolerance
     */
    fun isZero(tolerance: Double) = this.abs() < tolerance

    infix fun to(exponent: Int): Complex {
        if (exponent == 0) {
            return ONE
        }
        if (exponent == 1) {
            return this
        }
        val half = to(exponent / 2)
        return if (isEven(exponent)) {
            half * half
        } else {
            half * half * this
        }
    }

    infix fun to(exponent: Complex) = this.pow(exponent)

    infix fun to(exponent: Number) = this.pow(exponent)

    // Hint: Usually it is not necessary to override the (calculated) properties
    // arg and mod with a lazy and caching-like kind. Using Kotlin's "lazy" increases
    // the execution time by a factor of 6. So the properties would have to be read
    // at least six times before caching would pay off, which is quite unlikely.

    /** The argument of this complex number (angle of the polar coordinate representation) */
    val arg: Double
        get() {
            return when {
                isInfinite() -> Double.NaN
                isNaN() -> Double.NaN
                real > 0.0 -> atan(img / real)
                real < 0.0 && img >= 0.0 -> atan(img / real) + PI
                real < 0.0 && img < 0.0 -> atan(img / real) - PI
                real == 0.0 && img > 0.0 -> PI / 2
                real == 0.0 && img < 0.0 -> -PI / 2
                else -> 0.0
            }
        }

    /**
     *  checks infinity property (remark that in case of complex numbers there is only one unsigned infinity)
     *  @return true if this is infinite
     */
    fun isInfinite() = this === INF

    /**
     * checks the "not a number" property (NaN represents an essential singularity)
     * @return true if this is NaN
     */
    fun isNaN() = this === NaN
}
