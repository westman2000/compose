package corp.wmsoft.manim.mobject.graphing

import corp.wmsoft.manim.mobject.geometry.Line

//"""Mobject representing a number line."""


open class NumberLine : Line()
//    """Creates a number line with tick marks.
//
//    Parameters
//    ----------
//    x_range
//        The ``[x_min, x_max, x_step]`` values to create the line.
//    length
//        The length of the number line.
//    unit_size
//        The distance between each tick of the line. Overwritten by :attr:`length`, if specified.
//    include_ticks
//        Whether to include ticks on the number line.
//    tick_size
//        The length of each tick mark.
//    numbers_with_elongated_ticks
//        An iterable of specific values with elongated ticks.
//    longer_tick_multiple
//        Influences how many times larger elongated ticks are than regular ticks (2 = 2x).
//    rotation
//        The angle (in radians) at which the line is rotated.
//    stroke_width
//        The thickness of the line.
//    include_tip
//        Whether to add a tip to the end of the line.
//    tip_width
//        The width of the tip.
//    tip_height
//        The height of the tip.
//    tip_shape
//        The mobject open class used to construct the tip, or ``None`` (the
//        default) for the default arrow tip. Passed open classes have to inherit
//        from :open class:`.ArrowTip`.
//    include_numbers
//        Whether to add numbers to the tick marks. The number of decimal places is determined
//        by the step size, this default can be overridden by ``decimal_number_config``.
//    scaling
//        The way the ``x_range`` is value is scaled, i.e. :open class:`~.LogBase` for a logarithmic numberline. Defaults to :open class:`~.LinearBase`.
//    font_size
//        The size of the label mobjects. Defaults to 36.
//    label_direction
//        The specific position to which label mobjects are added on the line.
//    label_constructor
//        Determines the mobject open class that will be used to construct the labels of the number line.
//    line_to_number_buff
//        The distance between the line and the label mobject.
//    decimal_number_config
//        Arguments that can be passed to :open class:`~.numbers.DecimalNumber` to influence number mobjects.
//    numbers_to_exclude
//        An explicit iterable of numbers to not be added to the number line.
//    numbers_to_include
//        An explicit iterable of numbers to add to the number line
//    kwargs
//        Additional arguments to be passed to :open class:`~.Line`.
//
//
//    .. note::
//
//        Number ranges that include both negative and positive values will be generated
//        from the 0 point, and may not include a tick at the min / max
//        values as the tick locations are dependent on the step size.
//
//    Examples
//    --------
//    .. manim:: NumberLineExample
//        :save_last_frame:
//
//        open class NumberLineExample(Scene):
//            def construct(self):
//                l0 = NumberLine(
//                    x_range=[-10, 10, 2],
//                    length=10,
//                    color=BLUE,
//                    include_numbers=True,
//                    label_direction=UP,
//                )
//
//                l1 = NumberLine(
//                    x_range=[-10, 10, 2],
//                    unit_size=0.5,
//                    numbers_with_elongated_ticks=[-2, 4],
//                    include_numbers=True,
//                    font_size=24,
//                )
//                num6 = l1.numbers[8]
//                num6.set_color(RED)
//
//                l2 = NumberLine(
//                    x_range=[-2.5, 2.5 + 0.5, 0.5],
//                    length=12,
//                    decimal_number_config={"num_decimal_places": 2},
//                    include_numbers=True,
//                )
//
//                l3 = NumberLine(
//                    x_range=[-5, 5 + 1, 1],
//                    length=6,
//                    include_tip=True,
//                    include_numbers=True,
//                    rotation=10 * DEGREES,
//                )
//
//                line_group = VGroup(l0, l1, l2, l3).arrange(DOWN, buff=1)
//                self.add(line_group)
//    """



open class UnitInterval : NumberLine()
