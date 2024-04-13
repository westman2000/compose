package corp.wmsoft.manim.mobject.geometry

import corp.wmsoft.manim.mobject.types.VMobject

//r"""A collection of tip mobjects for use with :class:`~.TipableVMobject`."""

open class ArrowTip : VMobject()
//    r"""Base class for arrow tips.
//
//    .. seealso::
//        :class:`ArrowTriangleTip`
//        :class:`ArrowTriangleFilledTip`
//        :class:`ArrowCircleTip`
//        :class:`ArrowCircleFilledTip`
//        :class:`ArrowSquareTip`
//        :class:`ArrowSquareFilledTip`
//        :class:`StealthTip`
//
//    Examples
//    --------
//    Cannot be used directly, only intended for inheritance::
//
//        >>> tip = ArrowTip()
//        Traceback (most recent call last):
//        ...
//        NotImplementedError: Has to be implemented in inheriting subclasses.
//
//    Instead, use one of the pre-defined ones, or make
//    a custom one like this:
//
//    .. manim:: CustomTipExample
//
//        >>> from manim import RegularPolygon, Arrow
//        >>> class MyCustomArrowTip(ArrowTip, RegularPolygon):
//        ...     def __init__(self, length=0.35, **kwargs):
//        ...         RegularPolygon.__init__(self, n=5, **kwargs)
//        ...         self.width = length
//        ...         self.stretch_to_fit_height(length)
//        >>> arr = Arrow(np.array([-2, -2, 0]), np.array([2, 2, 0]),
//        ...             tip_shape=MyCustomArrowTip)
//        >>> isinstance(arr.tip, RegularPolygon)
//        True
//        >>> from manim import Scene, Create
//        >>> class CustomTipExample(Scene):
//        ...     def construct(self):
//        ...         self.play(Create(arr))
//
//    Using a class inherited from :class:`ArrowTip` to get a non-filled
//    tip is a shorthand to manually specifying the arrow tip style as follows::
//
//        >>> arrow = Arrow(np.array([0, 0, 0]), np.array([1, 1, 0]),
//        ...               tip_style={'fill_opacity': 0, 'stroke_width': 3})
//
//    The following example illustrates the usage of all of the predefined
//    arrow tips.
//
//    .. manim:: ArrowTipsShowcase
//        :save_last_frame:
//
//        class ArrowTipsShowcase(Scene):
//            def construct(self):
//                tip_names = [
//                    'Default (YELLOW)', 'ArrowTriangleTip', 'Default', 'ArrowSquareTip',
//                    'ArrowSquareFilledTip', 'ArrowCircleTip', 'ArrowCircleFilledTip', 'StealthTip'
//                ]
//
//                big_arrows = [
//                    Arrow(start=[-4, 3.5, 0], end=[2, 3.5, 0], color=YELLOW),
//                    Arrow(start=[-4, 2.5, 0], end=[2, 2.5, 0], tip_shape=ArrowTriangleTip),
//                    Arrow(start=[-4, 1.5, 0], end=[2, 1.5, 0]),
//                    Arrow(start=[-4, 0.5, 0], end=[2, 0.5, 0], tip_shape=ArrowSquareTip),
//
//                    Arrow([-4, -0.5, 0], [2, -0.5, 0], tip_shape=ArrowSquareFilledTip),
//                    Arrow([-4, -1.5, 0], [2, -1.5, 0], tip_shape=ArrowCircleTip),
//                    Arrow([-4, -2.5, 0], [2, -2.5, 0], tip_shape=ArrowCircleFilledTip),
//                    Arrow([-4, -3.5, 0], [2, -3.5, 0], tip_shape=StealthTip)
//                ]
//
//                small_arrows = (
//                    arrow.copy().scale(0.5, scale_tips=True).next_to(arrow, RIGHT) for arrow in big_arrows
//                )
//
//                labels = (
//                    Text(tip_names[i], font='monospace', font_size=20, color=BLUE).next_to(big_arrows[i], LEFT) for i in range(len(big_arrows))
//                )
//
//                self.add(*big_arrows, *small_arrows, *labels)
//    """

open class StealthTip : ArrowTip()
//    r"""'Stealth' fighter / kite arrow shape.
//
//    Naming is inspired by the corresponding
//    `TikZ arrow shape <https://tikz.dev/tikz-arrows#sec-16.3>`__.
//    """

open class ArrowTriangleTip : ArrowTip()
//    r"""Triangular arrow tip."""


class ArrowTriangleFilledTip : ArrowTriangleTip()
//    r"""Triangular arrow tip with filled tip.
//
//    This is the default arrow tip shape.
//    """


open class ArrowCircleTip : ArrowTip()
//    r"""Circular arrow tip."""


class ArrowCircleFilledTip : ArrowCircleTip()
//    r"""Circular arrow tip with filled tip."""


open class ArrowSquareTip : ArrowTip()
//    r"""Square arrow tip."""


class ArrowSquareFilledTip : ArrowSquareTip()
//    r"""Square arrow tip with filled tip."""
