package corp.wmsoft.drawcompose.example

import corp.wmsoft.manim.animation.Create
import corp.wmsoft.manim.mobject.geometry.Circle
import corp.wmsoft.manim.scene.scene

class ManimController {

    init {

        scene {
            val circle = Circle()
            play(
                Create(circle)
            )
        }

    }
}