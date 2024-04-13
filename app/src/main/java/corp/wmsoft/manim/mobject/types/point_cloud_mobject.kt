package corp.wmsoft.manim.mobject.types

import corp.wmsoft.manim.mobject.Mobject

//"""Mobjects representing point clouds."""


open class PMobject : Mobject()
//    """A disc made of a cloud of Dots
//
//    Examples
//    --------
//
//    .. manim:: PMobjectExample
//        :save_last_frame:
//
//        class PMobjectExample(Scene):
//            def construct(self):
//
//                pG = PGroup()  # This is just a collection of PMobject's
//
//                # As the scale factor increases, the number of points
//                # removed increases.
//                for sf in range(1, 9 + 1):
//                    p = PointCloudDot(density=20, radius=1).thin_out(sf)
//                    # PointCloudDot is a type of PMobject
//                    # and can therefore be added to a PGroup
//                    pG.add(p)
//
//                # This organizes all the shapes in a grid.
//                pG.arrange_in_grid()
//
//                self.add(pG)
//
//    """

open class Mobject1D : PMobject()


open class Mobject2D : PMobject()


class PGroup : PMobject()
//    """A group for several point mobjects.
//
//    Examples
//    --------
//
//    .. manim:: PgroupExample
//        :save_last_frame:
//
//        class PgroupExample(Scene):
//            def construct(self):
//
//                p1 = PointCloudDot(radius=1, density=20, color=BLUE)
//                p1.move_to(4.5 * LEFT)
//                p2 = PointCloudDot()
//                p3 = PointCloudDot(radius=1.5, stroke_width=2.5, color=PINK)
//                p3.move_to(4.5 * RIGHT)
//                pList = PGroup(p1, p2, p3)
//
//                self.add(pList)
//
//    """


class PointCloudDot : Mobject1D()
//    """A disc made of a cloud of dots.
//
//    Examples
//    --------
//    .. manim:: PointCloudDotExample
//        :save_last_frame:
//
//        class PointCloudDotExample(Scene):
//            def construct(self):
//                cloud_1 = PointCloudDot(color=RED)
//                cloud_2 = PointCloudDot(stroke_width=4, radius=1)
//                cloud_3 = PointCloudDot(density=15)
//
//                group = Group(cloud_1, cloud_2, cloud_3).arrange()
//                self.add(group)
//
//    .. manim:: PointCloudDotExample2
//
//        class PointCloudDotExample2(Scene):
//            def construct(self):
//                plane = ComplexPlane()
//                cloud = PointCloudDot(color=RED)
//                self.add(
//                    plane, cloud
//                )
//                self.wait()
//                self.play(
//                    cloud.animate.apply_complex_function(lambda z: np.exp(z))
//                )
//    """


class Point : PMobject()
//    """A mobject representing a point.
//
//    Examples
//    --------
//
//    .. manim:: ExamplePoint
//        :save_last_frame:
//
//        class ExamplePoint(Scene):
//            def construct(self):
//                colorList = [RED, GREEN, BLUE, YELLOW]
//                for i in range(200):
//                    point = Point(location=[0.63 * np.random.randint(-4, 4), 0.37 * np.random.randint(-4, 4), 0], color=np.random.choice(colorList))
//                    self.add(point)
//                for i in range(200):
//                    point = Point(location=[0.37 * np.random.randint(-4, 4), 0.63 * np.random.randint(-4, 4), 0], color=np.random.choice(colorList))
//                    self.add(point)
//                self.add(point)
//    """
