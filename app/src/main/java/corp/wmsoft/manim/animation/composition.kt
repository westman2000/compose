package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Tools for displaying multiple animations at once."""



open class AnimationGroup(mobject: Mobject) : Animation(mobject)
//    """Plays a group or series of :class:`~.Animation`.
//
//    Parameters
//    ----------
//    animations
//        Sequence of :class:`~.Animation` objects to be played.
//    group
//        A group of multiple :class:`~.Mobject`.
//    run_time
//        The duration of the animation in seconds.
//    rate_func
//        The function defining the animation progress based on the relative
//        runtime (see :mod:`~.rate_functions`) .
//    lag_ratio
//        Defines the delay after which the animation is applied to submobjects. A lag_ratio of
//        ``n.nn`` means the next animation will play when ``nnn%`` of the current animation has played.
//        Defaults to 0.0, meaning that all animations will be played together.
//
//        This does not influence the total runtime of the animation. Instead the runtime
//        of individual animations is adjusted so that the complete animation has the defined
//        run time.
//    """



open class Succession(mobject: Mobject) : AnimationGroup(mobject)
//    """Plays a series of animations in succession.
//
//    Parameters
//    ----------
//    animations
//        Sequence of :class:`~.Animation` objects to be played.
//    lag_ratio
//        Defines the delay after which the animation is applied to submobjects. A lag_ratio of
//        ``n.nn`` means the next animation will play when ``nnn%`` of the current animation has played.
//        Defaults to 1.0, meaning that the next animation will begin when 100% of the current
//        animation has played.
//
//        This does not influence the total runtime of the animation. Instead the runtime
//        of individual animations is adjusted so that the complete animation has the defined
//        run time.
//
//    Examples
//    --------
//    .. manim:: SuccessionExample
//
//        class SuccessionExample(Scene):
//            def construct(self):
//                dot1 = Dot(point=LEFT * 2 + UP * 2, radius=0.16, color=BLUE)
//                dot2 = Dot(point=LEFT * 2 + DOWN * 2, radius=0.16, color=MAROON)
//                dot3 = Dot(point=RIGHT * 2 + DOWN * 2, radius=0.16, color=GREEN)
//                dot4 = Dot(point=RIGHT * 2 + UP * 2, radius=0.16, color=YELLOW)
//                self.add(dot1, dot2, dot3, dot4)
//
//                self.play(Succession(
//                    dot1.animate.move_to(dot2),
//                    dot2.animate.move_to(dot3),
//                    dot3.animate.move_to(dot4),
//                    dot4.animate.move_to(dot1)
//                ))
//    """



open class LaggedStart(mobject: Mobject) : AnimationGroup(mobject)
//    """Adjusts the timing of a series of :class:`~.Animation` according to ``lag_ratio``.
//
//    Parameters
//    ----------
//    animations
//        Sequence of :class:`~.Animation` objects to be played.
//    lag_ratio
//        Defines the delay after which the animation is applied to submobjects. A lag_ratio of
//        ``n.nn`` means the next animation will play when ``nnn%`` of the current animation has played.
//        Defaults to 0.05, meaning that the next animation will begin when 5% of the current
//        animation has played.
//
//        This does not influence the total runtime of the animation. Instead the runtime
//        of individual animations is adjusted so that the complete animation has the defined
//        run time.
//
//    Examples
//    --------
//    .. manim:: LaggedStartExample
//
//        class LaggedStartExample(Scene):
//            def construct(self):
//                title = Text("lag_ratio = 0.25").to_edge(UP)
//
//                dot1 = Dot(point=LEFT * 2 + UP, radius=0.16)
//                dot2 = Dot(point=LEFT * 2, radius=0.16)
//                dot3 = Dot(point=LEFT * 2 + DOWN, radius=0.16)
//                line_25 = DashedLine(
//                    start=LEFT + UP * 2,
//                    end=LEFT + DOWN * 2,
//                    color=RED
//                )
//                label = Text("25%", font_size=24).next_to(line_25, UP)
//                self.add(title, dot1, dot2, dot3, line_25, label)
//
//                self.play(LaggedStart(
//                    dot1.animate.shift(RIGHT * 4),
//                    dot2.animate.shift(RIGHT * 4),
//                    dot3.animate.shift(RIGHT * 4),
//                    lag_ratio=0.25,
//                    run_time=4
//                ))
//    """



open class LaggedStartMap(mobject: Mobject) : LaggedStart(mobject)
//    """Plays a series of :class:`~.Animation` while mapping a function to submobjects.
//
//    Parameters
//    ----------
//    AnimationClass
//        :class:`~.Animation` to apply to mobject.
//    mobject
//        :class:`~.Mobject` whose submobjects the animation, and optionally the function,
//        are to be applied.
//    arg_creator
//        Function which will be applied to :class:`~.Mobject`.
//    run_time
//        The duration of the animation in seconds.
//
//    Examples
//    --------
//    .. manim:: LaggedStartMapExample
//
//        class LaggedStartMapExample(Scene):
//            def construct(self):
//                title = Tex("LaggedStartMap").to_edge(UP, buff=LARGE_BUFF)
//                dots = VGroup(
//                    *[Dot(radius=0.16) for _ in range(35)]
//                    ).arrange_in_grid(rows=5, cols=7, buff=MED_LARGE_BUFF)
//                self.add(dots, title)
//
//                # Animate yellow ripple effect
//                for mob in dots, title:
//                    self.play(LaggedStartMap(
//                        ApplyMethod, mob,
//                        lambda m : (m.set_color, YELLOW),
//                        lag_ratio = 0.1,
//                        rate_func = there_and_back,
//                        run_time = 2
//                    ))
//    """

