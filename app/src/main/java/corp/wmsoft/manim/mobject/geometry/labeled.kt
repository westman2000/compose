package corp.wmsoft.manim.mobject.geometry

//r"""Mobjects that inherit from lines and contain a label along the length."""


open class LabeledLine : Line()
//    """Constructs a line containing a label box somewhere along its length.
//
//    Parameters
//    ----------
//    label : str | Tex | MathTex | Text
//        Label that will be displayed on the line.
//    label_position : float | optional
//        A ratio in the range [0-1] to indicate the position of the label with respect to the length of the line. Default value is 0.5.
//    font_size : float | optional
//        Control font size for the label. This parameter is only used when `label` is of type `str`.
//    label_color: ParsableManimColor | optional
//        The color of the label's text. This parameter is only used when `label` is of type `str`.
//    label_frame : Bool | optional
//        Add a `SurroundingRectangle` frame to the label box.
//    frame_fill_color : ParsableManimColor | optional
//        Background color to fill the label box. If no value is provided, the background color of the canvas will be used.
//    frame_fill_opacity : float | optional
//        Determine the opacity of the label box by passing a value in the range [0-1], where 0 indicates complete transparency and 1 means full opacity.
//
//    .. seealso::
//        :class:`LabeledArrow`
//
//    Examples
//    --------
//    .. manim:: LabeledLineExample
//        :save_last_frame:
//
//        class LabeledLineExample(Scene):
//            def construct(self):
//                line = LabeledLine(
//                    label          = '0.5',
//                    label_position = 0.8,
//                    font_size      = 20,
//                    label_color    = WHITE,
//                    label_frame    = True,
//
//                    start=LEFT+DOWN,
//                    end=RIGHT+UP)
//
//
//                line.set_length(line.get_length() * 2)
//                self.add(line)
//    """

class LabeledArrow : LabeledLine()
//    """Constructs an arrow containing a label box somewhere along its length.
//    This class inherits its label properties from `LabeledLine`, so the main parameters controlling it are the same.
//
//    Parameters
//    ----------
//    label : str | Tex | MathTex | Text
//        Label that will be displayed on the line.
//    label_position : float | optional
//        A ratio in the range [0-1] to indicate the position of the label with respect to the length of the line. Default value is 0.5.
//    font_size : float | optional
//        Control font size for the label. This parameter is only used when `label` is of type `str`.
//    label_color: ParsableManimColor | optional
//        The color of the label's text. This parameter is only used when `label` is of type `str`.
//    label_frame : Bool | optional
//        Add a `SurroundingRectangle` frame to the label box.
//    frame_fill_color : ParsableManimColor | optional
//        Background color to fill the label box. If no value is provided, the background color of the canvas will be used.
//    frame_fill_opacity : float | optional
//        Determine the opacity of the label box by passing a value in the range [0-1], where 0 indicates complete transparency and 1 means full opacity.
//
//
//    .. seealso::
//        :class:`LabeledLine`
//
//    Examples
//    --------
//    .. manim:: LabeledArrowExample
//        :save_last_frame:
//
//        class LabeledArrowExample(Scene):
//            def construct(self):
//                l_arrow = LabeledArrow("0.5", start=LEFT*3, end=RIGHT*3 + UP*2, label_position=0.5)
//
//                self.add(l_arrow)
//    """

