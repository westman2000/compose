package corp.wmsoft.manim.mobject.types

import corp.wmsoft.manim.mobject.Mobject

//"""Mobjects that use vector graphics."""


open class VMobject : Mobject()
//    """A vectorized mobject.
//
//    Parameters
//    ----------
//    background_stroke_color
//        The purpose of background stroke is to have something
//        that won't overlap fill, e.g.  For text against some
//        textured background.
//    sheen_factor
//        When a color c is set, there will be a second color
//        computed based on interpolating c to WHITE by with
//        sheen_factor, and the display will gradient to this
//        secondary color in the direction of sheen_direction.
//    close_new_points
//        Indicates that it will not be displayed, but
//        that it should count in parent mobject's path
//    tolerance_for_point_equality
//        This is within a pixel
//    joint_type
//        The line joint type used to connect the curve segments
//        of this vectorized mobject. See :class:`.LineJointType`
//        for options.
//    """


open class VGroup : VMobject()
//    """A group of vectorized mobjects.
//
//    This can be used to group multiple :class:`~.VMobject` instances together
//    in order to scale, move, ... them together.
//
//    Notes
//    -----
//    When adding the same mobject more than once, repetitions are ignored.
//    Use :meth:`.Mobject.copy` to create a separate copy which can then
//    be added to the group.
//
//    Examples
//    --------
//
//    To add :class:`~.VMobject`s to a :class:`~.VGroup`, you can either use the
//    :meth:`~.VGroup.add` method, or use the `+` and `+=` operators. Similarly, you
//    can subtract elements of a VGroup via :meth:`~.VGroup.remove` method, or
//    `-` and `-=` operators:
//
//        >>> from manim import Triangle, Square, VGroup
//        >>> vg = VGroup()
//        >>> triangle, square = Triangle(), Square()
//        >>> vg.add(triangle)
//        VGroup(Triangle)
//        >>> vg + square   # a new VGroup is constructed
//        VGroup(Triangle, Square)
//        >>> vg            # not modified
//        VGroup(Triangle)
//        >>> vg += square; vg  # modifies vg
//        VGroup(Triangle, Square)
//        >>> vg.remove(triangle)
//        VGroup(Square)
//        >>> vg - square; # a new VGroup is constructed
//        VGroup()
//        >>> vg   # not modified
//        VGroup(Square)
//        >>> vg -= square; vg # modifies vg
//        VGroup()
//
//    .. manim:: ArcShapeIris
//        :save_last_frame:
//
//        class ArcShapeIris(Scene):
//            def construct(self):
//                colors = [DARK_BROWN, BLUE_E, BLUE_D, BLUE_A, TEAL_B, GREEN_B, YELLOW_E]
//                radius = [1 + rad * 0.1 for rad in range(len(colors))]
//
//                circles_group = VGroup()
//
//                # zip(radius, color) makes the iterator [(radius[i], color[i]) for i in range(radius)]
//                circles_group.add(*[Circle(radius=rad, stroke_width=10, color=col)
//                                    for rad, col in zip(radius, colors)])
//                self.add(circles_group)
//
//    """

open class VDict : VMobject()
//    """A VGroup-like class, also offering submobject access by
//    key, like a python dict
//
//    Parameters
//    ----------
//    mapping_or_iterable
//            The parameter specifying the key-value mapping of keys and mobjects.
//    show_keys
//            Whether to also display the key associated with
//            the mobject. This might be useful when debugging,
//            especially when there are a lot of mobjects in the
//            :class:`VDict`. Defaults to False.
//    kwargs
//            Other arguments to be passed to `Mobject`.
//
//    Attributes
//    ----------
//    show_keys : :class:`bool`
//            Whether to also display the key associated with
//            the mobject. This might be useful when debugging,
//            especially when there are a lot of mobjects in the
//            :class:`VDict`. When displayed, the key is towards
//            the left of the mobject.
//            Defaults to False.
//    submob_dict : :class:`dict`
//            Is the actual python dictionary that is used to bind
//            the keys to the mobjects.
//
//    Examples
//    --------
//
//    .. manim:: ShapesWithVDict
//
//        class ShapesWithVDict(Scene):
//            def construct(self):
//                square = Square().set_color(RED)
//                circle = Circle().set_color(YELLOW).next_to(square, UP)
//
//                # create dict from list of tuples each having key-mobject pair
//                pairs = [("s", square), ("c", circle)]
//                my_dict = VDict(pairs, show_keys=True)
//
//                # display it just like a VGroup
//                self.play(Create(my_dict))
//                self.wait()
//
//                text = Tex("Some text").set_color(GREEN).next_to(square, DOWN)
//
//                # add a key-value pair by wrapping it in a single-element list of tuple
//                # after attrs branch is merged, it will be easier like `.add(t=text)`
//                my_dict.add([("t", text)])
//                self.wait()
//
//                rect = Rectangle().next_to(text, DOWN)
//                # can also do key assignment like a python dict
//                my_dict["r"] = rect
//
//                # access submobjects like a python dict
//                my_dict["t"].set_color(PURPLE)
//                self.play(my_dict["t"].animate.scale(3))
//                self.wait()
//
//                # also supports python dict styled reassignment
//                my_dict["t"] = Tex("Some other text").set_color(BLUE)
//                self.wait()
//
//                # remove submobject by key
//                my_dict.remove("t")
//                self.wait()
//
//                self.play(Uncreate(my_dict["s"]))
//                self.wait()
//
//                self.play(FadeOut(my_dict["c"]))
//                self.wait()
//
//                self.play(FadeOut(my_dict["r"], shift=DOWN))
//                self.wait()
//
//                # you can also make a VDict from an existing dict of mobjects
//                plain_dict = {
//                    1: Integer(1).shift(DOWN),
//                    2: Integer(2).shift(2 * DOWN),
//                    3: Integer(3).shift(3 * DOWN),
//                }
//
//                vdict_from_plain_dict = VDict(plain_dict)
//                vdict_from_plain_dict.shift(1.5 * (UP + LEFT))
//                self.play(Create(vdict_from_plain_dict))
//
//                # you can even use zip
//                vdict_using_zip = VDict(zip(["s", "c", "r"], [Square(), Circle(), Rectangle()]))
//                vdict_using_zip.shift(1.5 * RIGHT)
//                self.play(Create(vdict_using_zip))
//                self.wait()
//    """

open class VectorizedPoint : VMobject()

open class CurvesAsSubmobjects : VGroup()
//    """Convert a curve's elements to submobjects.
//
//    Examples
//    --------
//    .. manim:: LineGradientExample
//        :save_last_frame:
//
//        class LineGradientExample(Scene):
//            def construct(self):
//                curve = ParametricFunction(lambda t: [t, np.sin(t), 0], t_range=[-PI, PI, 0.01], stroke_width=10)
//                new_curve = CurvesAsSubmobjects(curve)
//                new_curve.set_color_by_gradient(BLUE, RED)
//                self.add(new_curve.shift(UP), curve)
//
//    """


open class DashedVMobject : VMobject()
//    """A :class:`VMobject` composed of dashes instead of lines.
//
//    Parameters
//    ----------
//        vmobject
//            The object that will get dashed
//        num_dashes
//            Number of dashes to add.
//        dashed_ratio
//            Ratio of dash to empty space.
//        dash_offset
//            Shifts the starting point of dashes along the
//            path. Value 1 shifts by one full dash length.
//        equal_lengths
//            If ``True``, dashes will be (approximately) equally long.
//            If ``False``, dashes will be split evenly in the curve's
//            input t variable (legacy behavior).
//
//    Examples
//    --------
//    .. manim:: DashedVMobjectExample
//        :save_last_frame:
//
//        class DashedVMobjectExample(Scene):
//            def construct(self):
//                r = 0.5
//
//                top_row = VGroup()  # Increasing num_dashes
//                for dashes in range(1, 12):
//                    circ = DashedVMobject(Circle(radius=r, color=WHITE), num_dashes=dashes)
//                    top_row.add(circ)
//
//                middle_row = VGroup()  # Increasing dashed_ratio
//                for ratio in np.arange(1 / 11, 1, 1 / 11):
//                    circ = DashedVMobject(
//                        Circle(radius=r, color=WHITE), dashed_ratio=ratio
//                    )
//                    middle_row.add(circ)
//
//                func1 = FunctionGraph(lambda t: t**5,[-1,1],color=WHITE)
//                func_even = DashedVMobject(func1,num_dashes=6,equal_lengths=True)
//                func_stretched = DashedVMobject(func1, num_dashes=6, equal_lengths=False)
//                bottom_row = VGroup(func_even,func_stretched)
//
//
//                top_row.arrange(buff=0.3)
//                middle_row.arrange()
//                bottom_row.arrange(buff=1)
//                everything = VGroup(top_row, middle_row, bottom_row).arrange(DOWN, buff=1)
//                self.add(everything)
//
//    """
