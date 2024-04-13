package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations transforming one mobject into another."""



open class Transform(mobject: Mobject) : Animation(mobject)
//    """A Transform transforms a Mobject into a target Mobject.
//
//    Parameters
//    ----------
//    mobject
//        The :open class:`.Mobject` to be transformed. It will be mutated to become the ``target_mobject``.
//    target_mobject
//        The target of the transformation.
//    path_func
//        A function defining the path that the points of the ``mobject`` are being moved
//        along until they match the points of the ``target_mobject``, see :mod:`.utils.paths`.
//    path_arc
//        The arc angle (in radians) that the points of ``mobject`` will follow to reach
//        the points of the target if using a circular path arc, see ``path_arc_centers``.
//        See also :func:`manim.utils.paths.path_along_arc`.
//    path_arc_axis
//        The axis to rotate along if using a circular path arc, see ``path_arc_centers``.
//    path_arc_centers
//        The center of the circular arcs along which the points of ``mobject`` are
//        moved by the transformation.
//
//        If this is set and ``path_func`` is not set, then a ``path_along_circles`` path will be generated
//        using the ``path_arc`` parameters and stored in ``path_func``. If ``path_func`` is set, this and the
//        other ``path_arc`` fields are set as attributes, but a ``path_func`` is not generated from it.
//    replace_mobject_with_target_in_scene
//        Controls which mobject is replaced when the transformation is complete.
//
//        If set to True, ``mobject`` will be removed from the scene and ``target_mobject`` will
//        replace it. Otherwise, ``target_mobject`` is never added and ``mobject`` just takes its shape.
//
//    Examples
//    --------
//
//    .. manim :: TransformPathArc
//
//        open class TransformPathArc(Scene):
//            def construct(self):
//                def make_arc_path(start, end, arc_angle):
//                    points = []
//                    p_fn = path_along_arc(arc_angle)
//                    # alpha animates between 0.0 and 1.0, where 0.0
//                    # is the beginning of the animation and 1.0 is the end.
//                    for alpha in range(0, 11):
//                        points.append(p_fn(start, end, alpha / 10.0))
//                    path = VMobject(stroke_color=YELLOW)
//                    path.set_points_smoothly(points)
//                    return path
//
//                left = Circle(stroke_color=BLUE_E, fill_opacity=1.0, radius=0.5).move_to(LEFT * 2)
//                colors = [TEAL_A, TEAL_B, TEAL_C, TEAL_D, TEAL_E, GREEN_A]
//                # Positive angles move counter-clockwise, negative angles move clockwise.
//                examples = [-90, 0, 30, 90, 180, 270]
//                anims = []
//                for idx, angle in enumerate(examples):
//                    left_c = left.copy().shift((3 - idx) * UP)
//                    left_c.fill_color = colors[idx]
//                    right_c = left_c.copy().shift(4 * RIGHT)
//                    path_arc = make_arc_path(left_c.get_center(), right_c.get_center(),
//                                             arc_angle=angle * DEGREES)
//                    desc = Text('%d°' % examples[idx]).next_to(left_c, LEFT)
//                    # Make the circles in front of the text in front of the arcs.
//                    self.add(
//                        path_arc.set_z_index(1),
//                        desc.set_z_index(2),
//                        left_c.set_z_index(3),
//                    )
//                    anims.append(Transform(left_c, right_c, path_arc=angle * DEGREES))
//
//                self.play(*anims, run_time=2)
//                self.wait()
//    """


open class ReplacementTransform(mobject: Mobject) : Transform(mobject)
//    """Replaces and morphs a mobject into a target mobject.
//
//    Parameters
//    ----------
//    mobject
//        The starting :open class:`~.Mobject`.
//    target_mobject
//        The target :open class:`~.Mobject`.
//    kwargs
//        Further keyword arguments that are passed to :open class:`Transform`.
//
//    Examples
//    --------
//
//    .. manim:: ReplacementTransformOrTransform
//        :quality: low
//
//        open class ReplacementTransformOrTransform(Scene):
//            def construct(self):
//                # set up the numbers
//                r_transform = VGroup(*[Integer(i) for i in range(1,4)])
//                text_1 = Text("ReplacementTransform", color=RED)
//                r_transform.add(text_1)
//
//                transform = VGroup(*[Integer(i) for i in range(4,7)])
//                text_2 = Text("Transform", color=BLUE)
//                transform.add(text_2)
//
//                ints = VGroup(r_transform, transform)
//                texts = VGroup(text_1, text_2).scale(0.75)
//                r_transform.arrange(direction=UP, buff=1)
//                transform.arrange(direction=UP, buff=1)
//
//                ints.arrange(buff=2)
//                self.add(ints, texts)
//
//                # The mobs replace each other and none are left behind
//                self.play(ReplacementTransform(r_transform[0], r_transform[1]))
//                self.play(ReplacementTransform(r_transform[1], r_transform[2]))
//
//                # The mobs linger after the Transform()
//                self.play(Transform(transform[0], transform[1]))
//                self.play(Transform(transform[1], transform[2]))
//                self.wait()
//
//    """


open class TransformFromCopy(mobject: Mobject) : Transform(mobject)
//    """
//    Performs a reversed Transform
//    """


open class ClockwiseTransform(mobject: Mobject) : Transform(mobject)
//    """Transforms the points of a mobject along a clockwise oriented arc.
//
//    See also
//    --------
//    :open class:`.Transform`, :open class:`.CounterclockwiseTransform`
//
//    Examples
//    --------
//
//    .. manim:: ClockwiseExample
//
//        open class ClockwiseExample(Scene):
//            def construct(self):
//                dl, dr = Dot(), Dot()
//                sl, sr = Square(), Square()
//
//                VGroup(dl, sl).arrange(DOWN).shift(2*LEFT)
//                VGroup(dr, sr).arrange(DOWN).shift(2*RIGHT)
//
//                self.add(dl, dr)
//                self.wait()
//                self.play(
//                    ClockwiseTransform(dl, sl),
//                    Transform(dr, sr)
//                )
//                self.wait()
//
//    """


open class CounterclockwiseTransform(mobject: Mobject) : Transform(mobject)
//    """Transforms the points of a mobject along a counterclockwise oriented arc.
//
//    See also
//    --------
//    :open class:`.Transform`, :open class:`.ClockwiseTransform`
//
//    Examples
//    --------
//
//    .. manim:: CounterclockwiseTransform_vs_Transform
//
//        open class CounterclockwiseTransform_vs_Transform(Scene):
//            def construct(self):
//                # set up the numbers
//                c_transform = VGroup(DecimalNumber(number=3.141, num_decimal_places=3), DecimalNumber(number=1.618, num_decimal_places=3))
//                text_1 = Text("CounterclockwiseTransform", color=RED)
//                c_transform.add(text_1)
//
//                transform = VGroup(DecimalNumber(number=1.618, num_decimal_places=3), DecimalNumber(number=3.141, num_decimal_places=3))
//                text_2 = Text("Transform", color=BLUE)
//                transform.add(text_2)
//
//                ints = VGroup(c_transform, transform)
//                texts = VGroup(text_1, text_2).scale(0.75)
//                c_transform.arrange(direction=UP, buff=1)
//                transform.arrange(direction=UP, buff=1)
//
//                ints.arrange(buff=2)
//                self.add(ints, texts)
//
//                # The mobs move in clockwise direction for ClockwiseTransform()
//                self.play(CounterclockwiseTransform(c_transform[0], c_transform[1]))
//
//                # The mobs move straight up for Transform()
//                self.play(Transform(transform[0], transform[1]))
//
//    """


open class MoveToTarget(mobject: Mobject) : Transform(mobject)
//    """Transforms a mobject to the mobject stored in its ``target`` attribute.
//
//    After calling the :meth:`~.Mobject.generate_target` method, the :attr:`target`
//    attribute of the mobject is populated with a copy of it. After modifying the attribute,
//    playing the :open class:`.MoveToTarget` animation transforms the original mobject
//    into the modified one stored in the :attr:`target` attribute.
//
//    Examples
//    --------
//
//    .. manim:: MoveToTargetExample
//
//        open class MoveToTargetExample(Scene):
//            def construct(self):
//                c = Circle()
//
//                c.generate_target()
//                c.target.set_fill(color=GREEN, opacity=0.5)
//                c.target.shift(2*RIGHT + UP).scale(0.5)
//
//                self.add(c)
//                self.play(MoveToTarget(c))
//
//    """



open class _MethodAnimation(mobject: Mobject) : MoveToTarget(mobject)


open class ApplyMethod(mobject: Mobject) : Transform(mobject)
//    """Animates a mobject by applying a method.
//
//    Note that only the method needs to be passed to this animation,
//    it is not required to pass the corresponding mobject. Furthermore,
//    this animation open class only works if the method returns the modified
//    mobject.
//
//    Parameters
//    ----------
//    method
//        The method that will be applied in the animation.
//    args
//        Any positional arguments to be passed when applying the method.
//    kwargs
//        Any keyword arguments passed to :open class:`~.Transform`.
//
//    """


open class ApplyPointwiseFunction(mobject: Mobject) : ApplyMethod(mobject)
//    """Animation that applies a pointwise function to a mobject.
//
//    Examples
//    --------
//
//    .. manim:: WarpSquare
//        :quality: low
//
//        open class WarpSquare(Scene):
//            def construct(self):
//                square = Square()
//                self.play(
//                    ApplyPointwiseFunction(
//                        lambda point: complex_to_R3(np.exp(R3_to_complex(point))), square
//                    )
//                )
//                self.wait()
//
//    """


open class ApplyPointwiseFunctionToCenter(mobject: Mobject) : ApplyPointwiseFunction(mobject)


open class FadeToColor(mobject: Mobject) : ApplyMethod(mobject)
//    """Animation that changes color of a mobject.
//
//    Examples
//    --------
//
//    .. manim:: FadeToColorExample
//
//        open class FadeToColorExample(Scene):
//            def construct(self):
//                self.play(FadeToColor(Text("Hello World!"), color=RED))
//
//    """


open class ScaleInPlace(mobject: Mobject) : ApplyMethod(mobject)
//    """Animation that scales a mobject by a certain factor.
//
//    Examples
//    --------
//
//    .. manim:: ScaleInPlaceExample
//
//        open class ScaleInPlaceExample(Scene):
//            def construct(self):
//                self.play(ScaleInPlace(Text("Hello World!"), 2))
//
//    """


open class ShrinkToCenter(mobject: Mobject) : ScaleInPlace(mobject)
//    """Animation that makes a mobject shrink to center.
//
//    Examples
//    --------
//
//    .. manim:: ShrinkToCenterExample
//
//        open class ShrinkToCenterExample(Scene):
//            def construct(self):
//                self.play(ShrinkToCenter(Text("Hello World!")))
//
//    """


open class Restore(mobject: Mobject) : ApplyMethod(mobject)
//    """Transforms a mobject to its last saved state.
//
//    To save the state of a mobject, use the :meth:`~.Mobject.save_state` method.
//
//    Examples
//    --------
//
//    .. manim:: RestoreExample
//
//        open class RestoreExample(Scene):
//            def construct(self):
//                s = Square()
//                s.save_state()
//                self.play(FadeIn(s))
//                self.play(s.animate.set_color(PURPLE).set_opacity(0.5).shift(2*LEFT).scale(3))
//                self.play(s.animate.shift(5*DOWN).rotate(PI/4))
//                self.wait()
//                self.play(Restore(s), run_time=2)
//
//    """


open class ApplyFunction(mobject: Mobject) : Transform(mobject)


open class ApplyMatrix(mobject: Mobject) : ApplyPointwiseFunction(mobject)
//    """Applies a matrix transform to an mobject.
//
//    Parameters
//    ----------
//    matrix
//        The transformation matrix.
//    mobject
//        The :open class:`~.Mobject`.
//    about_point
//        The origin point for the transform. Defaults to ``ORIGIN``.
//    kwargs
//        Further keyword arguments that are passed to :open class:`ApplyPointwiseFunction`.
//
//    Examples
//    --------
//
//    .. manim:: ApplyMatrixExample
//
//        open class ApplyMatrixExample(Scene):
//            def construct(self):
//                matrix = [[1, 1], [0, 2/3]]
//                self.play(ApplyMatrix(matrix, Text("Hello World!")), ApplyMatrix(matrix, NumberPlane()))
//
//    """


open class ApplyComplexFunction(mobject: Mobject) : ApplyMethod(mobject)


//###


open class CyclicReplace(mobject: Mobject) : Transform(mobject)
//    """An animation moving mobjects cyclically.
//
//    In particular, this means: the first mobject takes the place
//    of the second mobject, the second one takes the place of
//    the third mobject, and so on. The last mobject takes the
//    place of the first one.
//
//    Parameters
//    ----------
//    mobjects
//        List of mobjects to be transformed.
//    path_arc
//        The angle of the arc (in radians) that the mobjects will follow to reach
//        their target.
//    kwargs
//        Further keyword arguments that are passed to :open class:`.Transform`.
//
//    Examples
//    --------
//    .. manim :: CyclicReplaceExample
//
//        open class CyclicReplaceExample(Scene):
//            def construct(self):
//                group = VGroup(Square(), Circle(), Triangle(), Star())
//                group.arrange(RIGHT)
//                self.add(group)
//
//                for _ in range(4):
//                    self.play(CyclicReplace(*group))
//    """



open class Swap(mobject: Mobject) : CyclicReplace(mobject)
//    pass  # Renaming, more understandable for two entries

open class TransformAnimations(mobject: Mobject) : Transform(mobject)


open class FadeTransform(mobject: Mobject) : Transform(mobject)
//    """Fades one mobject into another.
//
//    Parameters
//    ----------
//    mobject
//        The starting :open class:`~.Mobject`.
//    target_mobject
//        The target :open class:`~.Mobject`.
//    stretch
//        Controls whether the target :open class:`~.Mobject` is stretched during
//        the animation. Default: ``True``.
//    dim_to_match
//        If the target mobject is not stretched automatically, this allows
//        to adjust the initial scale of the target :open class:`~.Mobject` while
//        it is shifted in. Setting this to 0, 1, and 2, respectively,
//        matches the length of the target with the length of the starting
//        :open class:`~.Mobject` in x, y, and z direction, respectively.
//    kwargs
//        Further keyword arguments are passed to the parent open class.
//
//    Examples
//    --------
//
//    .. manim:: DifferentFadeTransforms
//
//        open class DifferentFadeTransforms(Scene):
//            def construct(self):
//                starts = [Rectangle(width=4, height=1) for _ in range(3)]
//                VGroup(*starts).arrange(DOWN, buff=1).shift(3*LEFT)
//                targets = [Circle(fill_opacity=1).scale(0.25) for _ in range(3)]
//                VGroup(*targets).arrange(DOWN, buff=1).shift(3*RIGHT)
//
//                self.play(*[FadeIn(s) for s in starts])
//                self.play(
//                    FadeTransform(starts[0], targets[0], stretch=True),
//                    FadeTransform(starts[1], targets[1], stretch=False, dim_to_match=0),
//                    FadeTransform(starts[2], targets[2], stretch=False, dim_to_match=1)
//                )
//
//                self.play(*[FadeOut(mobj) for mobj in self.mobjects])
//
//    """


open class FadeTransformPieces(mobject: Mobject) : FadeTransform(mobject)
//    """Fades submobjects of one mobject into submobjects of another one.
//
//    See also
//    --------
//    :open class:`~.FadeTransform`
//
//    Examples
//    --------
//    .. manim:: FadeTransformSubmobjects
//
//        open class FadeTransformSubmobjects(Scene):
//            def construct(self):
//                src = VGroup(Square(), Circle().shift(LEFT + UP))
//                src.shift(3*LEFT + 2*UP)
//                src_copy = src.copy().shift(4*DOWN)
//
//                target = VGroup(Circle(), Triangle().shift(RIGHT + DOWN))
//                target.shift(3*RIGHT + 2*UP)
//                target_copy = target.copy().shift(4*DOWN)
//
//                self.play(FadeIn(src), FadeIn(src_copy))
//                self.play(
//                    FadeTransform(src, target),
//                    FadeTransformPieces(src_copy, target_copy)
//                )
//                self.play(*[FadeOut(mobj) for mobj in self.mobjects])
//
//    """
