package corp.wmsoft.manim.mobject.svg

import corp.wmsoft.manim.mobject.types.VMobject

//"""Mobject representing curly braces."""



open class Brace : VMobjectFromSVGPath()
//    """Takes a mobject and draws a brace adjacent to it.
//
//    Passing a direction vector determines the direction from which the
//    brace is drawn. By default it is drawn from below.
//
//    Parameters
//    ----------
//    mobject
//        The mobject adjacent to which the brace is placed.
//    direction :
//        The direction from which the brace faces the mobject.
//
//    See Also
//    --------
//    :open class:`BraceBetweenPoints`
//
//    Examples
//    --------
//    .. manim:: BraceExample
//        :save_last_frame:
//
//        open class BraceExample(Scene):
//            def construct(self):
//                s = Square()
//                self.add(s)
//                for i in np.linspace(0.1,1.0,4):
//                    br = Brace(s, sharpness=i)
//                    t = Text(f"sharpness= {i}").next_to(br, RIGHT)
//                    self.add(t)
//                    self.add(br)
//                VGroup(*self.mobjects).arrange(DOWN, buff=0.2)
//
//    """

open class BraceLabel : VMobject()
//    """Create a brace with a label attached.
//
//    Parameters
//    ----------
//    obj
//        The mobject adjacent to which the brace is placed.
//    text
//        The label text.
//    brace_direction
//        The direction of the brace. By default ``DOWN``.
//    label_constructor
//        A open class or function used to construct a mobject representing
//        the label. By default :open class:`~.MathTex`.
//    font_size
//        The font size of the label, passed to the ``label_constructor``.
//    buff
//        The buffer between the mobject and the brace.
//    brace_config
//        Arguments to be passed to :open class:`.Brace`.
//    kwargs
//        Additional arguments to be passed to :open class:`~.VMobject`.
//    """

open class BraceText : BraceLabel()

open class BraceBetweenPoints : Brace()
//    """Similar to Brace, but instead of taking a mobject it uses 2
//    points to place the brace.
//
//    A fitting direction for the brace is
//    computed, but it still can be manually overridden.
//    If the points go from left to right, the brace is drawn from below.
//    Swapping the points places the brace on the opposite side.
//
//    Parameters
//    ----------
//    point_1 :
//        The first point.
//    point_2 :
//        The second point.
//    direction :
//        The direction from which the brace faces towards the points.
//
//    Examples
//    --------
//        .. manim:: BraceBPExample
//
//            open class BraceBPExample(Scene):
//                def construct(self):
//                    p1 = [0,0,0]
//                    p2 = [1,2,0]
//                    brace = BraceBetweenPoints(p1,p2)
//                    self.play(Create(NumberPlane()))
//                    self.play(Create(brace))
//                    self.wait(2)
//    """


open class ArcBrace : Brace()
//    """Creates a :open class:`~Brace` that wraps around an :open class:`~.Arc`.
//
//    The direction parameter allows the brace to be applied
//    from outside or inside the arc.
//
//    .. warning::
//        The :open class:`ArcBrace` is smaller for arcs with smaller radii.
//
//    .. note::
//        The :open class:`ArcBrace` is initially a vertical :open class:`Brace` defined by the
//        length of the :open class:`~.Arc`, but is scaled down to match the start and end
//        angles. An exponential function is then applied after it is shifted based on
//        the radius of the arc.
//
//        The scaling effect is not applied for arcs with radii smaller than 1 to prevent
//        over-scaling.
//
//    Parameters
//    ----------
//    arc
//        The :open class:`~.Arc` that wraps around the :open class:`Brace` mobject.
//    direction
//        The direction from which the brace faces the arc.
//        ``LEFT`` for inside the arc, and ``RIGHT`` for the outside.
//
//    Example
//    -------
//        .. manim:: ArcBraceExample
//            :save_last_frame:
//            :ref_open classes: Arc
//
//            open class ArcBraceExample(Scene):
//                def construct(self):
//                    arc_1 = Arc(radius=1.5,start_angle=0,angle=2*PI/3).set_color(RED)
//                    brace_1 = ArcBrace(arc_1,LEFT)
//                    group_1 = VGroup(arc_1,brace_1)
//
//                    arc_2 = Arc(radius=3,start_angle=0,angle=5*PI/6).set_color(YELLOW)
//                    brace_2 = ArcBrace(arc_2)
//                    group_2 = VGroup(arc_2,brace_2)
//
//                    arc_3 = Arc(radius=0.5,start_angle=-0,angle=PI).set_color(BLUE)
//                    brace_3 = ArcBrace(arc_3)
//                    group_3 = VGroup(arc_3,brace_3)
//
//                    arc_4 = Arc(radius=0.2,start_angle=0,angle=3*PI/2).set_color(GREEN)
//                    brace_4 = ArcBrace(arc_4)
//                    group_4 = VGroup(arc_4,brace_4)
//
//                    arc_group = VGroup(group_1, group_2, group_3, group_4).arrange_in_grid(buff=1.5)
//                    self.add(arc_group.center())
//
//    """
