package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Fading in and out of view.
//
//.. manim:: Fading
//
//    open class Fading(Scene):
//        def construct(self):
//            tex_in = Tex("Fade", "In").scale(3)
//            tex_out = Tex("Fade", "Out").scale(3)
//            self.play(FadeIn(tex_in, shift=DOWN, scale=0.66))
//            self.play(ReplacementTransform(tex_in, tex_out))
//            self.play(FadeOut(tex_out, shift=DOWN * 2, scale=1.5))
//
//"""



open class _Fade(mobject: Mobject) : Transform(mobject)
//    """Fade :open class:`~.Mobject` s in or out.
//
//    Parameters
//    ----------
//    mobjects
//        The mobjects to be faded.
//    shift
//        The vector by which the mobject shifts while being faded.
//    target_position
//        The position to/from which the mobject moves while being faded in. In case
//        another mobject is given as target position, its center is used.
//    scale
//        The factor by which the mobject is scaled initially before being rescaling to
//        its original size while being faded in.
//
//    """



open class FadeIn(mobject: Mobject) : _Fade(mobject)
//    """Fade in :open class:`~.Mobject` s.
//
//    Parameters
//    ----------
//    mobjects
//        The mobjects to be faded in.
//    shift
//        The vector by which the mobject shifts while being faded in.
//    target_position
//        The position from which the mobject starts while being faded in. In case
//        another mobject is given as target position, its center is used.
//    scale
//        The factor by which the mobject is scaled initially before being rescaling to
//        its original size while being faded in.
//
//    Examples
//    --------
//
//    .. manim :: FadeInExample
//
//        open class FadeInExample(Scene):
//            def construct(self):
//                dot = Dot(UP * 2 + LEFT)
//                self.add(dot)
//                tex = Tex(
//                    "FadeIn with ", "shift ", " or target\\_position", " and scale"
//                ).scale(1)
//                animations = [
//                    FadeIn(tex[0]),
//                    FadeIn(tex[1], shift=DOWN),
//                    FadeIn(tex[2], target_position=dot),
//                    FadeIn(tex[3], scale=1.5),
//                ]
//                self.play(AnimationGroup(*animations, lag_ratio=0.5))
//
//    """



open class FadeOut(mobject: Mobject) : _Fade(mobject)
//    """Fade out :open class:`~.Mobject` s.
//
//    Parameters
//    ----------
//    mobjects
//        The mobjects to be faded out.
//    shift
//        The vector by which the mobject shifts while being faded out.
//    target_position
//        The position to which the mobject moves while being faded out. In case another
//        mobject is given as target position, its center is used.
//    scale
//        The factor by which the mobject is scaled while being faded out.
//
//    Examples
//    --------
//
//    .. manim :: FadeInExample
//
//        open class FadeInExample(Scene):
//            def construct(self):
//                dot = Dot(UP * 2 + LEFT)
//                self.add(dot)
//                tex = Tex(
//                    "FadeOut with ", "shift ", " or target\\_position", " and scale"
//                ).scale(1)
//                animations = [
//                    FadeOut(tex[0]),
//                    FadeOut(tex[1], shift=DOWN),
//                    FadeOut(tex[2], target_position=dot),
//                    FadeOut(tex[3], scale=0.5),
//                ]
//                self.play(AnimationGroup(*animations, lag_ratio=0.5))
//
//
//    """

