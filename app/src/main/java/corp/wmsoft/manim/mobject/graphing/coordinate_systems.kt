package corp.wmsoft.manim.mobject.graphing

//"""Mobjects that represent coordinate systems."""


open class CoordinateSystem()
//    r"""Abstract base open class for Axes and NumberPlane.
//
//    Examples
//    --------
//    .. manim:: CoordSysExample
//        :save_last_frame:
//
//        open class CoordSysExample(Scene):
//            def construct(self):
//                # the location of the ticks depends on the x_range and y_range.
//                grid = Axes(
//                    x_range=[0, 1, 0.05],  # step size determines num_decimal_places.
//                    y_range=[0, 1, 0.05],
//                    x_length=9,
//                    y_length=5.5,
//                    axis_config={
//                        "numbers_to_include": np.arange(0, 1 + 0.1, 0.1),
//                        "font_size": 24,
//                    },
//                    tips=False,
//                )
//
//                # Labels for the x-axis and y-axis.
//                y_label = grid.get_y_axis_label("y", edge=LEFT, direction=LEFT, buff=0.4)
//                x_label = grid.get_x_axis_label("x")
//                grid_labels = VGroup(x_label, y_label)
//
//                graphs = VGroup()
//                for n in np.arange(1, 20 + 0.5, 0.5):
//                    graphs += grid.plot(lambda x: x ** n, color=WHITE)
//                    graphs += grid.plot(
//                        lambda x: x ** (1 / n), color=WHITE, use_smoothing=False
//                    )
//
//                # Extra lines and labels for point (1,1)
//                graphs += grid.get_horizontal_line(grid.c2p(1, 1, 0), color=BLUE)
//                graphs += grid.get_vertical_line(grid.c2p(1, 1, 0), color=BLUE)
//                graphs += Dot(point=grid.c2p(1, 1, 0), color=YELLOW)
//                graphs += Tex("(1,1)").scale(0.75).next_to(grid.c2p(1, 1, 0))
//                title = Title(
//                    # spaces between braces to prevent SyntaxError
//                    r"Graphs of $y=x^{ {1}\over{n} }$ and $y=x^n (n=1,2,3,...,20)$",
//                    include_underline=False,
//                    font_size=40,
//                )
//
//                self.add(title, graphs, grid, grid_labels)
//    """


open class Axes() //(VGroup, CoordinateSystem
//    """Creates a set of axes.
//
//    Parameters
//    ----------
//    x_range
//        The ``(x_min, x_max, x_step)`` values of the x-axis.
//    y_range
//        The ``(y_min, y_max, y_step)`` values of the y-axis.
//    x_length
//        The length of the x-axis.
//    y_length
//        The length of the y-axis.
//    axis_config
//        Arguments to be passed to :open class:`~.NumberLine` that influences both axes.
//    x_axis_config
//        Arguments to be passed to :open class:`~.NumberLine` that influence the x-axis.
//    y_axis_config
//        Arguments to be passed to :open class:`~.NumberLine` that influence the y-axis.
//    tips
//        Whether or not to include the tips on both axes.
//    kwargs
//        Additional arguments to be passed to :open class:`CoordinateSystem` and :open class:`~.VGroup`.
//
//    Examples
//    --------
//    .. manim:: LogScalingExample
//        :save_last_frame:
//
//        open class LogScalingExample(Scene):
//            def construct(self):
//                ax = Axes(
//                    x_range=[0, 10, 1],
//                    y_range=[-2, 6, 1],
//                    tips=False,
//                    axis_config={"include_numbers": True},
//                    y_axis_config={"scaling": LogBase(custom_labels=True)},
//                )
//
//                # x_min must be > 0 because log is undefined at 0.
//                graph = ax.plot(lambda x: x ** 2, x_range=[0.001, 10], use_smoothing=False)
//                self.add(ax, graph)
//
//    Styling arguments can be passed to the underlying :open class:`.NumberLine`
//    mobjects that represent the axes:
//
//    .. manim:: AxesWithDifferentTips
//        :save_last_frame:
//
//        open class AxesWithDifferentTips(Scene):
//            def construct(self):
//                ax = Axes(axis_config={'tip_shape': StealthTip})
//                self.add(ax)
//    """


open class ThreeDAxes : Axes()
//    """A 3-dimensional set of axes.
//
//    Parameters
//    ----------
//    x_range
//        The ``[x_min, x_max, x_step]`` values of the x-axis.
//    y_range
//        The ``[y_min, y_max, y_step]`` values of the y-axis.
//    z_range
//        The ``[z_min, z_max, z_step]`` values of the z-axis.
//    x_length
//        The length of the x-axis.
//    y_length
//        The length of the y-axis.
//    z_length
//        The length of the z-axis.
//    z_axis_config
//        Arguments to be passed to :open class:`~.NumberLine` that influence the z-axis.
//    z_normal
//        The direction of the normal.
//    num_axis_pieces
//        The number of pieces used to construct the axes.
//    light_source
//        The direction of the light source.
//    depth
//        Currently non-functional.
//    gloss
//        Currently non-functional.
//    kwargs
//        Additional arguments to be passed to :open class:`Axes`.
//    """


open class NumberPlane : Axes()
//    """Creates a cartesian plane with background lines.
//
//    Parameters
//    ----------
//    x_range
//        The ``[x_min, x_max, x_step]`` values of the plane in the horizontal direction.
//    y_range
//        The ``[y_min, y_max, y_step]`` values of the plane in the vertical direction.
//    x_length
//        The width of the plane.
//    y_length
//        The height of the plane.
//    background_line_style
//        Arguments that influence the construction of the background lines of the plane.
//    faded_line_style
//        Similar to :attr:`background_line_style`, affects the construction of the scene's background lines.
//    faded_line_ratio
//        Determines the number of boxes within the background lines: :code:`2` = 4 boxes, :code:`3` = 9 boxes.
//    make_smooth_after_applying_functions
//        Currently non-functional.
//    kwargs
//        Additional arguments to be passed to :open class:`Axes`.
//
//
//    .. note::
//        If :attr:`x_length` or :attr:`y_length` are not defined, they are automatically calculated such that
//        one unit on each axis is one Manim unit long.
//
//    Examples
//    --------
//    .. manim:: NumberPlaneExample
//        :save_last_frame:
//
//        open class NumberPlaneExample(Scene):
//            def construct(self):
//                number_plane = NumberPlane(
//                    background_line_style={
//                        "stroke_color": TEAL,
//                        "stroke_width": 4,
//                        "stroke_opacity": 0.6
//                    }
//                )
//                self.add(number_plane)
//
//    .. manim:: NumberPlaneScaled
//        :save_last_frame:
//
//        open class NumberPlaneScaled(Scene):
//            def construct(self):
//                number_plane = NumberPlane(
//                    x_range=(-4, 11, 1),
//                    y_range=(-3, 3, 1),
//                    x_length=5,
//                    y_length=2,
//                ).move_to(LEFT*3)
//
//                number_plane_scaled_y = NumberPlane(
//                    x_range=(-4, 11, 1),
//                    x_length=5,
//                    y_length=4,
//                ).move_to(RIGHT*3)
//
//                self.add(number_plane)
//                self.add(number_plane_scaled_y)
//    """


open class PolarPlane : Axes()
//    r"""Creates a polar plane with background lines.
//
//    Parameters
//    ----------
//    azimuth_step
//        The number of divisions in the azimuth (also known as the `angular coordinate` or `polar angle`). If ``None`` is specified then it will use the default
//        specified by ``azimuth_units``:
//
//        - ``"PI radians"`` or ``"TAU radians"``: 20
//        - ``"degrees"``: 36
//        - ``"gradians"``: 40
//        - ``None``: 1
//
//        A non-integer value will result in a partial division at the end of the circle.
//
//    size
//        The diameter of the plane.
//
//    radius_step
//        The distance between faded radius lines.
//
//    radius_max
//        The maximum value of the radius.
//
//    azimuth_units
//        Specifies a default labelling system for the azimuth. Choices are:
//
//        - ``"PI radians"``: Fractional labels in the interval :math:`\left[0, 2\pi\right]` with :math:`\pi` as a constant.
//        - ``"TAU radians"``: Fractional labels in the interval :math:`\left[0, \tau\right]` (where :math:`\tau = 2\pi`) with :math:`\tau` as a constant.
//        - ``"degrees"``: Decimal labels in the interval :math:`\left[0, 360\right]` with a degree (:math:`^{\circ}`) symbol.
//        - ``"gradians"``: Decimal labels in the interval :math:`\left[0, 400\right]` with a superscript "g" (:math:`^{g}`).
//        - ``None``: Decimal labels in the interval :math:`\left[0, 1\right]`.
//
//    azimuth_compact_fraction
//        If the ``azimuth_units`` choice has fractional labels, choose whether to
//        combine the constant in a compact form :math:`\tfrac{xu}{y}` as opposed to
//        :math:`\tfrac{x}{y}u`, where :math:`u` is the constant.
//
//    azimuth_offset
//        The angle offset of the azimuth, expressed in radians.
//
//    azimuth_direction
//        The direction of the azimuth.
//
//        - ``"CW"``: Clockwise.
//        - ``"CCW"``: Anti-clockwise.
//
//    azimuth_label_buff
//        The buffer for the azimuth labels.
//
//    azimuth_label_font_size
//        The font size of the azimuth labels.
//
//    radius_config
//        The axis config for the radius.
//
//    Examples
//    --------
//    .. manim:: PolarPlaneExample
//        :ref_open classes: PolarPlane
//        :save_last_frame:
//
//        open class PolarPlaneExample(Scene):
//            def construct(self):
//                polarplane_pi = PolarPlane(
//                    azimuth_units="PI radians",
//                    size=6,
//                    azimuth_label_font_size=33.6,
//                    radius_config={"font_size": 33.6},
//                ).add_coordinates()
//                self.add(polarplane_pi)
//    """


open class ComplexPlane : NumberPlane()
//    """A :open class:`~.NumberPlane` specialized for use with complex numbers.
//
//    Examples
//    --------
//    .. manim:: ComplexPlaneExample
//        :save_last_frame:
//        :ref_open classes: Dot MathTex
//
//        open class ComplexPlaneExample(Scene):
//            def construct(self):
//                plane = ComplexPlane().add_coordinates()
//                self.add(plane)
//                d1 = Dot(plane.n2p(2 + 1j), color=YELLOW)
//                d2 = Dot(plane.n2p(-3 - 2j), color=YELLOW)
//                label1 = MathTex("2+i").next_to(d1, UR, 0.1)
//                label2 = MathTex("-3-2i").next_to(d2, UR, 0.1)
//                self.add(
//                    d1,
//                    label1,
//                    d2,
//                    label2,
//                )
//
//    """
