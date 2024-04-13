package corp.wmsoft.manim.mobject.three_d

import corp.wmsoft.manim.mobject.types.VGroup
import corp.wmsoft.manim.mobject.types.VMobject

//"""Three-dimensional mobjects."""


open class ThreeDVMobject : VMobject()
    
open class Surface : VGroup()
//    """Creates a Parametric Surface using a checkerboard pattern.
//
//    Parameters
//    ----------
//    func
//        The function defining the :open class:`Surface`.
//    u_range
//        The range of the ``u`` variable: ``(u_min, u_max)``.
//    v_range
//        The range of the ``v`` variable: ``(v_min, v_max)``.
//    resolution
//        The number of samples taken of the :open class:`Surface`. A tuple can be
//        used to define different resolutions for ``u`` and ``v`` respectively.
//    fill_color
//        The color of the :open class:`Surface`. Ignored if ``checkerboard_colors``
//        is set.
//    fill_opacity
//        The opacity of the :open class:`Surface`, from 0 being fully transparent
//        to 1 being fully opaque. Defaults to 1.
//    checkerboard_colors
//        ng individual faces alternating colors. Overrides ``fill_color``.
//    stroke_color
//        Color of the stroke surrounding each face of :open class:`Surface`.
//    stroke_width
//        Width of the stroke surrounding each face of :open class:`Surface`.
//        Defaults to 0.5.
//    should_make_jagged
//        Changes the anchor mode of the Bézier curves from smooth to jagged.
//        Defaults to ``False``.
//
//    Examples
//    --------
//    .. manim:: ParaSurface
//        :save_last_frame:
//
//        open class ParaSurface(ThreeDScene):
//            def func(self, u, v):
//                return np.array([np.cos(u) * np.cos(v), np.cos(u) * np.sin(v), u])
//
//            def construct(self):
//                axes = ThreeDAxes(x_range=[-4,4], x_length=8)
//                surface = Surface(
//                    lambda u, v: axes.c2p(*self.func(u, v)),
//                    u_range=[-PI, PI],
//                    v_range=[0, TAU],
//                    resolution=8,
//                )
//                self.set_camera_orientation(theta=70 * DEGREES, phi=75 * DEGREES)
//                self.add(axes, surface)
//    """


//# Specific shapes


open class Sphere : Surface()
//    """A three-dimensional sphere.
//
//    Parameters
//    ----------
//    center
//        Center of the :open class:`Sphere`.
//    radius
//        The radius of the :open class:`Sphere`.
//    resolution
//        The number of samples taken of the :open class:`Sphere`. A tuple can be used
//        to define different resolutions for ``u`` and ``v`` respectively.
//    u_range
//        The range of the ``u`` variable: ``(u_min, u_max)``.
//    v_range
//        The range of the ``v`` variable: ``(v_min, v_max)``.
//
//    Examples
//    --------
//
//    .. manim:: ExampleSphere
//        :save_last_frame:
//
//        open class ExampleSphere(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=PI / 6, theta=PI / 6)
//                sphere1 = Sphere(
//                    center=(3, 0, 0),
//                    radius=1,
//                    resolution=(20, 20),
//                    u_range=[0.001, PI - 0.001],
//                    v_range=[0, TAU]
//                )
//                sphere1.set_color(RED)
//                self.add(sphere1)
//                sphere2 = Sphere(center=(-1, -3, 0), radius=2, resolution=(18, 18))
//                sphere2.set_color(GREEN)
//                self.add(sphere2)
//                sphere3 = Sphere(center=(-1, 2, 0), radius=2, resolution=(16, 16))
//                sphere3.set_color(BLUE)
//                self.add(sphere3)
//    """


open class Dot3D : Sphere()
//    """A spherical dot.
//
//    Parameters
//    ----------
//    point
//        The location of the dot.
//    radius
//        The radius of the dot.
//    color
//        The color of the :open class:`Dot3D`.
//    resolution
//        The number of samples taken of the :open class:`Dot3D`. A tuple can be
//        used to define different resolutions for ``u`` and ``v`` respectively.
//
//    Examples
//    --------
//
//    .. manim:: Dot3DExample
//        :save_last_frame:
//
//        open class Dot3DExample(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75*DEGREES, theta=-45*DEGREES)
//
//                axes = ThreeDAxes()
//                dot_1 = Dot3D(point=axes.coords_to_point(0, 0, 1), color=RED)
//                dot_2 = Dot3D(point=axes.coords_to_point(2, 0, 0), radius=0.1, color=BLUE)
//                dot_3 = Dot3D(point=[0, 0, 0], radius=0.1, color=ORANGE)
//                self.add(axes, dot_1, dot_2,dot_3)
//    """


open class Cube : VGroup()
//    """A three-dimensional cube.
//
//    Parameters
//    ----------
//    side_length
//        Length of each side of the :open class:`Cube`.
//    fill_opacity
//        The opacity of the :open class:`Cube`, from 0 being fully transparent to 1 being
//        fully opaque. Defaults to 0.75.
//    fill_color
//        The color of the :open class:`Cube`.
//    stroke_width
//        The width of the stroke surrounding each face of the :open class:`Cube`.
//
//    Examples
//    --------
//
//    .. manim:: CubeExample
//        :save_last_frame:
//
//        open class CubeExample(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75*DEGREES, theta=-45*DEGREES)
//
//                axes = ThreeDAxes()
//                cube = Cube(side_length=3, fill_opacity=0.7, fill_color=BLUE)
//                self.add(cube)
//    """


open class Prism : Cube()
//    """A right rectangular prism (or rectangular cuboid).
//    Defined by the length of each side in ``[x, y, z]`` format.
//
//    Parameters
//    ----------
//    dimensions
//        Dimensions of the :open class:`Prism` in ``[x, y, z]`` format.
//
//    Examples
//    --------
//
//    .. manim:: ExamplePrism
//        :save_last_frame:
//
//        open class ExamplePrism(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=60 * DEGREES, theta=150 * DEGREES)
//                prismSmall = Prism(dimensions=[1, 2, 3]).rotate(PI / 2)
//                prismLarge = Prism(dimensions=[1.5, 3, 4.5]).move_to([2, 0, 0])
//                self.add(prismSmall, prismLarge)
//    """


open class Cone : Surface()
//    """A circular cone.
//    Can be defined using 2 parameters: its height, and its base radius.
//    The polar angle, theta, can be calculated using arctan(base_radius /
//    height) The spherical radius, r, is calculated using the pythagorean
//    theorem.
//
//    Parameters
//    ----------
//    base_radius
//        The base radius from which the cone tapers.
//    height
//        The height measured from the plane formed by the base_radius to
//        the apex of the cone.
//    direction
//        The direction of the apex.
//    show_base
//        Whether to show the base plane or not.
//    v_range
//        The azimuthal angle to start and end at.
//    u_min
//        The radius at the apex.
//    checkerboard_colors
//        Show checkerboard grid texture on the cone.
//
//    Examples
//    --------
//    .. manim:: ExampleCone
//        :save_last_frame:
//
//        open class ExampleCone(ThreeDScene):
//            def construct(self):
//                axes = ThreeDAxes()
//                cone = Cone(direction=X_AXIS+Y_AXIS+2*Z_AXIS, resolution=8)
//                self.set_camera_orientation(phi=5*PI/11, theta=PI/9)
//                self.add(axes, cone)
//    """


open class Cylinder : Surface()
//    """A cylinder, defined by its height, radius and direction,
//
//    Parameters
//    ----------
//    radius
//        The radius of the cylinder.
//    height
//        The height of the cylinder.
//    direction
//        The direction of the central axis of the cylinder.
//    v_range
//        The height along the height axis (given by direction) to start and end on.
//    show_ends
//        Whether to show the end caps or not.
//    resolution
//        The number of samples taken of the :open class:`Cylinder`. A tuple can be used
//        to define different resolutions for ``u`` and ``v`` respectively.
//
//    Examples
//    --------
//    .. manim:: ExampleCylinder
//        :save_last_frame:
//
//        open class ExampleCylinder(ThreeDScene):
//            def construct(self):
//                axes = ThreeDAxes()
//                cylinder = Cylinder(radius=2, height=3)
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                self.add(axes, cylinder)
//    """

    

open class Line3D : Cylinder()
//    """A cylindrical line, for use in ThreeDScene.
//
//    Parameters
//    ----------
//    start
//        The start point of the line.
//    end
//        The end point of the line.
//    thickness
//        The thickness of the line.
//    color
//        The color of the line.
//
//    Examples
//    --------
//    .. manim:: ExampleLine3D
//        :save_last_frame:
//
//        open class ExampleLine3D(ThreeDScene):
//            def construct(self):
//                axes = ThreeDAxes()
//                line = Line3D(start=np.array([0, 0, 0]), end=np.array([2, 2, 2]))
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                self.add(axes, line)
//    """

   

open class Arrow3D : Line3D()
//    """An arrow made out of a cylindrical line and a conical tip.
//
//    Parameters
//    ----------
//    start
//        The start position of the arrow.
//    end
//        The end position of the arrow.
//    thickness
//        The thickness of the arrow.
//    height
//        The height of the conical tip.
//    base_radius
//        The base radius of the conical tip.
//    color
//        The color of the arrow.
//
//    Examples
//    --------
//    .. manim:: ExampleArrow3D
//        :save_last_frame:
//
//        open class ExampleArrow3D(ThreeDScene):
//            def construct(self):
//                axes = ThreeDAxes()
//                arrow = Arrow3D(
//                    start=np.array([0, 0, 0]),
//                    end=np.array([2, 2, 2]),
//                    resolution=8
//                )
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                self.add(axes, arrow)
//    """

    

open class Torus : Surface()
//    """A torus.
//
//    Parameters
//    ----------
//    major_radius
//        Distance from the center of the tube to the center of the torus.
//    minor_radius
//        Radius of the tube.
//    u_range
//        The range of the ``u`` variable: ``(u_min, u_max)``.
//    v_range
//        The range of the ``v`` variable: ``(v_min, v_max)``.
//    resolution
//        The number of samples taken of the :open class:`Torus`. A tuple can be
//        used to define different resolutions for ``u`` and ``v`` respectively.
//
//    Examples
//    --------
//    .. manim :: ExampleTorus
//        :save_last_frame:
//
//        open class ExampleTorus(ThreeDScene):
//            def construct(self):
//                axes = ThreeDAxes()
//                torus = Torus()
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                self.add(axes, torus)
//    """

    