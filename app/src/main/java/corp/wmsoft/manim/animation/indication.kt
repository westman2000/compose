package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations drawing attention to particular mobjects.
//
//Examples
//--------
//
//.. manim:: Indications
//
//    open class Indications(Scene):
//        def construct(self):
//            indications = [ApplyWave,Circumscribe,Flash,FocusOn,Indicate,ShowPassingFlash,Wiggle]
//            names = [Tex(i.__name__).scale(3) for i in indications]
//
//            self.add(names[0])
//            for i in range(len(names)):
//                if indications[i] is Flash:
//                    self.play(Flash(UP))
//                elif indications[i] is ShowPassingFlash:
//                    self.play(ShowPassingFlash(Underline(names[i])))
//                else:
//                    self.play(indications[i](names[i]))
//                self.play(AnimationGroup(
//                    FadeOut(names[i], shift=UP*1.5),
//                    FadeIn(names[(i+1)%len(names)], shift=UP*1.5),
//                ))
//
//"""



open class FocusOn(mobject: Mobject) : Transform(mobject)
//    """Shrink a spotlight to a position.
//
//    Parameters
//    ----------
//    focus_point
//        The point at which to shrink the spotlight. If it is a :open class:`.~Mobject` its center will be used.
//    opacity
//        The opacity of the spotlight.
//    color
//        The color of the spotlight.
//    run_time
//        The duration of the animation.
//    kwargs
//        Additional arguments to be passed to the :open class:`~.Succession` constructor
//
//    Examples
//    --------
//    .. manim:: UsingFocusOn
//
//        open class UsingFocusOn(Scene):
//            def construct(self):
//                dot = Dot(color=YELLOW).shift(DOWN)
//                self.add(Tex("Focusing on the dot below:"), dot)
//                self.play(FocusOn(dot))
//                self.wait()
//    """



open class Indicate(mobject: Mobject) : Transform(mobject)
//    """Indicate a Mobject by temporarily resizing and recoloring it.
//
//    Parameters
//    ----------
//    mobject
//        The mobject to indicate.
//    scale_factor
//        The factor by which the mobject will be temporally scaled
//    color
//        The color the mobject temporally takes.
//    rate_func
//        The function defining the animation progress at every point in time.
//    kwargs
//        Additional arguments to be passed to the :open class:`~.Succession` constructor
//
//    Examples
//    --------
//    .. manim:: UsingIndicate
//
//        open class UsingIndicate(Scene):
//            def construct(self):
//                tex = Tex("Indicate").scale(3)
//                self.play(Indicate(tex))
//                self.wait()
//    """



open class Flash(mobject: Mobject) : AnimationGroup(mobject)
//    """Send out lines in all directions.
//
//    Parameters
//    ----------
//    point
//        The center of the flash lines. If it is a :open class:`.~Mobject` its center will be used.
//    line_length
//        The length of the flash lines.
//    num_lines
//        The number of flash lines.
//    flash_radius
//        The distance from `point` at which the flash lines start.
//    line_stroke_width
//        The stroke width of the flash lines.
//    color
//        The color of the flash lines.
//    time_width
//        The time width used for the flash lines. See :open class:`.~ShowPassingFlash` for more details.
//    run_time
//        The duration of the animation.
//    kwargs
//        Additional arguments to be passed to the :open class:`~.Succession` constructor
//
//    Examples
//    --------
//    .. manim:: UsingFlash
//
//        open class UsingFlash(Scene):
//            def construct(self):
//                dot = Dot(color=YELLOW).shift(DOWN)
//                self.add(Tex("Flash the dot below:"), dot)
//                self.play(Flash(dot))
//                self.wait()
//
//    .. manim:: FlashOnCircle
//
//        open class FlashOnCircle(Scene):
//            def construct(self):
//                radius = 2
//                circle = Circle(radius)
//                self.add(circle)
//                self.play(Flash(
//                    circle, line_length=1,
//                    num_lines=30, color=RED,
//                    flash_radius=radius+SMALL_BUFF,
//                    time_width=0.3, run_time=2,
//                    rate_func = rush_from
//                ))
//    """



open class ShowPassingFlash(mobject: Mobject) : ShowPartial(mobject)
//    """Show only a sliver of the VMobject each frame.
//
//    Parameters
//    ----------
//    mobject
//        The mobject whose stroke is animated.
//    time_width
//        The length of the sliver relative to the length of the stroke.
//
//    Examples
//    --------
//    .. manim:: TimeWidthValues
//
//        open class TimeWidthValues(Scene):
//            def construct(self):
//                p = RegularPolygon(5, color=DARK_GRAY, stroke_width=6).scale(3)
//                lbl = VMobject()
//                self.add(p, lbl)
//                p = p.copy().set_color(BLUE)
//                for time_width in [0.2, 0.5, 1, 2]:
//                    lbl.become(Tex(r"\\texttt{time\\_width={{%.1f}}}"%time_width))
//                    self.play(ShowPassingFlash(
//                        p.copy().set_color(BLUE),
//                        run_time=2,
//                        time_width=time_width
//                    ))
//
//    See Also
//    --------
//    :open class:`~.Create`
//
//    """


open class ApplyWave(mobject: Mobject) : Homotopy(mobject)
//    """Send a wave through the Mobject distorting it temporarily.
//
//    Parameters
//    ----------
//    mobject
//        The mobject to be distorted.
//    direction
//        The direction in which the wave nudges points of the shape
//    amplitude
//        The distance points of the shape get shifted
//    wave_func
//        The function defining the shape of one wave flank.
//    time_width
//        The length of the wave relative to the width of the mobject.
//    ripples
//        The number of ripples of the wave
//    run_time
//        The duration of the animation.
//
//    Examples
//    --------
//
//    .. manim:: ApplyingWaves
//
//        open class ApplyingWaves(Scene):
//            def construct(self):
//                tex = Tex("WaveWaveWaveWaveWave").scale(2)
//                self.play(ApplyWave(tex))
//                self.play(ApplyWave(
//                    tex,
//                    direction=RIGHT,
//                    time_width=0.5,
//                    amplitude=0.3
//                ))
//                self.play(ApplyWave(
//                    tex,
//                    rate_func=linear,
//                    ripples=4
//                ))
//
//    """



open class Wiggle(mobject: Mobject) : Animation(mobject)
//    """Wiggle a Mobject.
//
//    Parameters
//    ----------
//    mobject
//        The mobject to wiggle.
//    scale_value
//        The factor by which the mobject will be temporarily scaled.
//    rotation_angle
//        The wiggle angle.
//    n_wiggles
//        The number of wiggles.
//    scale_about_point
//        The point about which the mobject gets scaled.
//    rotate_about_point
//        The point around which the mobject gets rotated.
//    run_time
//        The duration of the animation
//
//    Examples
//    --------
//
//    .. manim:: ApplyingWaves
//
//        open class ApplyingWaves(Scene):
//            def construct(self):
//                tex = Tex("Wiggle").scale(3)
//                self.play(Wiggle(tex))
//                self.wait()
//
//    """


open class Circumscribe(mobject: Mobject) : Succession(mobject)
//    """Draw a temporary line surrounding the mobject.
//
//    Parameters
//    ----------
//    mobject
//        The mobject to be circumscribed.
//    shape
//        The shape with which to surrond the given mobject. Should be either
//        :open class:`~.Rectangle` or :open class:`~.Circle`
//    fade_in
//        Whether to make the surrounding shape to fade in. It will be drawn otherwise.
//    fade_out
//        Whether to make the surrounding shape to fade out. It will be undrawn otherwise.
//    time_width
//        The time_width of the drawing and undrawing. Gets ignored if either `fade_in` or `fade_out` is `True`.
//    buff
//        The distance between the surrounding shape and the given mobject.
//    color
//        The color of the surrounding shape.
//    run_time
//        The duration of the entire animation.
//    kwargs
//        Additional arguments to be passed to the :open class:`~.Succession` constructor
//
//    Examples
//    --------
//
//    .. manim:: UsingCircumscribe
//
//        open class UsingCircumscribe(Scene):
//            def construct(self):
//                lbl = Tex(r"Circum-\\\\scribe").scale(2)
//                self.add(lbl)
//                self.play(Circumscribe(lbl))
//                self.play(Circumscribe(lbl, Circle))
//                self.play(Circumscribe(lbl, fade_out=True))
//                self.play(Circumscribe(lbl, time_width=2))
//                self.play(Circumscribe(lbl, Circle, True))
//
//    """

