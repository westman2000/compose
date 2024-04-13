package corp.wmsoft.manim.mobject

import corp.wmsoft.manim.mobject.types.VMobject

//"""Mobjects representing matrices.

//Examples
//--------
//
//.. manim:: MatrixExamples
//    :save_last_frame:
//
//    class MatrixExamples(Scene):
//        def construct(self):
//            m0 = _—Matrix([["\\pi", 0], [-1, 1]])
//            m1 = IntegerMatrix([[1.5, 0.], [12, -1.3]],
//                left_bracket="(",
//                right_bracket=")")
//            m2 = DecimalMatrix(
//                [[3.456, 2.122], [33.2244, 12.33]],
//                element_to_mobject_config={"num_decimal_places": 2},
//                left_bracket="\\{",
//                right_bracket="\\}")
//            m3 = MobjectMatrix(
//                [[Circle().scale(0.3), Square().scale(0.3)],
//                [MathTex("\\pi").scale(2), Star().scale(0.3)]],
//                left_bracket="\\langle",
//                right_bracket="\\rangle")
//            g = Group(m0, m1, m2, m3).arrange_in_grid(buff=2)
//            self.add(g)
//"""


open class Matrix : VMobject()
//    """A mobject that displays a matrix on the screen.
//
//    Parameters
//    ----------
//    matrix
//        A numpy 2d array or list of lists.
//    v_buff
//        Vertical distance between elements, by default 0.8.
//    h_buff
//        Horizontal distance between elements, by default 1.3.
//    bracket_h_buff
//        Distance of the brackets from the matrix, by default ``MED_SMALL_BUFF``.
//    bracket_v_buff
//        Height of the brackets, by default ``MED_SMALL_BUFF``.
//    add_background_rectangles_to_entries
//        ``True`` if should add backgraound rectangles to entries, by default ``False``.
//    include_background_rectangle
//        ``True`` if should include background rectangle, by default ``False``.
//    element_to_mobject
//        The mobject class used to construct the elements, by default :class:`~.MathTex`.
//    element_to_mobject_config
//        Additional arguments to be passed to the constructor in ``element_to_mobject``,
//        by default ``{}``.
//    element_alignment_corner
//        The corner to which elements are aligned, by default ``DR``.
//    left_bracket
//        The left bracket type, by default ``"["``.
//    right_bracket
//        The right bracket type, by default ``"]"``.
//    stretch_brackets
//        ``True`` if should stretch the brackets to fit the height of matrix contents, by default ``True``.
//    bracket_config
//        Additional arguments to be passed to :class:`~.MathTex` when constructing
//        the brackets.
//
//    Examples
//    --------
//    The first example shows a variety of uses of this module while the second example
//    exlpains the use of the options `add_background_rectangles_to_entries` and
//    `include_background_rectangle`.
//
//    .. manim:: MatrixExamples
//        :save_last_frame:
//
//        class MatrixExamples(Scene):
//            def construct(self):
//                m0 = Matrix([[2, "\\pi"], [-1, 1]])
//                m1 = Matrix([[2, 0, 4], [-1, 1, 5]],
//                    v_buff=1.3,
//                    h_buff=0.8,
//                    bracket_h_buff=SMALL_BUFF,
//                    bracket_v_buff=SMALL_BUFF,
//                    left_bracket="\\{",
//                    right_bracket="\\}")
//                m1.add(SurroundingRectangle(m1.get_columns()[1]))
//                m2 = Matrix([[2, 1], [-1, 3]],
//                    element_alignment_corner=UL,
//                    left_bracket="(",
//                    right_bracket=")")
//                m3 = Matrix([[2, 1], [-1, 3]],
//                    left_bracket="\\\\langle",
//                    right_bracket="\\\\rangle")
//                m4 = Matrix([[2, 1], [-1, 3]],
//                ).set_column_colors(RED, GREEN)
//                m5 = Matrix([[2, 1], [-1, 3]],
//                ).set_row_colors(RED, GREEN)
//                g = Group(
//                    m0,m1,m2,m3,m4,m5
//                ).arrange_in_grid(buff=2)
//                self.add(g)
//
//    .. manim:: BackgroundRectanglesExample
//        :save_last_frame:
//
//        class BackgroundRectanglesExample(Scene):
//            def construct(self):
//                background= Rectangle().scale(3.2)
//                background.set_fill(opacity=.5)
//                background.set_color([TEAL, RED, YELLOW])
//                self.add(background)
//                m0 = Matrix([[12, -30], [-1, 15]],
//                    add_background_rectangles_to_entries=True)
//                m1 = Matrix([[2, 0], [-1, 1]],
//                    include_background_rectangle=True)
//                m2 = Matrix([[12, -30], [-1, 15]])
//                g = Group(m0, m1, m2).arrange(buff=2)
//                self.add(g)
//    """


open class DecimalMatrix : Matrix()
//    """A mobject that displays a matrix with decimal entries on the screen.
//
//    Examples
//    --------
//
//    .. manim:: DecimalMatrixExample
//        :save_last_frame:
//
//        class DecimalMatrixExample(Scene):
//            def construct(self):
//                m0 = DecimalMatrix(
//                    [[3.456, 2.122], [33.2244, 12]],
//                    element_to_mobject_config={"num_decimal_places": 2},
//                    left_bracket="\\{",
//                    right_bracket="\\}")
//                self.add(m0)
//    """


open class IntegerMatrix : Matrix()
//    """A mobject that displays a matrix with integer entries on the screen.
//
//    Examples
//    --------
//
//    .. manim:: IntegerMatrixExample
//        :save_last_frame:
//
//        class IntegerMatrixExample(Scene):
//            def construct(self):
//                m0 = IntegerMatrix(
//                    [[3.7, 2], [42.2, 12]],
//                    left_bracket="(",
//                    right_bracket=")")
//                self.add(m0)
//    """

open class MobjectMatrix : Matrix()
//    """A mobject that displays a matrix of mobject entries on the screen.
//
//    Examples
//    --------
//
//    .. manim:: MobjectMatrixExample
//        :save_last_frame:
//
//        class MobjectMatrixExample(Scene):
//            def construct(self):
//                a = Circle().scale(0.3)
//                b = Square().scale(0.3)
//                c = MathTex("\\pi").scale(2)
//                d = Star().scale(0.3)
//                m0 = MobjectMatrix([[a, b], [c, d]])
//                self.add(m0)
//    """
