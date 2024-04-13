package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

// """Animate mobjects."""


/**
    An animation.

    Animations have a fixed time span.

    Parameters
    ----------
    mobject
    The mobject to be animated. This is not required for all types of animations.
    lag_ratio
    Defines the delay after which the animation is applied to submobjects. This lag
    is relative to the duration of the animation.

    This does not influence the total
    runtime of the animation. Instead the runtime of individual animations is
    adjusted so that the complete animation has the defined run time.

    run_time
    The duration of the animation in seconds.
    rate_func
    The function defining the animation progress based on the relative runtime (see  :mod:`~.rate_functions`) .

    For example ``rate_func(0.5)`` is the proportion of the animation that is done
    after half of the animations run time.


    reverse_rate_function
    Reverses the rate function of the animation. Setting ``reverse_rate_function``
    does not have any effect on ``remover`` or ``introducer``. These need to be
    set explicitly if an introducer-animation should be turned into a remover one
    and vice versa.
    name
    The name of the animation. This gets displayed while rendering the animation.
    Defaults to <class-name>(<Mobject-name>).
    remover
    Whether the given mobject should be removed from the scene after this animation.
    suspend_mobject_updating
    Whether updaters of the mobject should be suspended during the animation.


    .. NOTE::

    In the current implementation of this class, the specified rate function is applied
    within :meth:`.Animation.interpolate_mobject` call as part of the call to
    :meth:`.Animation.interpolate_submobject`. For subclasses of :class:`.Animation`
    that are implemented by overriding :meth:`interpolate_mobject`, the rate function
    has to be applied manually (e.g., by passing ``self.rate_func(alpha)`` instead
    of just ``alpha``).


    Examples
    --------

    .. manim:: LagRatios

    class LagRatios(Scene):
    def construct(self):
    ratios = [0, 0.1, 0.5, 1, 2]  # demonstrated lag_ratios

    # Create dot groups
    group = VGroup(*[Dot() for _ in range(4)]).arrange_submobjects()
    groups = VGroup(*[group.copy() for _ in ratios]).arrange_submobjects(buff=1)
    self.add(groups)

    # Label groups
    self.add(Text("lag_ratio = ", font_size=36).next_to(groups, UP, buff=1.5))
    for group, ratio in zip(groups, ratios):
    self.add(Text(str(ratio), font_size=36).next_to(group, UP))

    #Animate groups with different lag_ratios
    self.play(AnimationGroup(*[
    group.animate(lag_ratio=ratio, run_time=1.5).shift(DOWN * 2)
    for group, ratio in zip(groups, ratios)
    ]))

    # lag_ratio also works recursively on nested submobjects:
    self.play(groups.animate(run_time=1, lag_ratio=0.1).shift(UP * 2))


 */
open class Animation(open val mobject : Mobject) {
    /**
    """Begin the animation.

    This method is called right as an animation is being played. As much
    initialization as possible, especially any mobject copying, should live in this
    method.

    """
     */
    fun begin() {}

    /**
    # TODO: begin and finish should require a scene as parameter.
    # That way Animation.clean_up_from_screen and Scene.add_mobjects_from_animations
    # could be removed as they fulfill basically the same purpose.
    """Finish the animation.

    This method gets called when the animation is over.

    """
     */
    fun finish() {}
}


/**
"""A "no operation" animation.

Parameters
----------
run_time
The amount of time that should pass.
stop_condition
A function without positional arguments that evaluates to a boolean.
The function is evaluated after every new frame has been rendered.
Playing the animation stops after the return value is truthy, or
after the specified ``run_time`` has passed.
frozen_frame
Controls whether or not the wait animation is static, i.e., corresponds
to a frozen frame. If ``False`` is passed, the render loop still
progresses through the animation as usual and (among other things)
continues to call updater functions. If ``None`` (the default value),
the :meth:`.Scene.play` call tries to determine whether the Wait call
can be static or not itself via :meth:`.Scene.should_mobjects_update`.
kwargs
Keyword arguments to be passed to the parent class, :class:`.Animation`.
"""
 */
class Wait(mobject: Mobject) : Animation(mobject)