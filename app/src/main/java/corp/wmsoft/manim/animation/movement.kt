package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations related to movement."""


open class Homotopy(mobject: Mobject) : Animation(mobject)
//    """A Homotopy.
//
//    This is an animation transforming the points of a mobject according
//    to the specified transformation function. With the parameter :math:`t`
//    moving from 0 to 1 throughout the animation and :math:`(x, y, z)`
//    describing the coordinates of the point of a mobject,
//    the function passed to the ``homotopy`` keyword argument should
//    transform the tuple :math:`(x, y, z, t)` to :math:`(x', y', z')`,
//    the coordinates the original point is transformed to at time :math:`t`.
//
//    Parameters
//    ----------
//    homotopy
//        A function mapping :math:`(x, y, z, t)` to :math:`(x', y', z')`.
//    mobject
//        The mobject transformed under the given homotopy.
//    run_time
//        The run time of the animation.
//    apply_function_kwargs
//        Keyword arguments propagated to :meth:`.Mobject.apply_function`.
//    kwargs
//        Further keyword arguments passed to the parent open class.
//    """


open class SmoothedVectorizedHomotopy(mobject: Mobject) : Homotopy(mobject)


open class ComplexHomotopy(mobject: Mobject) : Homotopy(mobject)
//    def __init__(
//        self, complex_homotopy: Callable[[complex], float], mobject: Mobject, **kwargs
//    ) -> None:
//        """
//        Complex Homotopy a function Cx[0, 1] to C
//        """


open class PhaseFlow(mobject: Mobject) : Animation(mobject)


open class MoveAlongPath(mobject: Mobject) : Animation(mobject)
//    """Make one mobject move along the path of another mobject.
//
//    .. manim:: MoveAlongPathExample
//
//        open class MoveAlongPathExample(Scene):
//            def construct(self):
//                d1 = Dot().set_color(ORANGE)
//                l1 = Line(LEFT, RIGHT)
//                l2 = VMobject()
//                self.add(d1, l1, l2)
//                l2.add_updater(lambda x: x.become(Line(LEFT, d1.get_center()).set_color(ORANGE)))
//                self.play(MoveAlongPath(d1, l1), rate_func=linear)
//    """

