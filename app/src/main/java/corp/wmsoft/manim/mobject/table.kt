package corp.wmsoft.manim.mobject

import corp.wmsoft.manim.mobject.types.VGroup

//r"""Mobjects representing tables.

//Examples
//--------
//
//.. manim:: TableExamples
//    :save_last_frame:
//
//    class TableExamples(Scene):
//        def construct(self):
//            t0 = Table(
//                [["First", "Second"],
//                ["Third","Fourth"]],
//                row_labels=[Text("R1"), Text("R2")],
//                col_labels=[Text("C1"), Text("C2")],
//                top_left_entry=Text("TOP"))
//            t0.add_highlighted_cell((2,2), color=GREEN)
//            x_vals = np.linspace(-2,2,5)
//            y_vals = np.exp(x_vals)
//            t1 = DecimalTable(
//                [x_vals, y_vals],
//                row_labels=[MathTex("x"), MathTex("f(x)")],
//                include_outer_lines=True)
//            t1.add(t1.get_cell((2,2), color=RED))
//            t2 = MathTable(
//                [["+", 0, 5, 10],
//                [0, 0, 5, 10],
//                [2, 2, 7, 12],
//                [4, 4, 9, 14]],
//                include_outer_lines=True)
//            t2.get_horizontal_lines()[:3].set_color(BLUE)
//            t2.get_vertical_lines()[:3].set_color(BLUE)
//            t2.get_horizontal_lines()[:3].set_z_index(1)
//            cross = VGroup(
//                Line(UP + LEFT, DOWN + RIGHT),
//                Line(UP + RIGHT, DOWN + LEFT))
//            a = Circle().set_color(RED).scale(0.5)
//            b = cross.set_color(BLUE).scale(0.5)
//            t3 = MobjectTable(
//                [[a.copy(),b.copy(),a.copy()],
//                [b.copy(),a.copy(),a.copy()],
//                [a.copy(),b.copy(),b.copy()]])
//            t3.add(Line(
//                t3.get_corner(DL), t3.get_corner(UR)
//            ).set_color(RED))
//            vals = np.arange(1,21).reshape(5,4)
//            t4 = IntegerTable(
//                vals,
//                include_outer_lines=True
//            )
//            g1 = Group(t0, t1).scale(0.5).arrange(buff=1).to_edge(UP, buff=1)
//            g2 = Group(t2, t3, t4).scale(0.5).arrange(buff=1).to_edge(DOWN, buff=1)
//            self.add(g1, g2)
//"""


open class Table : VGroup()
//    """A mobject that displays a table on the screen.
//
//    Parameters
//    ----------
//    table
//        A 2D array or list of lists. Content of the table has to be a valid input
//        for the callable set in ``element_to_mobject``.
//    row_labels
//        List of :class:`~.VMobject` representing the labels of each row.
//    col_labels
//        List of :class:`~.VMobject` representing the labels of each column.
//    top_left_entry
//        The top-left entry of the table, can only be specified if row and
//        column labels are given.
//    v_buff
//        Vertical buffer passed to :meth:`~.Mobject.arrange_in_grid`, by default 0.8.
//    h_buff
//        Horizontal buffer passed to :meth:`~.Mobject.arrange_in_grid`, by default 1.3.
//    include_outer_lines
//        ``True`` if the table should include outer lines, by default False.
//    add_background_rectangles_to_entries
//        ``True`` if background rectangles should be added to entries, by default ``False``.
//    entries_background_color
//        Background color of entries if ``add_background_rectangles_to_entries`` is ``True``.
//    include_background_rectangle
//        ``True`` if the table should have a background rectangle, by default ``False``.
//    background_rectangle_color
//        Background color of table if ``include_background_rectangle`` is ``True``.
//    element_to_mobject
//        The :class:`~.Mobject` class applied to the table entries. by default :class:`~.Paragraph`. For common choices, see :mod:`~.text_mobject`/:mod:`~.tex_mobject`.
//    element_to_mobject_config
//        Custom configuration passed to :attr:`element_to_mobject`, by default {}.
//    arrange_in_grid_config
//        Dict passed to :meth:`~.Mobject.arrange_in_grid`, customizes the arrangement of the table.
//    line_config
//        Dict passed to :class:`~.Line`, customizes the lines of the table.
//    kwargs
//        Additional arguments to be passed to :class:`~.VGroup`.
//
//    Examples
//    --------
//
//    .. manim:: TableExamples
//        :save_last_frame:
//
//        class TableExamples(Scene):
//            def construct(self):
//                t0 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table in \\n Manim."]])
//                t1 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table."]],
//                    row_labels=[Text("R1"), Text("R2")],
//                    col_labels=[Text("C1"), Text("C2")])
//                t1.add_highlighted_cell((2,2), color=YELLOW)
//                t2 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table."]],
//                    row_labels=[Text("R1"), Text("R2")],
//                    col_labels=[Text("C1"), Text("C2")],
//                    top_left_entry=Star().scale(0.3),
//                    include_outer_lines=True,
//                    arrange_in_grid_config={"cell_alignment": RIGHT})
//                t2.add(t2.get_cell((2,2), color=RED))
//                t3 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table."]],
//                    row_labels=[Text("R1"), Text("R2")],
//                    col_labels=[Text("C1"), Text("C2")],
//                    top_left_entry=Star().scale(0.3),
//                    include_outer_lines=True,
//                    line_config={"stroke_width": 1, "color": YELLOW})
//                t3.remove(*t3.get_vertical_lines())
//                g = Group(
//                    t0,t1,t2,t3
//                ).scale(0.7).arrange_in_grid(buff=1)
//                self.add(g)
//
//    .. manim:: BackgroundRectanglesExample
//        :save_last_frame:
//
//        class BackgroundRectanglesExample(Scene):
//            def construct(self):
//                background = Rectangle(height=6.5, width=13)
//                background.set_fill(opacity=.5)
//                background.set_color([TEAL, RED, YELLOW])
//                self.add(background)
//                t0 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table."]],
//                    add_background_rectangles_to_entries=True)
//                t1 = Table(
//                    [["This", "is a"],
//                    ["simple", "Table."]],
//                    include_background_rectangle=True)
//                g = Group(t0, t1).scale(0.7).arrange(buff=0.5)
//                self.add(g)
//    """

open class MathTable : Table()
//    """A specialized :class:`~.Table` mobject for use with LaTeX.
//
//    Examples
//    --------
//
//    .. manim:: MathTableExample
//        :save_last_frame:
//
//        class MathTableExample(Scene):
//            def construct(self):
//                t0 = MathTable(
//                    [["+", 0, 5, 10],
//                    [0, 0, 5, 10],
//                    [2, 2, 7, 12],
//                    [4, 4, 9, 14]],
//                    include_outer_lines=True)
//                self.add(t0)
//    """

open class MobjectTable : Table()
//    """A specialized :class:`~.Table` mobject for use with :class:`~.Mobject`.
//
//    Examples
//    --------
//
//    .. manim:: MobjectTableExample
//        :save_last_frame:
//
//        class MobjectTableExample(Scene):
//            def construct(self):
//                cross = VGroup(
//                    Line(UP + LEFT, DOWN + RIGHT),
//                    Line(UP + RIGHT, DOWN + LEFT),
//                )
//                a = Circle().set_color(RED).scale(0.5)
//                b = cross.set_color(BLUE).scale(0.5)
//                t0 = MobjectTable(
//                    [[a.copy(),b.copy(),a.copy()],
//                    [b.copy(),a.copy(),a.copy()],
//                    [a.copy(),b.copy(),b.copy()]]
//                )
//                line = Line(
//                    t0.get_corner(DL), t0.get_corner(UR)
//                ).set_color(RED)
//                self.add(t0, line)
//    """


open class IntegerTable : Table()
//    """A specialized :class:`~.Table` mobject for use with :class:`~.Integer`.
//
//    Examples
//    --------
//
//    .. manim:: IntegerTableExample
//        :save_last_frame:
//
//        class IntegerTableExample(Scene):
//            def construct(self):
//                t0 = IntegerTable(
//                    [[0,30,45,60,90],
//                    [90,60,45,30,0]],
//                    col_labels=[
//                        MathTex("\\\\frac{\\sqrt{0}}{2}"),
//                        MathTex("\\\\frac{\\sqrt{1}}{2}"),
//                        MathTex("\\\\frac{\\sqrt{2}}{2}"),
//                        MathTex("\\\\frac{\\sqrt{3}}{2}"),
//                        MathTex("\\\\frac{\\sqrt{4}}{2}")],
//                    row_labels=[MathTex("\\sin"), MathTex("\\cos")],
//                    h_buff=1,
//                    element_to_mobject_config={"unit": "^{\\circ}"})
//                self.add(t0)
//    """


class DecimalTable : Table()
//    """A specialized :class:`~.Table` mobject for use with :class:`~.DecimalNumber` to display decimal entries.
//
//    Examples
//    --------
//
//    .. manim:: DecimalTableExample
//        :save_last_frame:
//
//        class DecimalTableExample(Scene):
//            def construct(self):
//                x_vals = [-2,-1,0,1,2]
//                y_vals = np.exp(x_vals)
//                t0 = DecimalTable(
//                    [x_vals, y_vals],
//                    row_labels=[MathTex("x"), MathTex("f(x)=e^{x}")],
//                    h_buff=1,
//                    element_to_mobject_config={"num_decimal_places": 2})
//                self.add(t0)
//    """
