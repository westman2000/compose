package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations related to rotation."""



class Rotating(mobject: Mobject) : Animation(mobject)


class Rotate(mobject: Mobject) : Transform(mobject)
//    """Animation that rotates a Mobject.
//
//    Parameters
//    ----------
//    mobject
//        The mobject to be rotated.
//    angle
//        The rotation angle.
//    axis
//        The rotation axis as a numpy vector.
//    about_point
//        The rotation center.
//    about_edge
//        If ``about_point``is ``None``, this argument specifies
//        the direction of the bounding box point to be taken as
//        the rotation center.
//
//    Examples
//    --------
//    .. manim:: UsingRotate
//
//        class UsingRotate(Scene):
//            def construct(self):
//                self.play(
//                    Rotate(
//                        Square(side_length=0.5).shift(UP * 2),
//                        angle=2*PI,
//                        about_point=ORIGIN,
//                        rate_func=linear,
//                    ),
//                    Rotate(Square(side_length=0.5), angle=2*PI, rate_func=linear),
//                    )
//
//    """

