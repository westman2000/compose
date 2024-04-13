package corp.wmsoft.manim.mobject

import corp.wmsoft.manim.mobject.types.VGroup

//"""Mobjects representing vector fields."""

open class VectorField : VGroup()
//    """A vector field.
//
//    Vector fields are based on a function defining a vector at every position.
//    This class does by default not include any visible elements but provides
//    methods to move other :class:`~.Mobject` s along the vector field.
//
//    Parameters
//    ----------
//    func
//        The function defining the rate of change at every position of the `VectorField`.
//    color
//        The color of the vector field. If set, position-specific coloring is disabled.
//    color_scheme
//        A function mapping a vector to a single value. This value gives the position in the color gradient defined using `min_color_scheme_value`, `max_color_scheme_value` and `colors`.
//    min_color_scheme_value
//        The value of the color_scheme function to be mapped to the first color in `colors`. Lower values also result in the first color of the gradient.
//    max_color_scheme_value
//        The value of the color_scheme function to be mapped to the last color in `colors`. Higher values also result in the last color of the gradient.
//    colors
//        The colors defining the color gradient of the vector field.
//    kwargs
//        Additional arguments to be passed to the :class:`~.VGroup` constructor
//
//    """


open class ArrowVectorField : VectorField()
//    """A :class:`VectorField` represented by a set of change vectors.
//
//    Vector fields are always based on a function defining the :class:`~.Vector` at every position.
//    The values of this functions is displayed as a grid of vectors.
//    By default the color of each vector is determined by it's magnitude.
//    Other color schemes can be used however.
//
//    Parameters
//    ----------
//    func
//        The function defining the rate of change at every position of the vector field.
//    color
//        The color of the vector field. If set, position-specific coloring is disabled.
//    color_scheme
//        A function mapping a vector to a single value. This value gives the position in the color gradient defined using `min_color_scheme_value`, `max_color_scheme_value` and `colors`.
//    min_color_scheme_value
//        The value of the color_scheme function to be mapped to the first color in `colors`. Lower values also result in the first color of the gradient.
//    max_color_scheme_value
//        The value of the color_scheme function to be mapped to the last color in `colors`. Higher values also result in the last color of the gradient.
//    colors
//        The colors defining the color gradient of the vector field.
//    x_range
//        A sequence of x_min, x_max, delta_x
//    y_range
//        A sequence of y_min, y_max, delta_y
//    z_range
//        A sequence of z_min, z_max, delta_z
//    three_dimensions
//        Enables three_dimensions. Default set to False, automatically turns True if
//        z_range is not None.
//    length_func
//        The function determining the displayed size of the vectors. The actual size
//        of the vector is passed, the returned value will be used as display size for the
//        vector. By default this is used to cap the displayed size of vectors to reduce the clutter.
//    opacity
//        The opacity of the arrows.
//    vector_config
//        Additional arguments to be passed to the :class:`~.Vector` constructor
//    kwargs
//        Additional arguments to be passed to the :class:`~.VGroup` constructor
//
//    Examples
//    --------
//
//    .. manim:: BasicUsage
//        :save_last_frame:
//
//        class BasicUsage(Scene):
//            def construct(self):
//                func = lambda pos: ((pos[0] * UR + pos[1] * LEFT) - pos) / 3
//                self.add(ArrowVectorField(func))
//
//    .. manim:: SizingAndSpacing
//
//        class SizingAndSpacing(Scene):
//            def construct(self):
//                func = lambda pos: np.sin(pos[0] / 2) * UR + np.cos(pos[1] / 2) * LEFT
//                vf = ArrowVectorField(func, x_range=[-7, 7, 1])
//                self.add(vf)
//                self.wait()
//
//                length_func = lambda x: x / 3
//                vf2 = ArrowVectorField(func, x_range=[-7, 7, 1], length_func=length_func)
//                self.play(vf.animate.become(vf2))
//                self.wait()
//
//    .. manim:: Coloring
//        :save_last_frame:
//
//        class Coloring(Scene):
//            def construct(self):
//                func = lambda pos: pos - LEFT * 5
//                colors = [RED, YELLOW, BLUE, DARK_GRAY]
//                min_radius = Circle(radius=2, color=colors[0]).shift(LEFT * 5)
//                max_radius = Circle(radius=10, color=colors[-1]).shift(LEFT * 5)
//                vf = ArrowVectorField(
//                    func, min_color_scheme_value=2, max_color_scheme_value=10, colors=colors
//                )
//                self.add(vf, min_radius, max_radius)
//
//    """


open class StreamLines : VectorField()
//    """StreamLines represent the flow of a :class:`VectorField` using the trace of moving agents.
//
//    Vector fields are always based on a function defining the vector at every position.
//    The values of this functions is displayed by moving many agents along the vector field
//    and showing their trace.
//
//    Parameters
//    ----------
//    func
//        The function defining the rate of change at every position of the vector field.
//    color
//        The color of the vector field. If set, position-specific coloring is disabled.
//    color_scheme
//        A function mapping a vector to a single value. This value gives the position in the color gradient defined using `min_color_scheme_value`, `max_color_scheme_value` and `colors`.
//    min_color_scheme_value
//        The value of the color_scheme function to be mapped to the first color in `colors`. Lower values also result in the first color of the gradient.
//    max_color_scheme_value
//        The value of the color_scheme function to be mapped to the last color in `colors`. Higher values also result in the last color of the gradient.
//    colors
//        The colors defining the color gradient of the vector field.
//    x_range
//        A sequence of x_min, x_max, delta_x
//    y_range
//        A sequence of y_min, y_max, delta_y
//    z_range
//        A sequence of z_min, z_max, delta_z
//    three_dimensions
//        Enables three_dimensions. Default set to False, automatically turns True if
//        z_range is not None.
//    noise_factor
//        The amount by which the starting position of each agent is altered along each axis. Defaults to :code:`delta_y / 2` if not defined.
//    n_repeats
//        The number of agents generated at each starting point.
//    dt
//        The factor by which the distance an agent moves per step is stretched. Lower values result in a better approximation of the trajectories in the vector field.
//    virtual_time
//        The time the agents get to move in the vector field. Higher values therefore result in longer stream lines. However, this whole time gets simulated upon creation.
//    max_anchors_per_line
//        The maximum number of anchors per line. Lines with more anchors get reduced in complexity, not in length.
//    padding
//        The distance agents can move out of the generation area before being terminated.
//    stroke_width
//        The stroke with of the stream lines.
//    opacity
//        The opacity of the stream lines.
//
//    Examples
//    --------
//
//    .. manim:: BasicUsage
//        :save_last_frame:
//
//        class BasicUsage(Scene):
//            def construct(self):
//                func = lambda pos: ((pos[0] * UR + pos[1] * LEFT) - pos) / 3
//                self.add(StreamLines(func))
//
//    .. manim:: SpawningAndFlowingArea
//        :save_last_frame:
//
//        class SpawningAndFlowingArea(Scene):
//            def construct(self):
//                func = lambda pos: np.sin(pos[0]) * UR + np.cos(pos[1]) * LEFT + pos / 5
//                stream_lines = StreamLines(
//                    func, x_range=[-3, 3, 0.2], y_range=[-2, 2, 0.2], padding=1
//                )
//
//                spawning_area = Rectangle(width=6, height=4)
//                flowing_area = Rectangle(width=8, height=6)
//                labels = [Tex("Spawning Area"), Tex("Flowing Area").shift(DOWN * 2.5)]
//                for lbl in labels:
//                    lbl.add_background_rectangle(opacity=0.6, buff=0.05)
//
//                self.add(stream_lines, spawning_area, flowing_area, *labels)
//
//    """
