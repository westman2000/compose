// Base classes for objects that can be displayed.
package corp.wmsoft.drawcompose.mobject

import android.util.SparseArray
import androidx.compose.ui.graphics.Color


interface MathElement {
    /**
     * Create and return an identical copy
     *
     * @return [MathElement] The copy.
     */
    fun copy() : MathElement
}

@DslMarker
annotation class MathObjectMarker


/**
 * Mathematical Object: base class for objects that can be displayed on screen.
 */
abstract class MathObject(
    val color: Color = Color.White,
    val name: String = "",
    val dim: Int = 3,
    val zIndex: Float = 0.0f,
) : MathElement {

    private val children = SparseArray<MathObject>()
//    val children = arrayListOf<MathElement>()

    /**
     * Add mobjects as submobjects.
     *
     * The mobjects are added to :attr:`submobjects`.
     * Subclasses of mobject may implement ``+`` and ``+=`` dunder methods.
     *
     * @param obj The object to add.
     *
     * @return [MathObject]
     *
     *  @throws [IllegalArgumentException] When a [MathObject] tries to add itself.
     *
     */
    fun add(obj : MathObject) : MathObject {

        if (obj == this) {
            throw IllegalArgumentException("MObject cannot contain self")
        }

        children.append(obj.hashCode(), obj)
        return this
    }
    operator fun plus(obj: MathObject) = add(obj)
}

abstract class Group : MathObject()

/**
"""A vectorized mobject.

Parameters
----------
background_stroke_color
The purpose of background stroke is to have something
that won't overlap fill, e.g.  For text against some
textured background.
sheen_factor
When a color c is set, there will be a second color
computed based on interpolating c to WHITE by with
sheen_factor, and the display will gradient to this
secondary color in the direction of sheen_direction.
close_new_points
Indicates that it will not be displayed, but
that it should count in parent mobject's path
tolerance_for_point_equality
This is within a pixel
joint_type
The line joint type used to connect the curve segments
of this vectorized mobject. See :class:`.LineJointType`
for options.
"""
 */
abstract class VectorizedMathObject : MathObject()
abstract class VectorizedGroup : VectorizedMathObject()
abstract class VectorizedDict : VectorizedMathObject()
abstract class VectorizedPoint : VectorizedMathObject()

//fun mob(init: MathObject.() -> Unit): MathObject {
//    val mob = MathObject()
//    mob.init()
//    return mob
//}
