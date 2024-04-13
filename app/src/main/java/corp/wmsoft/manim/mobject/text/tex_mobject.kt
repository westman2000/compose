package corp.wmsoft.manim.mobject.text

import corp.wmsoft.manim.mobject.svg.SVGMobject

//r"""Mobjects representing text rendered using LaTeX.
//
//.. important::
//
//   See the corresponding tutorial :ref:`rendering-with-latex`
//
//.. note::
//
//   Just as you can use :open class:`~.Text` (from the module :mod:`~.text_mobject`) to add text to your videos, you can use :open class:`~.Tex` and :open class:`~.MathTex` to insert LaTeX.
//
//"""


open class SingleStringMathTex : SVGMobject()
//    """Elementary building block for rendering text with LaTeX.
//
//    Tests
//    -----
//    Check that creating a :open class:`~.SingleStringMathTex` object works::
//
//        >>> SingleStringMathTex('Test') # doctest: +SKIP
//        SingleStringMathTex('Test')
//    """


open class MathTex : SingleStringMathTex()
//    r"""A string compiled with LaTeX in math mode.
//
//    Examples
//    --------
//    .. manim:: Formula
//        :save_last_frame:
//
//        open class Formula(Scene):
//            def construct(self):
//                t = MathTex(r"\int_a^b f'(x) dx = f(b)- f(a)")
//                self.add(t)
//
//    Tests
//    -----
//    Check that creating a :open class:`~.MathTex` works::
//
//        >>> MathTex('a^2 + b^2 = c^2') # doctest: +SKIP
//        MathTex('a^2 + b^2 = c^2')
//
//    Check that double brace group splitting works correctly::
//
//        >>> t1 = MathTex('{{ a }} + {{ b }} = {{ c }}') # doctest: +SKIP
//        >>> len(t1.submobjects) # doctest: +SKIP
//        5
//        >>> t2 = MathTex(r"\frac{1}{a+b\sqrt{2}}") # doctest: +SKIP
//        >>> len(t2.submobjects) # doctest: +SKIP
//        1
//
//    """


open class Tex : MathTex()
//    r"""A string compiled with LaTeX in normal mode.
//
//    Tests
//    -----
//
//    Check whether writing a LaTeX string works::
//
//        >>> Tex('The horse does not eat cucumber salad.') # doctest: +SKIP
//        Tex('The horse does not eat cucumber salad.')
//
//    """

open class BulletedList : Tex()
//    """A bulleted list.
//
//    Examples
//    --------
//
//    .. manim:: BulletedListExample
//        :save_last_frame:
//
//        open class BulletedListExample(Scene):
//            def construct(self):
//                blist = BulletedList("Item 1", "Item 2", "Item 3", height=2, width=2)
//                blist.set_color_by_tex("Item 1", RED)
//                blist.set_color_by_tex("Item 2", GREEN)
//                blist.set_color_by_tex("Item 3", BLUE)
//                self.add(blist)
//    """


open class Title : Tex()
//    """A mobject representing an underlined title.
//
//    Examples
//    --------
//    .. manim:: TitleExample
//        :save_last_frame:
//
//        import manim
//
//        open class TitleExample(Scene):
//            def construct(self):
//                banner = ManimBanner()
//                title = Title(f"Manim version {manim.__version__}")
//                self.add(banner, title)
//
//    """
