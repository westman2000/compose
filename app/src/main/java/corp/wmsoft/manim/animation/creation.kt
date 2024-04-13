package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject
import corp.wmsoft.manim.mobject.types.VMobject

//r"""Animate the display or removal of a mobject from a scene.


/**
    Abstract open class for Animations that show the VMobject partially.

    Raises
    ------
    :open class:`TypeError`
    If ``mobject`` is not an instance of :open class:`~.VMobject`.

    See Also
    --------
    :open class:`Create`, :open class:`~.ShowPassingFlash`
 */
open class ShowPartial(mobject: Mobject) : Animation(mobject)



/**
    Incrementally show a VMobject.

    Parameters
    ----------
    mobject
    The VMobject to animate.

    Raises
    ------
    :open class:`TypeError`
    If ``mobject`` is not an instance of :open class:`~.VMobject`.

    Examples
    --------
    .. manim:: CreateScene

    open class CreateScene(Scene):
    def construct(self):
    self.play(Create(Square()))

    See Also
    --------
    :open class:`~.ShowPassingFlash`
 */
open class Create(
    override val mobject: VMobject = VMobject(),
    val lag_ratio: Float = 1.0f,
    val introducer: Boolean = true,
) : ShowPartial(mobject)




open class Uncreate : Create()
//    """Like :open class:`Create` but in reverse.
//
//    Examples
//    --------
//    .. manim:: ShowUncreate
//
//        open class ShowUncreate(Scene):
//            def construct(self):
//                self.play(Uncreate(Square()))
//
//    See Also
//    --------
//    :open class:`Create`
//
//    """


open class DrawBorderThenFill(mobject: Mobject) : Animation(mobject)
//    """Draw the border first and then show the fill.
//
//    Examples
//    --------
//    .. manim:: ShowDrawBorderThenFill
//
//        open class ShowDrawBorderThenFill(Scene):
//            def construct(self):
//                self.play(DrawBorderThenFill(Square(fill_opacity=1, fill_color=ORANGE)))
//    """



open class Write(mobject: Mobject) : DrawBorderThenFill(mobject)
//    """Simulate hand-writing a :open class:`~.Text` or hand-drawing a :open class:`~.VMobject`.
//
//    Examples
//    --------
//    .. manim:: ShowWrite
//
//        open class ShowWrite(Scene):
//            def construct(self):
//                self.play(Write(Text("Hello", font_size=144)))
//
//    .. manim:: ShowWriteReversed
//
//        open class ShowWriteReversed(Scene):
//            def construct(self):
//                self.play(Write(Text("Hello", font_size=144), reverse=True, remover=False))
//
//    Tests
//    -----
//
//    Check that creating empty :open class:`.Write` animations works::
//
//        >>> from manim import Write, Text
//        >>> Write(Text(''))
//        Write(Text(''))
//    """



open class Unwrite(mobject: Mobject) : Write(mobject)
//    """Simulate erasing by hand a :open class:`~.Text` or a :open class:`~.VMobject`.
//
//    Parameters
//    ----------
//    reverse
//        Set True to have the animation start erasing from the last submobject first.
//
//    Examples
//    --------
//
//    .. manim :: UnwriteReverseTrue
//
//        open class UnwriteReverseTrue(Scene):
//            def construct(self):
//                text = Tex("Alice and Bob").scale(3)
//                self.add(text)
//                self.play(Unwrite(text))
//
//    .. manim:: UnwriteReverseFalse
//
//        open class UnwriteReverseFalse(Scene):
//            def construct(self):
//                text = Tex("Alice and Bob").scale(3)
//                self.add(text)
//                self.play(Unwrite(text, reverse=False))
//    """



open class SpiralIn(mobject: Mobject) : Animation(mobject)
//    r"""Create the Mobject with sub-Mobjects flying in on spiral trajectories.
//
//    Parameters
//    ----------
//    shapes
//        The Mobject on which to be operated.
//
//    scale_factor
//        The factor used for scaling the effect.
//
//    fade_in_fraction
//        Fractional duration of initial fade-in of sub-Mobjects as they fly inward.
//
//    Examples
//    --------
//    .. manim :: SpiralInExample
//
//        open class SpiralInExample(Scene):
//            def construct(self):
//                pi = MathTex(r"\pi").scale(7)
//                pi.shift(2.25 * LEFT + 1.5 * UP)
//                circle = Circle(color=GREEN_C, fill_opacity=1).shift(LEFT)
//                square = Square(color=BLUE_D, fill_opacity=1).shift(UP)
//                shapes = VGroup(pi, circle, square)
//                self.play(SpiralIn(shapes))
//    """



open class ShowIncreasingSubsets(mobject: Mobject) : Animation(mobject)
//    """Show one submobject at a time, leaving all previous ones displayed on screen.
//
//    Examples
//    --------
//
//    .. manim:: ShowIncreasingSubsetsScene
//
//        open class ShowIncreasingSubsetsScene(Scene):
//            def construct(self):
//                p = VGroup(Dot(), Square(), Triangle())
//                self.add(p)
//                self.play(ShowIncreasingSubsets(p))
//                self.wait()
//    """



open class AddTextLetterByLetter(mobject: Mobject) : ShowIncreasingSubsets(mobject)
//    """Show a :open class:`~.Text` letter by letter on the scene.
//
//    Parameters
//    ----------
//    time_per_char
//        Frequency of appearance of the letters.
//
//    .. tip::
//
//        This is currently only possible for open class:`~.Text` and not for open class:`~.MathTex`
//
//    """



open class RemoveTextLetterByLetter(mobject: Mobject) : AddTextLetterByLetter(mobject)
//    """Remove a :open class:`~.Text` letter by letter from the scene.
//
//    Parameters
//    ----------
//    time_per_char
//        Frequency of appearance of the letters.
//
//    .. tip::
//
//        This is currently only possible for open class:`~.Text` and not for open class:`~.MathTex`
//
//    """



open class ShowSubmobjectsOneByOne(mobject: Mobject) : ShowIncreasingSubsets(mobject)
//    """Show one submobject at a time, removing all previously displayed ones from screen."""
