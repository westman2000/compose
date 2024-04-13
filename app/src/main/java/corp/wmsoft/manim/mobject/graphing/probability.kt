package corp.wmsoft.manim.mobject.graphing

import corp.wmsoft.manim.mobject.geometry.Rectangle

//"""Mobjects representing objects from probability theory and statistics."""



open class SampleSpace : Rectangle()
//    """A mobject representing a twodimensional rectangular
//    sampling space.
//
//    Examples
//    --------
//    .. manim:: ExampleSampleSpace
//        :save_last_frame:
//
//        open class ExampleSampleSpace(Scene):
//            def construct(self):
//                poly1 = SampleSpace(stroke_width=15, fill_opacity=1)
//                poly2 = SampleSpace(width=5, height=3, stroke_width=5, fill_opacity=0.5)
//                poly3 = SampleSpace(width=2, height=2, stroke_width=5, fill_opacity=0.1)
//                poly3.divide_vertically(p_list=np.array([0.37, 0.13, 0.5]), colors=[BLACK, WHITE, GRAY], vect=RIGHT)
//                poly_group = VGroup(poly1, poly2, poly3).arrange()
//                self.add(poly_group)
//    """


open class BarChart : Axes()
//    """Creates a bar chart. Inherits from :open class:`~.Axes`, so it shares its methods
//    and attributes. Each axis inherits from :open class:`~.NumberLine`, so pass in ``x_axis_config``/``y_axis_config``
//    to control their attributes.
//
//    Parameters
//    ----------
//    values
//        A sequence of values that determines the height of each bar. Accepts negative values.
//    bar_names
//        A sequence of names for each bar. Does not have to match the length of ``values``.
//    y_range
//        The y_axis range of values. If ``None``, the range will be calculated based on the
//        min/max of ``values`` and the step will be calculated based on ``y_length``.
//    x_length
//        The length of the x-axis. If ``None``, it is automatically calculated based on
//        the number of values and the width of the screen.
//    y_length
//        The length of the y-axis.
//    bar_colors
//        The color for the bars. Accepts a sequence of colors (can contain just one item).
//        If the length of``bar_colors`` does not match that of ``values``,
//        intermediate colors will be automatically determined.
//    bar_width
//        The length of a bar. Must be between 0 and 1.
//    bar_fill_opacity
//        The fill opacity of the bars.
//    bar_stroke_width
//        The stroke width of the bars.
//
//    Examples
//    --------
//    .. manim:: BarChartExample
//        :save_last_frame:
//
//        open class BarChartExample(Scene):
//            def construct(self):
//                chart = BarChart(
//                    values=[-5, 40, -10, 20, -3],
//                    bar_names=["one", "two", "three", "four", "five"],
//                    y_range=[-20, 50, 10],
//                    y_length=6,
//                    x_length=10,
//                    x_axis_config={"font_size": 36},
//                )
//
//                c_bar_lbls = chart.get_bar_labels(font_size=48)
//
//                self.add(chart, c_bar_lbls)
//    """
