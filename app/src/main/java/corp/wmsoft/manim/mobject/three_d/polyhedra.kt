package corp.wmsoft.manim.mobject.three_d

import corp.wmsoft.manim.mobject.types.VGroup

//"""General polyhedral open class and platonic solids."""


open class Polyhedron : VGroup()
//    """An abstract polyhedra open class.
//
//    In this implementation, polyhedra are defined with a list of vertex coordinates in space, and a list
//    of faces. This implementation mirrors that of a standard polyhedral data format (OFF, object file format).
//
//    Parameters——
//    ----------
//    vertex_coords
//        A list of coordinates of the corresponding vertices in the polyhedron. Each coordinate will correspond to
//        a vertex. The vertices are indexed with the usual indexing of Python.
//    faces_list
//        A list of faces. Each face is a sublist containing the indices of the vertices that form the corners of that face.
//    faces_config
//        Configuration for the polygons representing the faces of the polyhedron.
//    graph_config
//        Configuration for the graph containing the vertices and edges of the polyhedron.
//
//    Examples
//    --------
//    To understand how to create a custom polyhedra, let's use the example of a rather simple one - a square pyramid.
//
//    .. manim:: SquarePyramidScene
//        :save_last_frame:
//
//        open class SquarePyramidScene(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                vertex_coords = [
//                    [1, 1, 0],
//                    [1, -1, 0],
//                    [-1, -1, 0],
//                    [-1, 1, 0],
//                    [0, 0, 2]
//                ]
//                faces_list = [
//                    [0, 1, 4],
//                    [1, 2, 4],
//                    [2, 3, 4],
//                    [3, 0, 4],
//                    [0, 1, 2, 3]
//                ]
//                pyramid = Polyhedron(vertex_coords, faces_list)
//                self.add(pyramid)
//
//    In defining the polyhedron above, we first defined the coordinates of the vertices.
//    These are the corners of the square base, given as the first four coordinates in the vertex list,
//    and the apex, the last coordinate in the list.
//
//    Next, we define the faces of the polyhedron. The triangular surfaces of the pyramid are polygons
//    with two adjacent vertices in the base and the vertex at the apex as corners. We thus define these
//    surfaces in the first four elements of our face list. The last element defines the base of the pyramid.
//
//    The graph and faces of polyhedra can also be accessed and modified directly, after instantiation.
//    They are stored in the `graph` and `faces` attributes respectively.
//
//    .. manim:: PolyhedronSubMobjects
//        :save_last_frame:
//
//        open class PolyhedronSubMobjects(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                octahedron = Octahedron(edge_length = 3)
//                octahedron.graph[0].set_color(RED)
//                octahedron.faces[2].set_color(YELLOW)
//                self.add(octahedron)
//    """


open class Tetrahedron : Polyhedron()
//    """A tetrahedron, one of the five platonic solids. It has 4 faces, 6 edges, and 4 vertices.
//
//    Parameters
//    ----------
//    edge_length
//        The length of an edge between any two vertices.
//
//    Examples
//    --------
//
//    .. manim:: TetrahedronScene
//        :save_last_frame:
//
//        open class TetrahedronScene(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                obj = Tetrahedron()
//                self.add(obj)
//    """


open class Octahedron : Polyhedron()
//    """An octahedron, one of the five platonic solids. It has 8 faces, 12 edges and 6 vertices.
//
//    Parameters
//    ----------
//    edge_length
//        The length of an edge between any two vertices.—
//
//    Examples
//    --------
//
//    .. manim:: OctahedronScene
//        :save_last_frame:
//
//        open class OctahedronScene(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                obj = Octahedron()
//                self.add(obj)
//    """

open class Icosahedron : Polyhedron()
//    """An icosahedron, one of the five platonic solids. It has 20 faces, 30 edges and 12 vertices.
//
//    Parameters
//    ----------
//    edge_length
//        The length of an edge between any two vertices.
//
//    Examples
//    --------
//
//    .. manim:: IcosahedronScene
//        :save_last_frame:
//
//        open class IcosahedronScene(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                obj = Icosahedron()
//                self.add(obj)
//    """


open class Dodecahedron : Polyhedron()
//    """A dodecahedron, one of the five platonic solids. It has 12 faces, 30 edges and 20 vertices.
//
//    Parameters
//    ----------
//    edge_length
//        The length of an edge between any two vertices.
//
//    Examples
//    --------
//
//    .. manim:: DodecahedronScene
//        :save_last_frame:
//
//        open class DodecahedronScene(ThreeDScene):
//            def construct(self):
//                self.set_camera_orientation(phi=75 * DEGREES, theta=30 * DEGREES)
//                obj = Dodecahedron()
//                self.add(obj)
//    """
