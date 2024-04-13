package corp.wmsoft.manim.mobject.types

import corp.wmsoft.manim.mobject.Mobject

// """Mobjects representing raster images."""

//    """
//    Automatically filters out black pixels
//
//    Parameters
//    ----------
//    scale_to_resolution
//        At this resolution the image is placed pixel by pixel onto the screen, so it
//        will look the sharpest and best.
//        This is a custom parameter of ImageMobject so that rendering a scene with
//        e.g. the ``--quality low`` or ``--quality medium`` flag for faster rendering
//        won't effect the position of the image on the screen.
//    """
open class AbstractImageMobject : Mobject()



//    """Displays an Image from a numpy array or a file.
//
//    Parameters
//    ----------
//    scale_to_resolution
//        At this resolution the image is placed pixel by pixel onto the screen, so it
//        will look the sharpest and best.
//        This is a custom parameter of ImageMobject so that rendering a scene with
//        e.g. the ``--quality low`` or ``--quality medium`` flag for faster rendering
//        won't effect the position of the image on the screen.
//
//
//    Example
//    -------
//    .. manim:: ImageFromArray
//        :save_last_frame:
//
//        class ImageFromArray(Scene):
//            def construct(self):
//                image = ImageMobject(np.uint8([[0, 100, 30, 200],
//                                               [255, 0, 5, 33]]))
//                image.height = 7
//                self.add(image)
//
//
//    Changing interpolation style:
//
//    .. manim:: ImageInterpolationEx
//        :save_last_frame:
//
//        class ImageInterpolationEx(Scene):
//            def construct(self):
//                img = ImageMobject(np.uint8([[63, 0, 0, 0],
//                                                [0, 127, 0, 0],
//                                                [0, 0, 191, 0],
//                                                [0, 0, 0, 255]
//                                                ]))
//
//                img.height = 2
//                img1 = img.copy()
//                img2 = img.copy()
//                img3 = img.copy()
//                img4 = img.copy()
//                img5 = img.copy()
//
//                img1.set_resampling_algorithm(RESAMPLING_ALGORITHMS["nearest"])
//                img2.set_resampling_algorithm(RESAMPLING_ALGORITHMS["lanczos"])
//                img3.set_resampling_algorithm(RESAMPLING_ALGORITHMS["linear"])
//                img4.set_resampling_algorithm(RESAMPLING_ALGORITHMS["cubic"])
//                img5.set_resampling_algorithm(RESAMPLING_ALGORITHMS["box"])
//                img1.add(Text("nearest").scale(0.5).next_to(img1,UP))
//                img2.add(Text("lanczos").scale(0.5).next_to(img2,UP))
//                img3.add(Text("linear").scale(0.5).next_to(img3,UP))
//                img4.add(Text("cubic").scale(0.5).next_to(img4,UP))
//                img5.add(Text("box").scale(0.5).next_to(img5,UP))
//
//                x= Group(img1,img2,img3,img4,img5)
//                x.arrange()
//                self.add(x)
//    """
class ImageMobject : AbstractImageMobject()
class ImageMobjectFromCamera : AbstractImageMobject()
