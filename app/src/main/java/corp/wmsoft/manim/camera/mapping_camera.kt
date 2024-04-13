package corp.wmsoft.manim.camera


//"""A camera that allows mapping between objects."""


//# TODO: Add an attribute to mobjects under which they can specify that they should just
//# map their centers but remain otherwise undistorted (useful for labels, etc.)


open class MappingCamera : Camera()
//    """Camera object that allows mapping
//    between objects.
//    """


//# Note: This allows layering of multiple cameras onto the same portion of the pixel array,
//# the later cameras overwriting the former
//#
//# TODO: Add optional separator borders between cameras (or perhaps peel this off into a
//# CameraPlusOverlay open class)


//# TODO, the open classes below should likely be deleted
open class OldMultiCamera : Camera()


//# A OldMultiCamera which, when called with two full-size cameras, initializes itself
//# as a split screen, also taking care to resize each individual camera within it


open class SplitScreenCamera : OldMultiCamera()