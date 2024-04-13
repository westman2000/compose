package corp.wmsoft.manim.mobject.geometry

import androidx.compose.ui.graphics.Color
import corp.wmsoft.manim.mobject.Mobject
import corp.wmsoft.manim.mobject.types.VMobject

//r"""Mobjects that are curved.

//Examples
//--------
//.. manim:: UsefulAnnotations
//    :save_last_frame:
//
//    class UsefulAnnotations(Scene):
//        def construct(self):
//            m0 = Dot()
//            m1 = AnnotationDot()
//            m2 = LabeledDot("ii")
//            m3 = LabeledDot(MathTex(r"\alpha").set_color(ORANGE))
//            m4 = CurvedArrow(2*LEFT, 2*RIGHT, radius= -5)
//            m5 = CurvedArrow(2*LEFT, 2*RIGHT, radius= 8)
//            m6 = CurvedDoubleArrow(ORIGIN, 2*RIGHT)
//
//            self.add(m0, m1, m2, m3, m4, m5, m6)
//            for i, mobj in enumerate(self.mobjects):
//                mobj.shift(DOWN * (i-3))
//
//"""

open class TipableVMobject : VMobject()
//    """Meant for shared functionality between Arc and Line.
//    Functionality can be classified broadly into these groups:
//
//        * Adding, Creating, Modifying tips
//            - add_tip calls create_tip, before pushing the new tip
//                into the TipableVMobject's list of submobjects
//            - stylistic and positional configuration
//
//        * Checking for tips
//            - Boolean checks for whether the TipableVMobject has a tip
//                and a starting tip
//
//        * Getters
//            - Straightforward accessors, returning information pertaining
//                to the TipableVMobject instance's tip(s), its length etc
//    """

/**
 * """A circular arc.
 *
 *     Examples
 *     --------
 *     A simple arc of angle Pi.
 *
 *     .. manim:: ArcExample
 *         :save_last_frame:
 *
 *         class ArcExample(Scene):
 *             def construct(self):
 *                 self.add(Arc(angle=PI))
 *     """
 */
open class Arc(
    radius: Float = 1.0f,
    start_angle: Float = 0f,
    angle: Float = Math.PI.toFloat() / 2f,
    num_components: Int = 9,
    arc_center: Float = 0f,
) : TipableVMobject() {

}


open class ArcBetweenPoints : Arc()
//    """Inherits from Arc and additionally takes 2 points between which the arc is spanned.
//
//    Example
//    -------
//    .. manim:: ArcBetweenPointsExample
//
//      class ArcBetweenPointsExample(Scene):
//          def construct(self):
//              circle = Circle(radius=2, stroke_color=GREY)
//              dot_1 = Dot(color=GREEN).move_to([2, 0, 0]).scale(0.5)
//              dot_1_text = Tex("(2,0)").scale(0.5).next_to(dot_1, RIGHT).set_color(BLUE)
//              dot_2 = Dot(color=GREEN).move_to([0, 2, 0]).scale(0.5)
//              dot_2_text = Tex("(0,2)").scale(0.5).next_to(dot_2, UP).set_color(BLUE)
//              arc= ArcBetweenPoints(start=2 * RIGHT, end=2 * UP, stroke_color=YELLOW)
//              self.add(circle, dot_1, dot_2, dot_1_text, dot_2_text)
//              self.play(Create(arc))
//    """

open class CurvedArrow : ArcBetweenPoints()


open class CurvedDoubleArrow : CurvedArrow()


/**
    """A circle.

    Parameters
    ----------
    color
    The color of the shape.
    kwargs
    Additional arguments to be passed to :class:`Arc`

    Examples
    --------
    .. manim:: CircleExample
    :save_last_frame:

    class CircleExample(Scene):
    def construct(self):
    circle_1 = Circle(radius=1.0)
    circle_2 = Circle(radius=1.5, color=GREEN)
    circle_3 = Circle(radius=1.0, color=BLUE_B, fill_opacity=1)

    circle_group = Group(circle_1, circle_2, circle_3).arrange(buff=1)
    self.add(circle_group)
    """
 */
open class Circle(
    val radius : Float = 0f,
    color: Color = Color.White
) : Arc() {


    /**
     *     """Modifies a circle so that it surrounds a given mobject.
     *
     *         Parameters
     *         ----------
     *         mobject
     *             The mobject that the circle will be surrounding.
     *         dim_to_match
     *         buffer_factor
     *             Scales the circle with respect to the mobject. A `buffer_factor` < 1 makes the circle smaller than the mobject.
     *         stretch
     *             Stretches the circle to fit more tightly around the mobject. Note: Does not work with :class:`Line`
     *
     *         Examples
     *         --------
     *         .. manim:: CircleSurround
     *             :save_last_frame:
     *
     *             class CircleSurround(Scene):
     *                 def construct(self):
     *                     triangle1 = Triangle()
     *                     circle1 = Circle().surround(triangle1)
     *                     group1 = Group(triangle1,circle1) # treat the two mobjects as one
     *
     *                     line2 = Line()
     *                     circle2 = Circle().surround(line2, buffer_factor=2.0)
     *                     group2 = Group(line2,circle2)
     *
     *                     # buffer_factor < 1, so the circle is smaller than the square
     *                     square3 = Square()
     *                     circle3 = Circle().surround(square3, buffer_factor=0.5)
     *                     group3 = Group(square3, circle3)
     *
     *                     group = Group(group1, group2, group3).arrange(buff=1)
     *                     self.add(group)
     *         """
     */
    fun surround(
        mobject: Mobject,
        dim_to_match: Int = 0,
        stretch: Boolean = false,
        buffer_factor: Float = 1.2f,
    ) : Circle {
        return this
    }


    /**
     * """Returns the position of a point on the circle.
     *
     *         Parameters
     *         ----------
     *         angle
     *             The angle of the point along the circle in radians.
     *
     *         Returns
     *         -------
     *         :class:`numpy.ndarray`
     *             The location of the point along the circle's circumference.
     *
     *         Examples
     *         --------
     *         .. manim:: PointAtAngleExample
     *             :save_last_frame:
     *
     *             class PointAtAngleExample(Scene):
     *                 def construct(self):
     *                     circle = Circle(radius=2.0)
     *                     p1 = circle.point_at_angle(PI/2)
     *                     p2 = circle.point_at_angle(270*DEGREES)
     *
     *                     s1 = Square(side_length=0.25).move_to(p1)
     *                     s2 = Square(side_length=0.25).move_to(p2)
     *                     self.add(circle, s1, s2)
     *
     *         """
     */
//    fun point_at_angle(angle: Float) : Point3D:


    /**
     * """Returns a circle passing through the specified
     *         three points.
     *
     *         Example
     *         -------
     *         .. manim:: CircleFromPointsExample
     *             :save_last_frame:
     *
     *             class CircleFromPointsExample(Scene):
     *                 def construct(self):
     *                     circle = Circle.from_three_points(LEFT, LEFT + UP, UP * 2, color=RED)
     *                     dots = VGroup(
     *                         Dot(LEFT),
     *                         Dot(LEFT + UP),
     *                         Dot(UP * 2),
     *                     )
     *                     self.add(NumberPlane(), circle, dots)
     *         """
     */
//    fun from_three_points(p1: Point3D, p2: Point3D, p3: Point3D, **kwargs) -> Self:


}



open class Dot : Circle()
//    """A circle with a very small radius.
//
//    Parameters
//    ----------
//    point
//        The location of the dot.
//    radius
//        The radius of the dot.
//    stroke_width
//        The thickness of the outline of the dot.
//    fill_opacity
//        The opacity of the dot's fill_colour
//    color
//        The color of the dot.
//    kwargs
//        Additional arguments to be passed to :class:`Circle`
//
//    Examples
//    --------
//    .. manim:: DotExample
//        :save_last_frame:
//
//        class DotExample(Scene):
//            def construct(self):
//                dot1 = Dot(point=LEFT, radius=0.08)
//                dot2 = Dot(point=ORIGIN)
//                dot3 = Dot(point=RIGHT)
//                self.add(dot1,dot2,dot3)
//    """



open class AnnotationDot : Dot()
//    """A dot with bigger radius and bold stroke to annotate scenes."""


open class LabeledDot : Dot()
//    """A :class:`Dot` containing a label in its center.
//
//    Parameters
//    ----------
//    label
//        The label of the :class:`Dot`. This is rendered as :class:`~.MathTex`
//        by default (i.e., when passing a :class:`str`), but other classes
//        representing rendered strings like :class:`~.Text` or :class:`~.Tex`
//        can be passed as well.
//    radius
//        The radius of the :class:`Dot`. If ``None`` (the default), the radius
//        is calculated based on the size of the ``label``.
//
//    Examples
//    --------
//    .. manim:: SeveralLabeledDots
//        :save_last_frame:
//
//        class SeveralLabeledDots(Scene):
//            def construct(self):
//                sq = Square(fill_color=RED, fill_opacity=1)
//                self.add(sq)
//                dot1 = LabeledDot(Tex("42", color=RED))
//                dot2 = LabeledDot(MathTex("a", color=GREEN))
//                dot3 = LabeledDot(Text("ii", color=BLUE))
//                dot4 = LabeledDot("3")
//                dot1.next_to(sq, UL)
//                dot2.next_to(sq, UR)
//                dot3.next_to(sq, DL)
//                dot4.next_to(sq, DR)
//                self.add(dot1, dot2, dot3, dot4)
//    """


class Ellipse : Circle()
//    """A circular shape; oval, circle.
//
//    Parameters
//    ----------
//    width
//       The horizontal width of the ellipse.
//    height
//       The vertical height of the ellipse.
//    kwargs
//       Additional arguments to be passed to :class:`Circle`.
//
//    Examples
//    --------
//    .. manim:: EllipseExample
//        :save_last_frame:
//
//        class EllipseExample(Scene):
//            def construct(self):
//                ellipse_1 = Ellipse(width=2.0, height=4.0, color=BLUE_B)
//                ellipse_2 = Ellipse(width=4.0, height=1.0, color=BLUE_D)
//                ellipse_group = Group(ellipse_1,ellipse_2).arrange(buff=1)
//                self.add(ellipse_group)
//    """


open class AnnularSector : Arc()
//    """A sector of an annulus.
//
//
//    Parameters
//    ----------
//    inner_radius
//       The inside radius of the Annular Sector.
//    outer_radius
//       The outside radius of the Annular Sector.
//    angle
//       The clockwise angle of the Annular Sector.
//    start_angle
//       The starting clockwise angle of the Annular Sector.
//    fill_opacity
//       The opacity of the color filled in the Annular Sector.
//    stroke_width
//       The stroke width of the Annular Sector.
//    color
//       The color filled into the Annular Sector.
//
//    Examples
//    --------
//    .. manim:: AnnularSectorExample
//        :save_last_frame:
//
//        class AnnularSectorExample(Scene):
//            def construct(self):
//                # Changes background color to clearly visualize changes in fill_opacity.
//                self.camera.background_color = WHITE
//
//                # The default parameter start_angle is 0, so the AnnularSector starts from the +x-axis.
//                s1 = AnnularSector(color=YELLOW).move_to(2 * UL)
//
//                # Different inner_radius and outer_radius than the default.
//                s2 = AnnularSector(inner_radius=1.5, outer_radius=2, angle=45 * DEGREES, color=RED).move_to(2 * UR)
//
//                # fill_opacity is typically a number > 0 and <= 1. If fill_opacity=0, the AnnularSector is transparent.
//                s3 = AnnularSector(inner_radius=1, outer_radius=1.5, angle=PI, fill_opacity=0.25, color=BLUE).move_to(2 * DL)
//
//                # With a negative value for the angle, the AnnularSector is drawn clockwise from the start value.
//                s4 = AnnularSector(inner_radius=1, outer_radius=1.5, angle=-3 * PI / 2, color=GREEN).move_to(2 * DR)
//
//                self.add(s1, s2, s3, s4)
//    """


open class Sector : AnnularSector()
//    """A sector of a circle.
//
//    Examples
//    --------
//    .. manim:: ExampleSector
//        :save_last_frame:
//
//        class ExampleSector(Scene):
//            def construct(self):
//                sector = Sector(outer_radius=2, inner_radius=1)
//                sector2 = Sector(outer_radius=2.5, inner_radius=0.8).move_to([-3, 0, 0])
//                sector.set_color(RED)
//                sector2.set_color(PINK)
//                self.add(sector, sector2)
//    """


open class Annulus : Circle()
//    """Region between two concentric :class:`Circles <.Circle>`.
//
//    Parameters
//    ----------
//    inner_radius
//        The radius of the inner :class:`Circle`.
//    outer_radius
//        The radius of the outer :class:`Circle`.
//    kwargs
//        Additional arguments to be passed to :class:`Annulus`
//
//    Examples
//    --------
//    .. manim:: AnnulusExample
//        :save_last_frame:
//
//        class AnnulusExample(Scene):
//            def construct(self):
//                annulus_1 = Annulus(inner_radius=0.5, outer_radius=1).shift(UP)
//                annulus_2 = Annulus(inner_radius=0.3, outer_radius=0.6, color=RED).next_to(annulus_1, DOWN)
//                self.add(annulus_1, annulus_2)
//    """


open class CubicBezier : VMobject()
//    """A cubic Bézier curve.
//
//    Example
//    -------
//    .. manim:: BezierSplineExample
//        :save_last_frame:
//
//        class BezierSplineExample(Scene):
//            def construct(self):
//                p1 = np.array([-3, 1, 0])
//                p1b = p1 + [1, 0, 0]
//                d1 = Dot(point=p1).set_color(BLUE)
//                l1 = Line(p1, p1b)
//                p2 = np.array([3, -1, 0])
//                p2b = p2 - [1, 0, 0]
//                d2 = Dot(point=p2).set_color(RED)
//                l2 = Line(p2, p2b)
//                bezier = CubicBezier(p1b, p1b + 3 * RIGHT, p2b - 3 * RIGHT, p2b)
//                self.add(l1, d1, l2, d2, bezier)
//
//    """


open class ArcPolygon : VMobject()
//    """A generalized polygon allowing for points to be connected with arcs.
//
//    This version tries to stick close to the way :class:`Polygon` is used. Points
//    can be passed to it directly which are used to generate the according arcs
//    (using :class:`ArcBetweenPoints`). An angle or radius can be passed to it to
//    use across all arcs, but to configure arcs individually an ``arc_config`` list
//    has to be passed with the syntax explained below.
//
//    Parameters
//    ----------
//    vertices
//        A list of vertices, start and end points for the arc segments.
//    angle
//        The angle used for constructing the arcs. If no other parameters
//        are set, this angle is used to construct all arcs.
//    radius
//        The circle radius used to construct the arcs. If specified,
//        overrides the specified ``angle``.
//    arc_config
//        When passing a ``dict``, its content will be passed as keyword
//        arguments to :class:`~.ArcBetweenPoints`. Otherwise, a list
//        of dictionaries containing values that are passed as keyword
//        arguments for every individual arc can be passed.
//    kwargs
//        Further keyword arguments that are passed to the constructor of
//        :class:`~.VMobject`.
//
//    Attributes
//    ----------
//    arcs : :class:`list`
//        The arcs created from the input parameters::
//
//            >>> from manim import ArcPolygon
//            >>> ap = ArcPolygon([0, 0, 0], [2, 0, 0], [0, 2, 0])
//            >>> ap.arcs
//            [ArcBetweenPoints, ArcBetweenPoints, ArcBetweenPoints]
//
//
//    .. tip::
//
//        Two instances of :class:`ArcPolygon` can be transformed properly into one
//        another as well. Be advised that any arc initialized with ``angle=0``
//        will actually be a straight line, so if a straight section should seamlessly
//        transform into an arced section or vice versa, initialize the straight section
//        with a negligible angle instead (such as ``angle=0.0001``).
//
//    .. note::
//        There is an alternative version (:class:`ArcPolygonFromArcs`) that is instantiated
//        with pre-defined arcs.
//
//    See Also
//    --------
//    :class:`ArcPolygonFromArcs`
//
//
//    Examples
//    --------
//    .. manim:: SeveralArcPolygons
//
//        class SeveralArcPolygons(Scene):
//            def construct(self):
//                a = [0, 0, 0]
//                b = [2, 0, 0]
//                c = [0, 2, 0]
//                ap1 = ArcPolygon(a, b, c, radius=2)
//                ap2 = ArcPolygon(a, b, c, angle=45*DEGREES)
//                ap3 = ArcPolygon(a, b, c, arc_config={'radius': 1.7, 'color': RED})
//                ap4 = ArcPolygon(a, b, c, color=RED, fill_opacity=1,
//                                            arc_config=[{'radius': 1.7, 'color': RED},
//                                            {'angle': 20*DEGREES, 'color': BLUE},
//                                            {'radius': 1}])
//                ap_group = VGroup(ap1, ap2, ap3, ap4).arrange()
//                self.play(*[Create(ap) for ap in [ap1, ap2, ap3, ap4]])
//                self.wait()
//
//    For further examples see :class:`ArcPolygonFromArcs`.
//    """

open class ArcPolygonFromArcs : VMobject()
//    """A generalized polygon allowing for points to be connected with arcs.
//
//    This version takes in pre-defined arcs to generate the arcpolygon and introduces
//    little new syntax. However unlike :class:`Polygon` it can't be created with points
//    directly.
//
//    For proper appearance the passed arcs should connect seamlessly:
//    ``[a,b][b,c][c,a]``
//
//    If there are any gaps between the arcs, those will be filled in
//    with straight lines, which can be used deliberately for any straight
//    sections. Arcs can also be passed as straight lines such as an arc
//    initialized with ``angle=0``.
//
//    Parameters
//    ----------
//    arcs
//        These are the arcs from which the arcpolygon is assembled.
//    kwargs
//        Keyword arguments that are passed to the constructor of
//        :class:`~.VMobject`. Affects how the ArcPolygon itself is drawn,
//        but doesn't affect passed arcs.
//
//    Attributes
//    ----------
//    arcs
//        The arcs used to initialize the ArcPolygonFromArcs::
//
//            >>> from manim import ArcPolygonFromArcs, Arc, ArcBetweenPoints
//            >>> ap = ArcPolygonFromArcs(Arc(), ArcBetweenPoints([1,0,0], [0,1,0]), Arc())
//            >>> ap.arcs
//            [Arc, ArcBetweenPoints, Arc]
//
//
//    .. tip::
//
//        Two instances of :class:`ArcPolygon` can be transformed properly into
//        one another as well. Be advised that any arc initialized with ``angle=0``
//        will actually be a straight line, so if a straight section should seamlessly
//        transform into an arced section or vice versa, initialize the straight
//        section with a negligible angle instead (such as ``angle=0.0001``).
//
//    .. note::
//        There is an alternative version (:class:`ArcPolygon`) that can be instantiated
//        with points.
//
//    .. seealso::
//        :class:`ArcPolygon`
//
//    Examples
//    --------
//    One example of an arcpolygon is the Reuleaux triangle.
//    Instead of 3 straight lines connecting the outer points,
//    a Reuleaux triangle has 3 arcs connecting those points,
//    making a shape with constant width.
//
//    Passed arcs are stored as submobjects in the arcpolygon.
//    This means that the arcs are changed along with the arcpolygon,
//    for example when it's shifted, and these arcs can be manipulated
//    after the arcpolygon has been initialized.
//
//    Also both the arcs contained in an :class:`~.ArcPolygonFromArcs`, as well as the
//    arcpolygon itself are drawn, which affects draw time in :class:`~.Create`
//    for example. In most cases the arcs themselves don't
//    need to be drawn, in which case they can be passed as invisible.
//
//    .. manim:: ArcPolygonExample
//
//        class ArcPolygonExample(Scene):
//            def construct(self):
//                arc_conf = {"stroke_width": 0}
//                poly_conf = {"stroke_width": 10, "stroke_color": BLUE,
//                      "fill_opacity": 1, "color": PURPLE}
//                a = [-1, 0, 0]
//                b = [1, 0, 0]
//                c = [0, np.sqrt(3), 0]
//                arc0 = ArcBetweenPoints(a, b, radius=2, **arc_conf)
//                arc1 = ArcBetweenPoints(b, c, radius=2, **arc_conf)
//                arc2 = ArcBetweenPoints(c, a, radius=2, **arc_conf)
//                reuleaux_tri = ArcPolygonFromArcs(arc0, arc1, arc2, **poly_conf)
//                self.play(FadeIn(reuleaux_tri))
//                self.wait(2)
//
//    The arcpolygon itself can also be hidden so that instead only the contained
//    arcs are drawn. This can be used to easily debug arcs or to highlight them.
//
//    .. manim:: ArcPolygonExample2
//
//        class ArcPolygonExample2(Scene):
//            def construct(self):
//                arc_conf = {"stroke_width": 3, "stroke_color": BLUE,
//                    "fill_opacity": 0.5, "color": GREEN}
//                poly_conf = {"color": None}
//                a = [-1, 0, 0]
//                b = [1, 0, 0]
//                c = [0, np.sqrt(3), 0]
//                arc0 = ArcBetweenPoints(a, b, radius=2, **arc_conf)
//                arc1 = ArcBetweenPoints(b, c, radius=2, **arc_conf)
//                arc2 = ArcBetweenPoints(c, a, radius=2, stroke_color=RED)
//                reuleaux_tri = ArcPolygonFromArcs(arc0, arc1, arc2, **poly_conf)
//                self.play(FadeIn(reuleaux_tri))
//                self.wait(2)
//    """
