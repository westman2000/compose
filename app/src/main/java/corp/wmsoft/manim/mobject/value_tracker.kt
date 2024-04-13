package corp.wmsoft.manim.mobject

//"""Simple mobjects that can be used for storing (and updating) a value."""

open class ValueTracker : Mobject()
//    """A mobject that can be used for tracking (real-valued) parameters.
//    Useful for animating parameter changes.
//
//    Not meant to be displayed.  Instead the position encodes some
//    number, often one which another animation or continual_animation
//    uses for its update function, and by treating it as a mobject it can
//    still be animated and manipulated just like anything else.
//
//    This value changes continuously when animated using the :attr:`animate` syntax.
//
//    Examples
//    --------
//    .. manim:: ValueTrackerExample
//
//        class ValueTrackerExample(Scene):
//            def construct(self):
//                number_line = NumberLine()
//                pointer = Vector(DOWN)
//                label = MathTex("x").add_updater(lambda m: m.next_to(pointer, UP))
//
//                tracker = ValueTracker(0)
//                pointer.add_updater(
//                    lambda m: m.next_to(
//                                number_line.n2p(tracker.get_value()),
//                                UP
//                            )
//                )
//                self.add(number_line, pointer,label)
//                tracker += 1.5
//                self.wait(1)
//                tracker -= 4
//                self.wait(0.5)
//                self.play(tracker.animate.set_value(5))
//                self.wait(0.5)
//                self.play(tracker.animate.set_value(3))
//                self.play(tracker.animate.increment_value(-2))
//                self.wait(0.5)
//
//    .. note::
//
//        You can also link ValueTrackers to updaters. In this case, you have to make sure that the
//        ValueTracker is added to the scene by ``add``
//
//    .. manim:: ValueTrackerExample
//
//        class ValueTrackerExample(Scene):
//            def construct(self):
//                tracker = ValueTracker(0)
//                label = Dot(radius=3).add_updater(lambda x : x.set_x(tracker.get_value()))
//                self.add(label)
//                self.add(tracker)
//                tracker.add_updater(lambda mobject, dt: mobject.increment_value(dt))
//                self.wait(2)
//
//    """

class ComplexValueTracker : ValueTracker()
//    """Tracks a complex-valued parameter.
//
//    When the value is set through :attr:`animate`, the value will take a straight path from the
//    source point to the destination point.
//
//    Examples
//    --------
//    .. manim:: ComplexValueTrackerExample
//
//        class ComplexValueTrackerExample(Scene):
//            def construct(self):
//                tracker = ComplexValueTracker(-2+1j)
//                dot = Dot().add_updater(
//                    lambda x: x.move_to(tracker.points)
//                )
//
//                self.add(NumberPlane(), dot)
//
//                self.play(tracker.animate.set_value(3+2j))
//                self.play(tracker.animate.set_value(tracker.get_value() * 1j))
//                self.play(tracker.animate.set_value(tracker.get_value() - 2j))
//                self.play(tracker.animate.set_value(tracker.get_value() / (-2 + 3j)))
//    """
