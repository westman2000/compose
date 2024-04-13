package corp.wmsoft.manim.scene

//"""A scene suitable for vector spaces."""



//# TODO: Much of this scene type seems dependent on the coordinate system chosen.
//# That is, being centered at the origin with grid units corresponding to the
//# arbitrary space units.  Change it!
//#
//# Also, methods I would have thought of as getters, like coords_to_vector, are
//# actually doing a lot of animating.
open class VectorScene : Scene()
   

open class LinearTransformationScene : VectorScene()
//    """
//    This scene contains special methods that make it
//    especially suitable for showing linear transformations.
//
//    Parameters
//    ----------
//    include_background_plane
//        Whether or not to include the background plane in the scene.
//    include_foreground_plane
//        Whether or not to include the foreground plane in the scene.
//    background_plane_kwargs
//        Parameters to be passed to :open class:`NumberPlane` to adjust the background plane.
//    foreground_plane_kwargs
//        Parameters to be passed to :open class:`NumberPlane` to adjust the foreground plane.
//    show_coordinates
//        Whether or not to include the coordinates for the background plane.
//    show_basis_vectors
//        Whether to show the basis x_axis -> ``i_hat`` and y_axis -> ``j_hat`` vectors.
//    basis_vector_stroke_width
//        The ``stroke_width`` of the basis vectors.
//    i_hat_color
//        The color of the ``i_hat`` vector.
//    j_hat_color
//        The color of the ``j_hat`` vector.
//    leave_ghost_vectors
//        Indicates the previous position of the basis vectors following a transformation.
//
//    Examples
//    -------
//
//    .. manim:: LinearTransformationSceneExample
//
//        open class LinearTransformationSceneExample(LinearTransformationScene):
//            def __init__(self, **kwargs):
//                LinearTransformationScene.__init__(
//                    self,
//                    show_coordinates=True,
//                    leave_ghost_vectors=True,
//                    **kwargs
//                )
//
//            def construct(self):
//                matrix = [[1, 1], [0, 1]]
//                self.apply_matrix(matrix)
//                self.wait()
//    """
