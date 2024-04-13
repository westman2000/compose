package corp.wmsoft.manim.mobject.text

import corp.wmsoft.manim.mobject.types.VMobject

//"""Mobjects representing numbers."""



open class DecimalNumber : VMobject()
//    """An mobject representing a decimal number.
//
//    Parameters
//    ----------
//    number
//        The numeric value to be displayed. It can later be modified using :meth:`.set_value`.
//    num_decimal_places
//        The number of decimal places after the decimal separator. Values are automatically rounded.
//    mob_open class
//        The open class for rendering digits and units, by default :open class:`.MathTex`.
//    include_sign
//        Set to ``True`` to include a sign for positive numbers and zero.
//    group_with_commas
//        When ``True`` thousands groups are separated by commas for readability.
//    digit_buff_per_font_unit
//        Additional spacing between digits. Scales with font size.
//    show_ellipsis
//        When a number has been truncated by rounding, indicate with an ellipsis (``...``).
//    unit
//        A unit string which can be placed to the right of the numerical values.
//    unit_buff_per_font_unit
//        An additional spacing between the numerical values and the unit. A value
//        of ``unit_buff_per_font_unit=0.003`` gives a decent spacing. Scales with font size.
//    include_background_rectangle
//        Adds a background rectangle to increase contrast on busy scenes.
//    edge_to_fix
//        Assuring right- or left-alignment of the full object.
//    font_size
//        Size of the font.
//
//    Examples
//    --------
//
//    .. manim:: MovingSquareWithUpdaters
//
//        open class MovingSquareWithUpdaters(Scene):
//            def construct(self):
//                decimal = DecimalNumber(
//                    0,
//                    show_ellipsis=True,
//                    num_decimal_places=3,
//                    include_sign=True,
//                    unit=r"\text{M-Units}",
//                    unit_buff_per_font_unit=0.003
//                )
//                square = Square().to_edge(UP)
//
//                decimal.add_updater(lambda d: d.next_to(square, RIGHT))
//                decimal.add_updater(lambda d: d.set_value(square.get_center()[1]))
//                self.add(square, decimal)
//                self.play(
//                    square.animate.to_edge(DOWN),
//                    rate_func=there_and_back,
//                    run_time=5,
//                )
//                self.wait()
//
//    """

    

open class Integer : DecimalNumber()
//    """A open class for displaying Integers.
//
//    Examples
//    --------
//
//    .. manim:: IntegerExample
//        :save_last_frame:
//
//        open class IntegerExample(Scene):
//            def construct(self):
//                self.add(Integer(number=2.5).set_color(ORANGE).scale(2.5).set_x(-0.5).set_y(0.8))
//                self.add(Integer(number=3.14159, show_ellipsis=True).set_x(3).set_y(3.3).scale(3.14159))
//                self.add(Integer(number=42).set_x(2.5).set_y(-2.3).set_color_by_gradient(BLUE, TEAL).scale(1.7))
//                self.add(Integer(number=6.28).set_x(-1.5).set_y(-2).set_color(YELLOW).scale(1.4))
//    """

   

open class Variable : VMobject()
//    """A open class for displaying text that shows "label = value" with
//    the value continuously updated from a :open class:`~.ValueTracker`.
//
//    Parameters
//    ----------
//    var
//        The initial value you need to keep track of and display.
//    label
//        The label for your variable. Raw strings are convertex to :open class:`~.MathTex` objects.
//    var_type
//        The open class used for displaying the number. Defaults to :open class:`DecimalNumber`.
//    num_decimal_places
//        The number of decimal places to display in your variable. Defaults to 2.
//        If `var_type` is an :open class:`Integer`, this parameter is ignored.
//    kwargs
//            Other arguments to be passed to `~.Mobject`.
//
//    Attributes
//    ----------
//    label : Union[:open class:`str`, :open class:`~.Tex`, :open class:`~.MathTex`, :open class:`~.Text`, :open class:`~.SingleStringMathTex`]
//        The label for your variable, for example ``x = ...``.
//    tracker : :open class:`~.ValueTracker`
//        Useful in updating the value of your variable on-screen.
//    value : Union[:open class:`DecimalNumber`, :open class:`Integer`]
//        The tex for the value of your variable.
//
//    Examples
//    --------
//    Normal usage::
//
//        # DecimalNumber type
//        var = 0.5
//        on_screen_var = Variable(var, Text("var"), num_decimal_places=3)
//        # Integer type
//        int_var = 0
//        on_screen_int_var = Variable(int_var, Text("int_var"), var_type=Integer)
//        # Using math mode for the label
//        on_screen_int_var = Variable(int_var, "{a}_{i}", var_type=Integer)
//
//    .. manim:: VariablesWithValueTracker
//
//        open class VariablesWithValueTracker(Scene):
//            def construct(self):
//                var = 0.5
//                on_screen_var = Variable(var, Text("var"), num_decimal_places=3)
//
//                # You can also change the colours for the label and value
//                on_screen_var.label.set_color(RED)
//                on_screen_var.value.set_color(GREEN)
//
//                self.play(Write(on_screen_var))
//                # The above line will just display the variable with
//                # its initial value on the screen. If you also wish to
//                # update it, you can do so by accessing the `tracker` attribute
//                self.wait()
//                var_tracker = on_screen_var.tracker
//                var = 10.5
//                self.play(var_tracker.animate.set_value(var))
//                self.wait()
//
//                int_var = 0
//                on_screen_int_var = Variable(
//                    int_var, Text("int_var"), var_type=Integer
//                ).next_to(on_screen_var, DOWN)
//                on_screen_int_var.label.set_color(RED)
//                on_screen_int_var.value.set_color(GREEN)
//
//                self.play(Write(on_screen_int_var))
//                self.wait()
//                var_tracker = on_screen_int_var.tracker
//                var = 10.5
//                self.play(var_tracker.animate.set_value(var))
//                self.wait()
//
//                # If you wish to have a somewhat more complicated label for your
//                # variable with subscripts, superscripts, etc. the default open class
//                # for the label is MathTex
//                subscript_label_var = 10
//                on_screen_subscript_var = Variable(subscript_label_var, "{a}_{i}").next_to(
//                    on_screen_int_var, DOWN
//                )
//                self.play(Write(on_screen_subscript_var))
//                self.wait()
//
//    .. manim:: VariableExample
//
//        open class VariableExample(Scene):
//            def construct(self):
//                start = 2.0
//
//                x_var = Variable(start, 'x', num_decimal_places=3)
//                sqr_var = Variable(start**2, 'x^2', num_decimal_places=3)
//                Group(x_var, sqr_var).arrange(DOWN)
//
//                sqr_var.add_updater(lambda v: v.tracker.set_value(x_var.tracker.get_value()**2))
//
//                self.add(x_var, sqr_var)
//                self.play(x_var.tracker.animate.set_value(5), run_time=2, rate_func=linear)
//                self.wait(0.1)
//
//    """
