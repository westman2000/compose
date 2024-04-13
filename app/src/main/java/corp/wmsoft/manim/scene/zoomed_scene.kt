package corp.wmsoft.manim.scene

//"""A scene supporting zooming in on a specified section.


//Examples
//--------
//
//.. manim:: UseZoomedScene
//
//    class UseZoomedScene(ZoomedScene):
//        def construct(self):
//            dot = Dot().set_color(GREEN)
//            self.add(dot)
//            self.wait(1)
//            self.activate_zooming(animate=False)
//            self.wait(1)
//            self.play(dot.animate.shift(LEFT))
//
//.. manim:: ChangingZoomScale
//
//    class ChangingZoomScale(ZoomedScene):
//        def __init__(self, **kwargs):
//            ZoomedScene.__init__(
//                self,
//                zoom_factor=0.3,
//                zoomed_display_height=1,
//                zoomed_display_width=3,
//                image_frame_stroke_width=20,
//                zoomed_camera_config={
//                    "default_frame_stroke_width": 3,
//                },
//                **kwargs
//            )
//
//        def construct(self):
//            dot = Dot().set_color(GREEN)
//            sq = Circle(fill_opacity=1, radius=0.2).next_to(dot, RIGHT)
//            self.add(dot, sq)
//            self.wait(1)
//            self.activate_zooming(animate=False)
//            self.wait(1)
//            self.play(dot.animate.shift(LEFT * 0.3))
//
//            self.play(self.zoomed_camera.frame.animate.scale(4))
//            self.play(self.zoomed_camera.frame.animate.shift(0.5 * DOWN))
//
//"""

//# Note, any scenes from old videos using ZoomedScene will almost certainly
//# break, as it was restructured.


class ZoomedScene : MovingCameraScene()
//    """
//    This is a Scene with special configurations made for when
//    a particular part of the scene must be zoomed in on and displayed
//    separately.
//    """
