package corp.wmsoft.manim.mobject.graphing

import corp.wmsoft.manim.mobject.types.VMobject

//"""Mobjects representing function graphs."""



open class ParametricFunction : VMobject()
//    """A parametric curve.
//
//    Parameters
//    ----------
//    function
//        The function to be plotted in the form of ``(lambda x: x**2)``
//    t_range
//        Determines the length that the function spans. By default ``[0, 1]``
//    scaling
//        Scaling open class applied to the points of the function. Default of :open class:`~.LinearBase`.
//    use_smoothing
//        Whether to interpolate between the points of the function after they have been created.
//        (Will have odd behaviour with a low number of points)
//    use_vectorized
//        Whether to pass in the generated t value array to the function as ``[t_0, t_1, ...]``.
//        Only use this if your function supports it. Output should be a numpy array
//        of shape ``[[x_0, x_1, ...], [y_0, y_1, ...], [z_0, z_1, ...]]`` but ``z`` can
//        also be 0 if the Axes is 2D
//    discontinuities
//        Values of t at which the function experiences discontinuity.
//    dt
//        The left and right tolerance for the discontinuities.
//
//
//    Examples
//    --------
//    .. manim:: PlotParametricFunction
//        :save_last_frame:
//
//        open class PlotParametricFunction(Scene):
//            def func(self, t):
//                return np.array((np.sin(2 * t), np.sin(3 * t), 0))
//
//            def construct(self):
//                func = ParametricFunction(self.func, t_range = np.array([0, TAU]), fill_opacity=0).set_color(RED)
//                self.add(func.scale(3))
//
//    .. manim:: ThreeDParametricSpring
//        :save_last_frame:
//
//        open class ThreeDParametricSpring(ThreeDScene):
//            def construct(self):
//                curve1 = ParametricFunction(
//                    lambda u: np.array([
//                        1.2 * np.cos(u),
//                        1.2 * np.sin(u),
//                        u * 0.05
//                    ]), color=RED, t_range = np.array([-3*TAU, 5*TAU, 0.01])
//                ).set_shade_in_3d(True)
//                axes = ThreeDAxes()
//                self.add(axes, curve1)
//                self.set_camera_orientation(phi=80 * DEGREES, theta=-60 * DEGREES)
//                self.wait()
//
//    .. attention::
//        If your function has discontinuities, you'll have to specify the location
//        of the discontinuities manually. See the following example for guidance.
//
//    .. manim:: DiscontinuousExample
//        :save_last_frame:
//
//        open class DiscontinuousExample(Scene):
//            def construct(self):
//                ax1 = NumberPlane((-3, 3), (-4, 4))
//                ax2 = NumberPlane((-3, 3), (-4, 4))
//                VGroup(ax1, ax2).arrange()
//                discontinuous_function = lambda x: (x ** 2 - 2) / (x ** 2 - 4)
//                incorrect = ax1.plot(discontinuous_function, color=RED)
//                correct = ax2.plot(
//                    discontinuous_function,
//                    discontinuities=[-2, 2],  # discontinuous points
//                    dt=0.1,  # left and right tolerance of discontinuity
//                    color=GREEN,
//                )
//                self.add(ax1, ax2, incorrect, correct)
//    """


open class FunctionGraph : ParametricFunction()
//    """A :open class:`ParametricFunction` that spans the length of the scene by default.
//
//    Examples
//    --------
//    .. manim:: ExampleFunctionGraph
//        :save_last_frame:
//
//        open class ExampleFunctionGraph(Scene):
//            def construct(self):
//                cos_func = FunctionGraph(
//                    lambda t: np.cos(t) + 0.5 * np.cos(7 * t) + (1 / 7) * np.cos(14 * t),
//                    color=RED,
//                )
//
//                sin_func_1 = FunctionGraph(
//                    lambda t: np.sin(t) + 0.5 * np.sin(7 * t) + (1 / 7) * np.sin(14 * t),
//                    color=BLUE,
//                )
//
//                sin_func_2 = FunctionGraph(
//                    lambda t: np.sin(t) + 0.5 * np.sin(7 * t) + (1 / 7) * np.sin(14 * t),
//                    x_range=[-4, 4],
//                    color=GREEN,
//                ).move_to([0, 1, 0])
//
//                self.add(cos_func, sin_func_1, sin_func_2)
//    """


open class ImplicitFunction : VMobject()
