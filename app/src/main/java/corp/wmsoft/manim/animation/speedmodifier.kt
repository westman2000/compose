package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Utilities for modifying the speed at which animations are played."""

class ChangeSpeed(mobject: Mobject) : Animation(mobject)
//    """Modifies the speed of passed animation.
//    :class:`AnimationGroup` with different ``lag_ratio`` can also be used
//    which combines multiple animations into one.
//    The ``run_time`` of the passed animation is changed to modify the speed.
//
//    Parameters
//    ----------
//    anim
//        Animation of which the speed is to be modified.
//    speedinfo
//        Contains nodes (percentage of ``run_time``) and its corresponding speed factor.
//    rate_func
//        Overrides ``rate_func`` of passed animation, applied before changing speed.
//
//    Examples
//    --------
//
//    .. manim:: SpeedModifierExample
//
//        class SpeedModifierExample(Scene):
//            def construct(self):
//                a = Dot().shift(LEFT * 4)
//                b = Dot().shift(RIGHT * 4)
//                self.add(a, b)
//                self.play(
//                    ChangeSpeed(
//                        AnimationGroup(
//                            a.animate(run_time=1).shift(RIGHT * 8),
//                            b.animate(run_time=1).shift(LEFT * 8),
//                        ),
//                        speedinfo={0.3: 1, 0.4: 0.1, 0.6: 0.1, 1: 1},
//                        rate_func=linear,
//                    )
//                )
//
//    .. manim:: SpeedModifierUpdaterExample
//
//        class SpeedModifierUpdaterExample(Scene):
//            def construct(self):
//                a = Dot().shift(LEFT * 4)
//                self.add(a)
//
//                ChangeSpeed.add_updater(a, lambda x, dt: x.shift(RIGHT * 4 * dt))
//                self.play(
//                    ChangeSpeed(
//                        Wait(2),
//                        speedinfo={0.4: 1, 0.5: 0.2, 0.8: 0.2, 1: 1},
//                        affects_speed_updaters=True,
//                    )
//                )
//
//    .. manim:: SpeedModifierUpdaterExample2
//
//        class SpeedModifierUpdaterExample2(Scene):
//            def construct(self):
//                a = Dot().shift(LEFT * 4)
//                self.add(a)
//
//                ChangeSpeed.add_updater(a, lambda x, dt: x.shift(RIGHT * 4 * dt))
//                self.wait()
//                self.play(
//                    ChangeSpeed(
//                        Wait(),
//                        speedinfo={1: 0},
//                        affects_speed_updaters=True,
//                    )
//                )
//
//    """
