package corp.wmsoft.manim.mobject.geometry

import corp.wmsoft.manim.mobject.types.VMobject

//r"""Mobjects that are lines or variations of them."""

open class Line : TipableVMobject()

open class DashedLine : Line()
//    """A dashed :class:`Line`.
//
//    Parameters
//    ----------
//    args
//        Arguments to be passed to :class:`Line`
//    dash_length
//        The length of each individual dash of the line.
//    dashed_ratio
//        The ratio of dash space to empty space. Range of 0-1.
//    kwargs
//        Additional arguments to be passed to :class:`Line`
//
//
//    .. seealso::
//        :class:`~.DashedVMobject`
//
//    Examples
//    --------
//    .. manim:: DashedLineExample
//        :save_last_frame:
//
//        class DashedLineExample(Scene):
//            def construct(self):
//                # dash_length increased
//                dashed_1 = DashedLine(config.left_side, config.right_side, dash_length=2.0).shift(UP*2)
//                # normal
//                dashed_2 = DashedLine(config.left_side, config.right_side)
//                # dashed_ratio decreased
//                dashed_3 = DashedLine(config.left_side, config.right_side, dashed_ratio=0.1).shift(DOWN*2)
//                self.add(dashed_1, dashed_2, dashed_3)
//    """


open class TangentLine : Line()
//    """Constructs a line tangent to a :class:`~.VMobject` at a specific point.
//
//    Parameters
//    ----------
//    vmob
//        The VMobject on which the tangent line is drawn.
//    alpha
//        How far along the shape that the line will be constructed. range: 0-1.
//    length
//        Length of the tangent line.
//    d_alpha
//        The ``dx`` value
//    kwargs
//        Additional arguments to be passed to :class:`Line`
//
//
//    .. seealso::
//        :meth:`~.VMobject.point_from_proportion`
//
//    Examples
//    --------
//    .. manim:: TangentLineExample
//        :save_last_frame:
//
//        class TangentLineExample(Scene):
//            def construct(self):
//                circle = Circle(radius=2)
//                line_1 = TangentLine(circle, alpha=0.0, length=4, color=BLUE_D) # right
//                line_2 = TangentLine(circle, alpha=0.4, length=4, color=GREEN) # top left
//                self.add(circle, line_1, line_2)
//    """


open class Elbow : VMobject()
//    """Two lines that create a right angle about each other: L-shape.
//
//    Parameters
//    ----------
//    width
//        The length of the elbow's sides.
//    angle
//        The rotation of the elbow.
//    kwargs
//        Additional arguments to be passed to :class:`~.VMobject`
//
//    .. seealso::
//        :class:`RightAngle`
//
//    Examples
//    --------
//    .. manim:: ElbowExample
//        :save_last_frame:
//
//        class ElbowExample(Scene):
//            def construct(self):
//                elbow_1 = Elbow()
//                elbow_2 = Elbow(width=2.0)
//                elbow_3 = Elbow(width=2.0, angle=5*PI/4)
//
//                elbow_group = Group(elbow_1, elbow_2, elbow_3).arrange(buff=1)
//                self.add(elbow_group)
//    """


open class Arrow : Line()
//    """An arrow.
//
//    Parameters
//    ----------
//    args
//        Arguments to be passed to :class:`Line`.
//    stroke_width
//        The thickness of the arrow. Influenced by :attr:`max_stroke_width_to_length_ratio`.
//    buff
//        The distance of the arrow from its start and end points.
//    max_tip_length_to_length_ratio
//        :attr:`tip_length` scales with the length of the arrow. Increasing this ratio raises the max value of :attr:`tip_length`.
//    max_stroke_width_to_length_ratio
//        :attr:`stroke_width` scales with the length of the arrow. Increasing this ratio ratios the max value of :attr:`stroke_width`.
//    kwargs
//        Additional arguments to be passed to :class:`Line`.
//
//
//    .. seealso::
//        :class:`ArrowTip`
//        :class:`CurvedArrow`
//
//    Examples
//    --------
//    .. manim:: ArrowExample
//        :save_last_frame:
//
//        from manim.mobject.geometry.tips import ArrowSquareTip
//        class ArrowExample(Scene):
//            def construct(self):
//                arrow_1 = Arrow(start=RIGHT, end=LEFT, color=GOLD)
//                arrow_2 = Arrow(start=RIGHT, end=LEFT, color=GOLD, tip_shape=ArrowSquareTip).shift(DOWN)
//                g1 = Group(arrow_1, arrow_2)
//
//                # the effect of buff
//                square = Square(color=MAROON_A)
//                arrow_3 = Arrow(start=LEFT, end=RIGHT)
//                arrow_4 = Arrow(start=LEFT, end=RIGHT, buff=0).next_to(arrow_1, UP)
//                g2 = Group(arrow_3, arrow_4, square)
//
//                # a shorter arrow has a shorter tip and smaller stroke width
//                arrow_5 = Arrow(start=ORIGIN, end=config.top).shift(LEFT * 4)
//                arrow_6 = Arrow(start=config.top + DOWN, end=config.top).shift(LEFT * 3)
//                g3 = Group(arrow_5, arrow_6)
//
//                self.add(Group(g1, g2, g3).arrange(buff=2))
//
//
//    .. manim:: ArrowExample
//        :save_last_frame:
//
//        class ArrowExample(Scene):
//            def construct(self):
//                left_group = VGroup()
//                # As buff increases, the size of the arrow decreases.
//                for buff in np.arange(0, 2.2, 0.45):
//                    left_group += Arrow(buff=buff, start=2 * LEFT, end=2 * RIGHT)
//                # Required to arrange arrows.
//                left_group.arrange(DOWN)
//                left_group.move_to(4 * LEFT)
//
//                middle_group = VGroup()
//                # As max_stroke_width_to_length_ratio gets bigger,
//                # the width of stroke increases.
//                for i in np.arange(0, 5, 0.5):
//                    middle_group += Arrow(max_stroke_width_to_length_ratio=i)
//                middle_group.arrange(DOWN)
//
//                UR_group = VGroup()
//                # As max_tip_length_to_length_ratio increases,
//                # the length of the tip increases.
//                for i in np.arange(0, 0.3, 0.1):
//                    UR_group += Arrow(max_tip_length_to_length_ratio=i)
//                UR_group.arrange(DOWN)
//                UR_group.move_to(4 * RIGHT + 2 * UP)
//
//                DR_group = VGroup()
//                DR_group += Arrow(start=LEFT, end=RIGHT, color=BLUE, tip_shape=ArrowSquareTip)
//                DR_group += Arrow(start=LEFT, end=RIGHT, color=BLUE, tip_shape=ArrowSquareFilledTip)
//                DR_group += Arrow(start=LEFT, end=RIGHT, color=YELLOW, tip_shape=ArrowCircleTip)
//                DR_group += Arrow(start=LEFT, end=RIGHT, color=YELLOW, tip_shape=ArrowCircleFilledTip)
//                DR_group.arrange(DOWN)
//                DR_group.move_to(4 * RIGHT + 2 * DOWN)
//
//                self.add(left_group, middle_group, UR_group, DR_group)
//    """


open class Vector : Arrow()
//    """A vector specialized for use in graphs.
//
//    .. caution::
//        Do not confuse with the :class:`~.Vector2D`,
//        :class:`~.Vector3D` or :class:`~.VectorND` type aliases,
//        which are not Mobjects!
//
//    Parameters
//    ----------
//    direction
//        The direction of the arrow.
//    buff
//         The distance of the vector from its endpoints.
//    kwargs
//        Additional arguments to be passed to :class:`Arrow`
//
//    Examples
//    --------
//    .. manim:: VectorExample
//        :save_last_frame:
//
//        class VectorExample(Scene):
//            def construct(self):
//                plane = NumberPlane()
//                vector_1 = Vector([1,2])
//                vector_2 = Vector([-5,-2])
//                self.add(plane, vector_1, vector_2)
//    """


open class DoubleArrow : Arrow()
//    """An arrow with tips on both ends.
//
//    Parameters
//    ----------
//    args
//        Arguments to be passed to :class:`Arrow`
//    kwargs
//        Additional arguments to be passed to :class:`Arrow`
//
//
//    .. seealso::
//        :class:`.~ArrowTip`
//        :class:`.~CurvedDoubleArrow`
//
//    Examples
//    --------
//    .. manim:: DoubleArrowExample
//        :save_last_frame:
//
//        from manim.mobject.geometry.tips import ArrowCircleFilledTip
//        class DoubleArrowExample(Scene):
//            def construct(self):
//                circle = Circle(radius=2.0)
//                d_arrow = DoubleArrow(start=circle.get_left(), end=circle.get_right())
//                d_arrow_2 = DoubleArrow(tip_shape_end=ArrowCircleFilledTip, tip_shape_start=ArrowCircleFilledTip)
//                group = Group(Group(circle, d_arrow), d_arrow_2).arrange(UP, buff=1)
//                self.add(group)
//
//
//    .. manim:: DoubleArrowExample2
//        :save_last_frame:
//
//        class DoubleArrowExample2(Scene):
//            def construct(self):
//                box = Square()
//                p1 = box.get_left()
//                p2 = box.get_right()
//                d1 = DoubleArrow(p1, p2, buff=0)
//                d2 = DoubleArrow(p1, p2, buff=0, tip_length=0.2, color=YELLOW)
//                d3 = DoubleArrow(p1, p2, buff=0, tip_length=0.4, color=BLUE)
//                Group(d1, d2, d3).arrange(DOWN)
//                self.add(box, d1, d2, d3)
//    """


open class Angle : VMobject()
//    """A circular arc or elbow-type mobject representing an angle of two lines.
//
//    Parameters
//    ----------
//    line1 :
//        The first line.
//    line2 :
//        The second line.
//    radius :
//        The radius of the :class:`Arc`.
//    quadrant
//        A sequence of two :class:`int` numbers determining which of the 4 quadrants should be used.
//        The first value indicates whether to anchor the arc on the first line closer to the end point (1)
//        or start point (-1), and the second value functions similarly for the
//        end (1) or start (-1) of the second line.
//        Possibilities: (1,1), (-1,1), (1,-1), (-1,-1).
//    other_angle :
//        Toggles between the two possible angles defined by two points and an arc center. If set to
//        False (default), the arc will always go counterclockwise from the point on line1 until
//        the point on line2 is reached. If set to True, the angle will go clockwise from line1 to line2.
//    dot
//        Allows for a :class:`Dot` in the arc. Mainly used as an convention to indicate a right angle.
//        The dot can be customized in the next three parameters.
//    dot_radius
//        The radius of the :class:`Dot`. If not specified otherwise, this radius will be 1/10 of the arc radius.
//    dot_distance
//        Relative distance from the center to the arc: 0 puts the dot in the center and 1 on the arc itself.
//    dot_color
//        The color of the :class:`Dot`.
//    elbow
//        Produces an elbow-type mobject indicating a right angle, see :class:`RightAngle` for more information
//        and a shorthand.
//    **kwargs
//        Further keyword arguments that are passed to the constructor of :class:`Arc` or :class:`Elbow`.
//
//    Examples
//    --------
//    The first example shows some right angles with a dot in the middle while the second example shows
//    all 8 possible angles defined by two lines.
//
//    .. manim:: RightArcAngleExample
//        :save_last_frame:
//
//        class RightArcAngleExample(Scene):
//            def construct(self):
//                line1 = Line( LEFT, RIGHT )
//                line2 = Line( DOWN, UP )
//                rightarcangles = [
//                    Angle(line1, line2, dot=True),
//                    Angle(line1, line2, radius=0.4, quadrant=(1,-1), dot=True, other_angle=True),
//                    Angle(line1, line2, radius=0.5, quadrant=(-1,1), stroke_width=8, dot=True, dot_color=YELLOW, dot_radius=0.04, other_angle=True),
//                    Angle(line1, line2, radius=0.7, quadrant=(-1,-1), color=RED, dot=True, dot_color=GREEN, dot_radius=0.08),
//                ]
//                plots = VGroup()
//                for angle in rightarcangles:
//                    plot=VGroup(line1.copy(),line2.copy(), angle)
//                    plots.add(plot)
//                plots.arrange(buff=1.5)
//                self.add(plots)
//
//    .. manim:: AngleExample
//        :save_last_frame:
//
//        class AngleExample(Scene):
//            def construct(self):
//                line1 = Line( LEFT + (1/3) * UP, RIGHT + (1/3) * DOWN )
//                line2 = Line( DOWN + (1/3) * RIGHT, UP + (1/3) * LEFT )
//                angles = [
//                    Angle(line1, line2),
//                    Angle(line1, line2, radius=0.4, quadrant=(1,-1), other_angle=True),
//                    Angle(line1, line2, radius=0.5, quadrant=(-1,1), stroke_width=8, other_angle=True),
//                    Angle(line1, line2, radius=0.7, quadrant=(-1,-1), color=RED),
//                    Angle(line1, line2, other_angle=True),
//                    Angle(line1, line2, radius=0.4, quadrant=(1,-1)),
//                    Angle(line1, line2, radius=0.5, quadrant=(-1,1), stroke_width=8),
//                    Angle(line1, line2, radius=0.7, quadrant=(-1,-1), color=RED, other_angle=True),
//                ]
//                plots = VGroup()
//                for angle in angles:
//                    plot=VGroup(line1.copy(),line2.copy(), angle)
//                    plots.add(VGroup(plot,SurroundingRectangle(plot, buff=0.3)))
//                plots.arrange_in_grid(rows=2,buff=1)
//                self.add(plots)
//
//    .. manim:: FilledAngle
//        :save_last_frame:
//
//        class FilledAngle(Scene):
//            def construct(self):
//                l1 = Line(ORIGIN, 2 * UP + RIGHT).set_color(GREEN)
//                l2 = (
//                    Line(ORIGIN, 2 * UP + RIGHT)
//                    .set_color(GREEN)
//                    .rotate(-20 * DEGREES, about_point=ORIGIN)
//                )
//                norm = l1.get_length()
//                a1 = Angle(l1, l2, other_angle=True, radius=norm - 0.5).set_color(GREEN)
//                a2 = Angle(l1, l2, other_angle=True, radius=norm).set_color(GREEN)
//                q1 = a1.points #  save all coordinates of points of angle a1
//                q2 = a2.reverse_direction().points  #  save all coordinates of points of angle a1 (in reversed direction)
//                pnts = np.concatenate([q1, q2, q1[0].reshape(1, 3)])  # adds points and ensures that path starts and ends at same point
//                mfill = VMobject().set_color(ORANGE)
//                mfill.set_points_as_corners(pnts).set_fill(GREEN, opacity=1)
//                self.add(l1, l2)
//                self.add(mfill)
//
//    """


open class RightAngle : Angle()
//    """An elbow-type mobject representing a right angle between two lines.
//
//    Parameters
//    ----------
//    line1
//        The first line.
//    line2
//        The second line.
//    length
//        The length of the arms.
//    **kwargs
//        Further keyword arguments that are passed to the constructor of :class:`Angle`.
//
//    Examples
//    --------
//    .. manim:: RightAngleExample
//        :save_last_frame:
//
//        class RightAngleExample(Scene):
//            def construct(self):
//                line1 = Line( LEFT, RIGHT )
//                line2 = Line( DOWN, UP )
//                rightangles = [
//                    RightAngle(line1, line2),
//                    RightAngle(line1, line2, length=0.4, quadrant=(1,-1)),
//                    RightAngle(line1, line2, length=0.5, quadrant=(-1,1), stroke_width=8),
//                    RightAngle(line1, line2, length=0.7, quadrant=(-1,-1), color=RED),
//                ]
//                plots = VGroup()
//                for rightangle in rightangles:
//                    plot=VGroup(line1.copy(),line2.copy(), rightangle)
//                    plots.add(plot)
//                plots.arrange(buff=1.5)
//                self.add(plots)
//    """
