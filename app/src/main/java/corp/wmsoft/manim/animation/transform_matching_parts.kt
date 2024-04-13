package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations that try to transform Mobjects while keeping track of identical parts."""



open class TransformMatchingAbstractBase(mobject: Mobject) : AnimationGroup(mobject)
//    """Abstract base open class for transformations that keep track of matching parts.
//
//    Subopen classes have to implement the two static methods
//    :meth:`~.TransformMatchingAbstractBase.get_mobject_parts` and
//    :meth:`~.TransformMatchingAbstractBase.get_mobject_key`.
//
//    Basically, this transformation first maps all submobjects returned
//    by the ``get_mobject_parts`` method to certain keys by applying the
//    ``get_mobject_key`` method. Then, submobjects with matching keys
//    are transformed into each other.
//
//    Parameters
//    ----------
//    mobject
//        The starting :open class:`~.Mobject`.
//    target_mobject
//        The target :open class:`~.Mobject`.
//    transform_mismatches
//        Controls whether submobjects without a matching key are transformed
//        into each other by using :open class:`~.Transform`. Default: ``False``.
//    fade_transform_mismatches
//        Controls whether submobjects without a matching key are transformed
//        into each other by using :open class:`~.FadeTransform`. Default: ``False``.
//    key_map
//        Optional. A dictionary mapping keys belonging to some of the starting mobject's
//        submobjects (i.e., the return values of the ``get_mobject_key`` method)
//        to some keys belonging to the target mobject's submobjects that should
//        be transformed although the keys don't match.
//    kwargs
//        All further keyword arguments are passed to the submobject transformations.
//
//
//    Note
//    ----
//    If neither ``transform_mismatches`` nor ``fade_transform_mismatches``
//    are set to ``True``, submobjects without matching keys in the starting
//    mobject are faded out in the direction of the unmatched submobjects in
//    the target mobject, and unmatched submobjects in the target mobject
//    are faded in from the direction of the unmatched submobjects in the
//    start mobject.
//
//    """


open class TransformMatchingShapes(mobject: Mobject) : TransformMatchingAbstractBase(mobject)
//    """An animation trying to transform groups by matching the shape
//    of their submobjects.
//
//    Two submobjects match if the hash of their point coordinates after
//    normalization (i.e., after translation to the origin, fixing the submobject
//    height at 1 unit, and rounding the coordinates to three decimal places)
//    matches.
//
//    See also
//    --------
//    :open class:`~.TransformMatchingAbstractBase`
//
//    Examples
//    --------
//
//    .. manim:: Anagram
//
//        open class Anagram(Scene):
//            def construct(self):
//                src = Text("the morse code")
//                tar = Text("here come dots")
//                self.play(Write(src))
//                self.wait(0.5)
//                self.play(TransformMatchingShapes(src, tar, path_arc=PI/2))
//                self.wait(0.5)
//
//    """


open class TransformMatchingTex(mobject: Mobject) : TransformMatchingAbstractBase(mobject)
//    """A transformation trying to transform rendered LaTeX strings.
//
//    Two submobjects match if their ``tex_string`` matches.
//
//    See also
//    --------
//    :open class:`~.TransformMatchingAbstractBase`
//
//    Examples
//    --------
//
//    .. manim:: MatchingEquationParts
//
//        open class MatchingEquationParts(Scene):
//            def construct(self):
//                variables = VGroup(MathTex("a"), MathTex("b"), MathTex("c")).arrange_submobjects().shift(UP)
//
//                eq1 = MathTex("{{x}}^2", "+", "{{y}}^2", "=", "{{z}}^2")
//                eq2 = MathTex("{{a}}^2", "+", "{{b}}^2", "=", "{{c}}^2")
//                eq3 = MathTex("{{a}}^2", "=", "{{c}}^2", "-", "{{b}}^2")
//
//                self.add(eq1)
//                self.wait(0.5)
//                self.play(TransformMatchingTex(Group(eq1, variables), eq2))
//                self.wait(0.5)
//                self.play(TransformMatchingTex(eq2, eq3))
//                self.wait(0.5)
//
//    """
