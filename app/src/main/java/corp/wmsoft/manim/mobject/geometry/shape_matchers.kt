package corp.wmsoft.manim.mobject.geometry

import corp.wmsoft.manim.mobject.types.VGroup

//"""Mobjects used to mark and annotate other mobjects."""

open class SurroundingRectangle : RoundedRectangle()
//    r"""A rectangle surrounding a :class:`~.Mobject`
//
//    Examples
//    --------
//    .. manim:: SurroundingRectExample
//        :save_last_frame:
//
//        class SurroundingRectExample(Scene):
//            def construct(self):
//                title = Title("A Quote from Newton")
//                quote = Text(
//                    "If I have seen further than others, \n"
//                    "it is by standing upon the shoulders of giants.",
//                    color=BLUE,
//                ).scale(0.75)
//                box = SurroundingRectangle(quote, color=YELLOW, buff=MED_LARGE_BUFF)
//
//                t2 = Tex(r"Hello World").scale(1.5)
//                box2 = SurroundingRectangle(t2, corner_radius=0.2)
//                mobjects = VGroup(VGroup(box, quote), VGroup(t2, box2)).arrange(DOWN)
//                self.add(title, mobjects)
//    """


open class BackgroundRectangle : SurroundingRectangle()
//    """A background rectangle. Its default color is the background color
//    of the scene.
//
//    Examples
//    --------
//    .. manim:: ExampleBackgroundRectangle
//        :save_last_frame:
//
//        class ExampleBackgroundRectangle(Scene):
//            def construct(self):
//                circle = Circle().shift(LEFT)
//                circle.set_stroke(color=GREEN, width=20)
//                triangle = Triangle().shift(2 * RIGHT)
//                triangle.set_fill(PINK, opacity=0.5)
//                backgroundRectangle1 = BackgroundRectangle(circle, color=WHITE, fill_opacity=0.15)
//                backgroundRectangle2 = BackgroundRectangle(triangle, color=WHITE, fill_opacity=0.15)
//                self.add(backgroundRectangle1)
//                self.add(backgroundRectangle2)
//                self.add(circle)
//                self.add(triangle)
//                self.play(Rotate(backgroundRectangle1, PI / 4))
//                self.play(Rotate(backgroundRectangle2, PI / 2))
//    """


class Cross : VGroup()
//    """Creates a cross.
//
//    Parameters
//    ----------
//    mobject
//        The mobject linked to this instance. It fits the mobject when specified. Defaults to None.
//    stroke_color
//        Specifies the color of the cross lines. Defaults to RED.
//    stroke_width
//        Specifies the width of the cross lines. Defaults to 6.
//    scale_factor
//        Scales the cross to the provided units. Defaults to 1.
//
//    Examples
//    --------
//    .. manim:: ExampleCross
//        :save_last_frame:
//
//        class ExampleCross(Scene):
//            def construct(self):
//                cross = Cross()
//                self.add(cross)
//    """



class Underline : Line()
//    """Creates an underline.
//
//    Examples
//    --------
//    .. manim:: UnderLine
//        :save_last_frame:
//
//        class UnderLine(Scene):
//            def construct(self):
//                man = Tex("Manim")  # Full Word
//                ul = Underline(man)  # Underlining the word
//                self.add(man, ul)
//    """
