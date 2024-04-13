package corp.wmsoft.manim.mobject.geometry

import corp.wmsoft.manim.mobject.types.VMobject

//r"""Mobjects that are simple geometric shapes."""


open class Polygram : VMobject()
//    """A generalized :class:`Polygon`, allowing for disconnected sets of edges.
//
//    Parameters
//    ----------
//    vertex_groups
//        The groups of vertices making up the :class:`Polygram`.
//
//        The first vertex in each group is repeated to close the shape.
//        Each point must be 3-dimensional: ``[x,y,z]``
//    color
//        The color of the :class:`Polygram`.
//    kwargs
//        Forwarded to the parent constructor.
//
//    Examples
//    --------
//    .. manim:: PolygramExample
//
//        import numpy as np
//
//        class PolygramExample(Scene):
//            def construct(self):
//                hexagram = Polygram(
//                    [[0, 2, 0], [-np.sqrt(3), -1, 0], [np.sqrt(3), -1, 0]],
//                    [[-np.sqrt(3), 1, 0], [0, -2, 0], [np.sqrt(3), 1, 0]],
//                )
//                self.add(hexagram)
//
//                dot = Dot()
//                self.play(MoveAlongPath(dot, hexagram), run_time=5, rate_func=linear)
//                self.remove(dot)
//                self.wait()
//    """


open class Polygon : Polygram()
//    """A shape consisting of one closed loop of vertices.
//
//    Parameters
//    ----------
//    vertices
//        The vertices of the :class:`Polygon`.
//    kwargs
//        Forwarded to the parent constructor.
//
//    Examples
//    --------
//    .. manim:: PolygonExample
//        :save_last_frame:
//
//        class PolygonExample(Scene):
//            def construct(self):
//                isosceles = Polygon([-5, 1.5, 0], [-2, 1.5, 0], [-3.5, -2, 0])
//                position_list = [
//                    [4, 1, 0],  # middle right
//                    [4, -2.5, 0],  # bottom right
//                    [0, -2.5, 0],  # bottom left
//                    [0, 3, 0],  # top left
//                    [2, 1, 0],  # middle
//                    [4, 3, 0],  # top right
//                ]
//                square_and_triangles = Polygon(*position_list, color=PURPLE_B)
//                self.add(isosceles, square_and_triangles)
//    """


open class RegularPolygram : Polygram()
//    """A :class:`Polygram` with regularly spaced vertices.
//
//    Parameters
//    ----------
//    num_vertices
//        The number of vertices.
//    density
//        The density of the :class:`RegularPolygram`.
//
//        Can be thought of as how many vertices to hop
//        to draw a line between them. Every ``density``-th
//        vertex is connected.
//    radius
//        The radius of the circle that the vertices are placed on.
//    start_angle
//        The angle the vertices start at; the rotation of
//        the :class:`RegularPolygram`.
//    kwargs
//        Forwarded to the parent constructor.
//
//    Examples
//    --------
//    .. manim:: RegularPolygramExample
//        :save_last_frame:
//
//        class RegularPolygramExample(Scene):
//            def construct(self):
//                pentagram = RegularPolygram(5, radius=2)
//                self.add(pentagram)
//    """


open class RegularPolygon : RegularPolygram()
//    """An n-sided regular :class:`Polygon`.
//
//    Parameters
//    ----------
//    n
//        The number of sides of the :class:`RegularPolygon`.
//    kwargs
//        Forwarded to the parent constructor.
//
//    Examples
//    --------
//    .. manim:: RegularPolygonExample
//        :save_last_frame:
//
//        class RegularPolygonExample(Scene):
//            def construct(self):
//                poly_1 = RegularPolygon(n=6)
//                poly_2 = RegularPolygon(n=6, start_angle=30*DEGREES, color=GREEN)
//                poly_3 = RegularPolygon(n=10, color=RED)
//
//                poly_group = Group(poly_1, poly_2, poly_3).scale(1.5).arrange(buff=1)
//                self.add(poly_group)
//    """


class Star : Polygon()
//    """A regular polygram without the intersecting lines.
//
//    Parameters
//    ----------
//    n
//        How many points on the :class:`Star`.
//    outer_radius
//        The radius of the circle that the outer vertices are placed on.
//    inner_radius
//        The radius of the circle that the inner vertices are placed on.
//
//        If unspecified, the inner radius will be
//        calculated such that the edges of the :class:`Star`
//        perfectly follow the edges of its :class:`RegularPolygram`
//        counterpart.
//    density
//        The density of the :class:`Star`. Only used if
//        ``inner_radius`` is unspecified.
//
//        See :class:`RegularPolygram` for more information.
//    start_angle
//        The angle the vertices start at; the rotation of
//        the :class:`Star`.
//    kwargs
//        Forwardeds to the parent constructor.
//
//    Raises
//    ------
//    :exc:`ValueError`
//        If ``inner_radius`` is unspecified and ``density``
//        is not in the range ``[1, n/2)``.
//
//    Examples
//    --------
//    .. manim:: StarExample
//        :save_as_gif:
//
//        class StarExample(Scene):
//            def construct(self):
//                pentagram = RegularPolygram(5, radius=2)
//                star = Star(outer_radius=2, color=RED)
//
//                self.add(pentagram)
//                self.play(Create(star), run_time=3)
//                self.play(FadeOut(star), run_time=2)
//
//    .. manim:: DifferentDensitiesExample
//        :save_last_frame:
//
//        class DifferentDensitiesExample(Scene):
//            def construct(self):
//                density_2 = Star(7, outer_radius=2, density=2, color=RED)
//                density_3 = Star(7, outer_radius=2, density=3, color=PURPLE)
//
//                self.add(VGroup(density_2, density_3).arrange(RIGHT))
//
//    """


class Triangle : RegularPolygon()
//    """An equilateral triangle.
//
//    Parameters
//    ----------
//    kwargs
//        Additional arguments to be passed to :class:`RegularPolygon`
//
//    Examples
//    --------
//    .. manim:: TriangleExample
//        :save_last_frame:
//
//        class TriangleExample(Scene):
//            def construct(self):
//                triangle_1 = Triangle()
//                triangle_2 = Triangle().scale(2).rotate(60*DEGREES)
//                tri_group = Group(triangle_1, triangle_2).arrange(buff=1)
//                self.add(tri_group)
//    """


open class Rectangle : Polygon()
//    """A quadrilateral with two sets of parallel sides.
//
//    Parameters
//    ----------
//    color
//        The color of the rectangle.
//    height
//        The vertical height of the rectangle.
//    width
//        The horizontal width of the rectangle.
//    grid_xstep
//        Space between vertical grid lines.
//    grid_ystep
//        Space between horizontal grid lines.
//    mark_paths_closed
//        No purpose.
//    close_new_points
//        No purpose.
//    kwargs
//        Additional arguments to be passed to :class:`Polygon`
//
//    Examples
//    ----------
//    .. manim:: RectangleExample
//        :save_last_frame:
//
//        class RectangleExample(Scene):
//            def construct(self):
//                rect1 = Rectangle(width=4.0, height=2.0, grid_xstep=1.0, grid_ystep=0.5)
//                rect2 = Rectangle(width=1.0, height=4.0)
//                rect3 = Rectangle(width=2.0, height=2.0, grid_xstep=1.0, grid_ystep=1.0)
//                rect3.grid_lines.set_stroke(width=1)
//
//                rects = Group(rect1, rect2, rect3).arrange(buff=1)
//                self.add(rects)
//    """


open class Square : Rectangle()
//    """A rectangle with equal side lengths.
//
//    Parameters
//    ----------
//    side_length
//        The length of the sides of the square.
//    kwargs
//        Additional arguments to be passed to :class:`Rectangle`.
//
//    Examples
//    --------
//    .. manim:: SquareExample
//        :save_last_frame:
//
//        class SquareExample(Scene):
//            def construct(self):
//                square_1 = Square(side_length=2.0).shift(DOWN)
//                square_2 = Square(side_length=1.0).next_to(square_1, direction=UP)
//                square_3 = Square(side_length=0.5).next_to(square_2, direction=UP)
//                self.add(square_1, square_2, square_3)
//    """


open class RoundedRectangle : Rectangle()
//    """A rectangle with rounded corners.
//
//    Parameters
//    ----------
//    corner_radius
//        The curvature of the corners of the rectangle.
//    kwargs
//        Additional arguments to be passed to :class:`Rectangle`
//
//    Examples
//    --------
//    .. manim:: RoundedRectangleExample
//        :save_last_frame:
//
//        class RoundedRectangleExample(Scene):
//            def construct(self):
//                rect_1 = RoundedRectangle(corner_radius=0.5)
//                rect_2 = RoundedRectangle(corner_radius=1.5, height=4.0, width=4.0)
//
//                rect_group = Group(rect_1, rect_2).arrange(buff=1)
//                self.add(rect_group)
//    """


class Cutout : VMobject()
//    """A shape with smaller cutouts.
//
//    Parameters
//    ----------
//    main_shape
//        The primary shape from which cutouts are made.
//    mobjects
//        The smaller shapes which are to be cut out of the ``main_shape``.
//    kwargs
//        Further keyword arguments that are passed to the constructor of
//        :class:`~.VMobject`.
//
//
//    .. warning::
//        Technically, this class behaves similar to a symmetric difference: if
//        parts of the ``mobjects`` are not located within the ``main_shape``,
//        these parts will be added to the resulting :class:`~.VMobject`.
//
//    Examples
//    --------
//    .. manim:: CutoutExample
//
//        class CutoutExample(Scene):
//            def construct(self):
//                s1 = Square().scale(2.5)
//                s2 = Triangle().shift(DOWN + RIGHT).scale(0.5)
//                s3 = Square().shift(UP + RIGHT).scale(0.5)
//                s4 = RegularPolygon(5).shift(DOWN + LEFT).scale(0.5)
//                s5 = RegularPolygon(6).shift(UP + LEFT).scale(0.5)
//                c = Cutout(s1, s2, s3, s4, s5, fill_opacity=1, color=BLUE, stroke_color=RED)
//                self.play(Write(c), run_time=4)
//                self.wait()
//    """
