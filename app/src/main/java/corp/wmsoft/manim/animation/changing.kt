package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.types.VGroup
import corp.wmsoft.manim.mobject.types.VMobject

//"""Animation of a mobject boundary and tracing of points."""


open class AnimatedBoundary : VGroup()
//    """Boundary of a :class:`.VMobject` with animated color change.
//
//    Examples
//    --------
//    .. manim:: AnimatedBoundaryExample
//
//        class AnimatedBoundaryExample(Scene):
//            def construct(self):
//                text = Text("So shiny!")
//                boundary = AnimatedBoundary(text, colors=[RED, GREEN, BLUE],
//                                            cycle_rate=3)
//                self.add(text, boundary)
//                self.wait(2)
//
//    """


open class TracedPath : VMobject()
//    """Traces the path of a point returned by a function call.
//
//    Parameters
//    ----------
//    traced_point_func
//        The function to be traced.
//    stroke_width
//        The width of the trace.
//    stroke_color
//        The color of the trace.
//    dissipating_time
//        The time taken for the path to dissipate. Default set to ``None``
//        which disables dissipation.
//
//    Examples
//    --------
//    .. manim:: TracedPathExample
//
//        class TracedPathExample(Scene):
//            def construct(self):
//                circ = Circle(color=RED).shift(4*LEFT)
//                dot = Dot(color=RED).move_to(circ.get_start())
//                rolling_circle = VGroup(circ, dot)
//                trace = TracedPath(circ.get_start)
//                rolling_circle.add_updater(lambda m: m.rotate(-0.3))
//                self.add(trace, rolling_circle)
//                self.play(rolling_circle.animate.shift(8*RIGHT), run_time=4, rate_func=linear)
//
//    .. manim:: DissipatingPathExample
//
//        class DissipatingPathExample(Scene):
//            def construct(self):
//                a = Dot(RIGHT * 2)
//                b = TracedPath(a.get_center, dissipating_time=0.5, stroke_opacity=[0, 1])
//                self.add(a, b)
//                self.play(a.animate(path_arc=PI / 4).shift(LEFT * 2))
//                self.play(a.animate(path_arc=-PI / 4).shift(LEFT * 2))
//                self.wait()
//
//    """

