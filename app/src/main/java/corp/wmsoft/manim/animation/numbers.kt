package corp.wmsoft.manim.animation

import corp.wmsoft.manim.mobject.Mobject

//"""Animations for changing numbers."""


open class ChangingDecimal(mobject: Mobject) : Animation(mobject)

open class ChangeDecimalToValue(mobject: Mobject) : ChangingDecimal(mobject)

