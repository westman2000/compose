package corp.wmsoft.manim.scene

import corp.wmsoft.manim.animation.Animation
import corp.wmsoft.manim.mobject.Mobject


/**
//"""Basic canvas for animations."""
//open class RerunSceneHandler : FileSystemEventHandler()
//    """A open class to handle rerunning a Scene after the input file is modified."""
**/

/**
//    """A Scene is the canvas of your animation.
//
//    The primary role of :open class:`Scene` is to provide the user with tools to manage
//    mobjects and animations.  Generally speaking, a manim script consists of a open class
//    that derives from :open class:`Scene` whose :meth:`Scene.construct` method is overridden
//    by the user's code.
//
//    Mobjects are displayed on screen by calling :meth:`Scene.add` and removed from
//    screen by calling :meth:`Scene.remove`.  All mobjects currently on screen are kept
//    in :attr:`Scene.mobjects`.  Animations are played by calling :meth:`Scene.play`.
//
//    A :open class:`Scene` is rendered internally by calling :meth:`Scene.render`.  This in
//    turn calls :meth:`Scene.setup`, :meth:`Scene.construct`, and
//    :meth:`Scene.tear_down`, in that order.
//
//    It is not recommended to override the ``__init__`` method in user Scenes.  For code
//    that should be ran before a Scene is rendered, use :meth:`Scene.setup` instead.
//
//    Examples
//    --------
//    Override the :meth:`Scene.construct` method with your code.
//
//    .. code-block:: python
//
//        open class MyScene(Scene):
//            fun construct(self):
//                self.play(Write(Text("Hello World!")))
//
//    """
 */
open class Scene {

    /**
     *
     *     """
     *         Renders this Scene.
     *
     *         Parameters
     *         ---------
     *         preview
     *             If true, opens scene in a file viewer.
     *         """
     */
    fun render() {}

    /**
     *     """
     *         This is meant to be implemented by any scenes which
     *         are commonly subclassed, and have some common setup
     *         involved before the construct method is called.
     *         """
     */
    fun setup() {}

    /**
     * """
     *         This is meant to be implemented by any scenes which
     *         are commonly subclassed, and have some common method
     *         to be invoked before the scene ends.
     *         """
     */
    fun tear_down() {}

    /**
     * //    """Add content to the Scene.
     * //
     * //        From within :meth:`Scene.construct`, display mobjects on screen by calling
     * //        :meth:`Scene.add` and remove them from screen by calling :meth:`Scene.remove`.
     * //        All mobjects currently on screen are kept in :attr:`Scene.mobjects`.  Play
     * //        animations by calling :meth:`Scene.play`.
     * //
     * //        Notes
     * //        -----
     * //        Initialization code should go in :meth:`Scene.setup`.  Termination code should
     * //        go in :meth:`Scene.tear_down`.
     * //
     * //        Examples
     * //        --------
     * //        A typical manim script includes a class derived from :class:`Scene` with an
     * //        overridden :meth:`Scene.contruct` method:
     * //
     * //        .. code-block:: python
     * //
     * //            class MyScene(Scene):
     * //                fun construct(self):
     * //                    self.play(Write(Text("Hello World!")))
     * //
     * //        See Also
     * //        --------
     * //        :meth:`Scene.setup`
     * //        :meth:`Scene.render`
     * //        :meth:`Scene.tear_down`
     * //
     * //        """
     * //    pass  # To be implemented in subclasses
     */
    fun construct() {}

    /**
     * """
     *         Mobjects will be displayed, from background to
     *         foreground in the order with which they are added.
     *
     *         Parameters
     *         ---------
     *         *mobjects
     *             Mobjects to add.
     *
     *         Returns
     *         -------
     *         Scene
     *             The same scene after adding the Mobjects in.
     *
     *         """
     */
    fun add(vararg mobjects : Mobject) {}

    /**
     * """
     *         Removes mobjects in the passed list of mobjects
     *         from the scene and the foreground, by removing them
     *         from "mobjects" and "foreground_mobjects"
     *
     *         Parameters
     *         ----------
     *         *mobjects
     *             The mobjects to remove.
     *         """
     */
    fun remove(vararg mobjects: Mobject) {}

    /**
     * """
     *         Removes all mobjects present in self.mobjects
     *         and self.foreground_mobjects from the scene.
     *
     *         Returns
     *         ------
     *         Scene
     *             The Scene, with all of its mobjects in
     *             self.mobjects and self.foreground_mobjects
     *             removed.
     *         """
     *     self.mobjects = []
     *     self.foreground_mobjects = []
     *     return self
     */
    fun clear() {}

    /**
     *  r"""Plays an animation in this scene.
     *
     *         Parameters
     *         ----------
     *
     *         args
     *             Animations to be played.
     *         subcaption
     *             The content of the external subcaption that should
     *             be added during the animation.
     *         subcaption_duration
     *             The duration for which the specified subcaption is
     *             added. If ``None`` (the funault), the run time of the
     *             animation is taken.
     *         subcaption_offset
     *             An offset (in seconds) for the start time of the
     *             added subcaption.
     *         kwargs
     *             All other keywords are passed to the renderer.
     *
     *         """
     *     # If we are in interactive embedded mode, make sure this is running on the main thread (required for OpenGL)
     *
     */
    fun play(vararg args: Animation) {}

}

// short version
fun scene(init: Scene.() -> Unit) = Scene().apply(init)
// long version
//fun scene(init: Scene.() -> Unit): Scene {
//    val scene = Scene()
//    scene.init()
//    return scene
//}
