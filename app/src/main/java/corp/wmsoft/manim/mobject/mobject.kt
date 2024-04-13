package corp.wmsoft.manim.mobject

import android.util.SparseArray
import androidx.compose.ui.graphics.Color
import corp.wmsoft.drawcompose.mobject.MathObject

//"""Base classes for objects that can be displayed."""

interface MathAsset

/**
    """Mathematical Object: base class for objects that can be displayed on screen.

    There is a compatibility layer that allows for
    getting and setting generic attributes with ``get_*``
    and ``set_*`` methods. See :meth:`set` for more details.

    Attributes
    ----------
    submobjects : List[:class:`Mobject`]
    The contained objects.
    points : :class:`numpy.ndarray`
    The points of the objects.

    .. seealso::

    :class:`~.VMobject`

    """
 */
abstract class Mobject(
    val color: Color = Color.White,
    val name: String = "",
    val dim: Int = 3,
    val zIndex: Float = 0.0f,
) : MathAsset {
    private val children = SparseArray<Mobject>()
//    val children = arrayListOf<MathElement>()

    /**
     * Add mobjects as submobjects.
     *
     * The mobjects are added to :attr:`submobjects`.
     * Subclasses of mobject may implement ``+`` and ``+=`` dunder methods.
     *
     * @param obj The object to add.
     *
     * @return [Mobject]
     *
     *  @throws [IllegalArgumentException] When a [Mobject] tries to add itself.
     *
     */
    fun add(obj : Mobject) {

        if (obj == this) {
            throw IllegalArgumentException("MObject cannot contain self")
        }

        children.append(obj.hashCode(), obj)
    }

    operator fun plus(obj: Mobject) = add(obj)
}

/**
    # """Groups together multiple :class:`Mobjects <.Mobject>`.
    #
    # Notes
    # -----
    # When adding the same mobject more than once, repetitions are ignored.
    # Use :meth:`.Mobject.copy` to create a separate copy which can then
    # be added to the group.
    # """
 */
open class Group : Mobject()
