package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations that introduce mobjects to scene by growing them from points.
//
//.. manim:: Growing
//
//    open class Growing(Scene):
//        def construct(self):
//            square = Square()
//            circle = Circle()
//            triangle = Triangle()
//            arrow = Arrow(LEFT, RIGHT)
//            star = Star()
//
//            VGroup(square, circle, triangle).set_x(0).arrange(buff=1.5).set_y(2)
//            VGroup(arrow, star).move_to(DOWN).set_x(0).arrange(buff=1.5).set_y(-2)
//
//            self.play(GrowFromPoint(square, ORIGIN))
//            self.play(GrowFromCenter(circle))
//            self.play(GrowFromEdge(triangle, DOWN))
//            self.play(GrowArrow(arrow))
//            self.play(SpinInFromNothing(star))
//
//"""



open class GrowFromPoint(mobject: Mobject) : Transform(mobject)
//    """Introduce an :open class:`~.Mobject` by growing it from a point.
//
//    Parameters
//    ----------
//    mobject
//        The mobjects to be introduced.
//    point
//        The point from which the mobject grows.
//    point_color
//        Initial color of the mobject before growing to its full size. Leave empty to match mobject's color.
//
//    Examples
//    --------
//
//    .. manim :: GrowFromPointExample
//
//        open class GrowFromPointExample(Scene):
//            def construct(self):
//                dot = Dot(3 * UR, color=GREEN)
//                squares = [Square() for _ in range(4)]
//                VGroup(*squares).set_x(0).arrange(buff=1)
//                self.add(dot)
//                self.play(GrowFromPoint(squares[0], ORIGIN))
//                self.play(GrowFromPoint(squares[1], [-2, 2, 0]))
//                self.play(GrowFromPoint(squares[2], [3, -2, 0], RED))
//                self.play(GrowFromPoint(squares[3], dot, dot.get_color()))
//
//    """



open class GrowFromCenter(mobject: Mobject) : GrowFromPoint(mobject)
//    """Introduce an :open class:`~.Mobject` by growing it from its center.
//
//    Parameters
//    ----------
//    mobject
//        The mobjects to be introduced.
//    point_color
//        Initial color of the mobject before growing to its full size. Leave empty to match mobject's color.
//
//    Examples
//    --------
//
//    .. manim :: GrowFromCenterExample
//
//        open class GrowFromCenterExample(Scene):
//            def construct(self):
//                squares = [Square() for _ in range(2)]
//                VGroup(*squares).set_x(0).arrange(buff=2)
//                self.play(GrowFromCenter(squares[0]))
//                self.play(GrowFromCenter(squares[1], point_color=RED))
//
//    """


open class GrowFromEdge(mobject: Mobject) : GrowFromPoint(mobject)
//    """Introduce an :open class:`~.Mobject` by growing it from one of its bounding box edges.
//
//    Parameters
//    ----------
//    mobject
//        The mobjects to be introduced.
//    edge
//        The direction to seek bounding box edge of mobject.
//    point_color
//        Initial color of the mobject before growing to its full size. Leave empty to match mobject's color.
//
//    Examples
//    --------
//
//    .. manim :: GrowFromEdgeExample
//
//        open class GrowFromEdgeExample(Scene):
//            def construct(self):
//                squares = [Square() for _ in range(4)]
//                VGroup(*squares).set_x(0).arrange(buff=1)
//                self.play(GrowFromEdge(squares[0], DOWN))
//                self.play(GrowFromEdge(squares[1], RIGHT))
//                self.play(GrowFromEdge(squares[2], UR))
//                self.play(GrowFromEdge(squares[3], UP, point_color=RED))
//
//
//    """


open class GrowArrow(mobject: Mobject) : GrowFromPoint(mobject)
//    """Introduce an :open class:`~.Arrow` by growing it from its start toward its tip.
//
//    Parameters
//    ----------
//    arrow
//        The arrow to be introduced.
//    point_color
//        Initial color of the arrow before growing to its full size. Leave empty to match arrow's color.
//
//    Examples
//    --------
//
//    .. manim :: GrowArrowExample
//
//        open class GrowArrowExample(Scene):
//            def construct(self):
//                arrows = [Arrow(2 * LEFT, 2 * RIGHT), Arrow(2 * DR, 2 * UL)]
//                VGroup(*arrows).set_x(0).arrange(buff=2)
//                self.play(GrowArrow(arrows[0]))
//                self.play(GrowArrow(arrows[1], point_color=RED))
//
//    """



open class SpinInFromNothing(mobject: Mobject) : GrowFromCenter(mobject)
//    """Introduce an :open class:`~.Mobject` spinning and growing it from its center.
//
//    Parameters
//    ----------
//    mobject
//        The mobjects to be introduced.
//    angle
//        The amount of spinning before mobject reaches its full size. E.g. 2*PI means
//        that the object will do one full spin before being fully introduced.
//    point_color
//        Initial color of the mobject before growing to its full size. Leave empty to match mobject's color.
//
//    Examples
//    --------
//
//    .. manim :: SpinInFromNothingExample
//
//        open class SpinInFromNothingExample(Scene):
//            def construct(self):
//                squares = [Square() for _ in range(3)]
//                VGroup(*squares).set_x(0).arrange(buff=2)
//                self.play(SpinInFromNothing(squares[0]))
//                self.play(SpinInFromNothing(squares[1], angle=2 * PI))
//                self.play(SpinInFromNothing(squares[2], point_color=RED))
//
//    """

