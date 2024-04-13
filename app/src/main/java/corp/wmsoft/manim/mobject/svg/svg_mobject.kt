package corp.wmsoft.manim.mobject.svg

import corp.wmsoft.manim.mobject.types.VMobject

//"""Mobjects generated from an SVG file."""


open class SVGMobject : VMobject()
//    """A vectorized mobject created from importing an SVG file.
//
//    Parameters
//    ----------
//    file_name
//        The path to the SVG file.
//    should_center
//        Whether or not the mobject should be centered after
//        being imported.
//    height
//        The target height of the mobject, set to 2 Manim units by default.
//        If the height and width are both set to ``None``, the mobject
//        is imported without being scaled.
//    width
//        The target width of the mobject, set to ``None`` by default. If
//        the height and the width are both set to ``None``, the mobject
//        is imported without being scaled.
//    color
//        The color (both fill and stroke color) of the mobject. If
//        ``None`` (the default), the colors set in the SVG file
//        are used.
//    opacity
//        The opacity (both fill and stroke opacity) of the mobject.
//        If ``None`` (the default), the opacity set in the SVG file
//        is used.
//    fill_color
//        The fill color of the mobject. If ``None`` (the default),
//        the fill colors set in the SVG file are used.
//    fill_opacity
//        The fill opacity of the mobject. If ``None`` (the default),
//        the fill opacities set in the SVG file are used.
//    stroke_color
//        The stroke color of the mobject. If ``None`` (the default),
//        the stroke colors set in the SVG file are used.
//    stroke_opacity
//        The stroke opacity of the mobject. If ``None`` (the default),
//        the stroke opacities set in the SVG file are used.
//    stroke_width
//        The stroke width of the mobject. If ``None`` (the default),
//        the stroke width values set in the SVG file are used.
//    svg_default
//        A dictionary in which fallback values for unspecified
//        properties of elements in the SVG file are defined. If
//        ``None`` (the default), ``color``, ``opacity``, ``fill_color``
//        ``fill_opacity``, ``stroke_color``, and ``stroke_opacity``
//        are set to ``None``, and ``stroke_width`` is set to 0.
//    path_string_config
//        A dictionary with keyword arguments passed to
//        :open class:`.VMobjectFromSVGPath` used for importing path elements.
//        If ``None`` (the default), no additional arguments are passed.
//    use_svg_cache
//        If True (default), the svg inputs (e.g. file_name, settings)
//        will be used as a key and a copy of the created mobject will
//        be saved using that key to be quickly retrieved if the same
//        inputs need be processed later. For large SVGs which are used
//        only once, this can be omitted to improve performance.
//    kwargs
//        Further arguments passed to the parent open class.
//    """


open class VMobjectFromSVGPath : VMobject()
//    """A vectorized mobject representing an SVG path.
//
//    .. note::
//
//        The ``long_lines``, ``should_subdivide_sharp_curves``,
//        and ``should_remove_null_curves`` keyword arguments are
//        only respected with the OpenGL renderer.
//
//    Parameters
//    ----------
//    path_obj
//        A parsed SVG path object.
//    long_lines
//        Whether or not straight lines in the vectorized mobject
//        are drawn in one or two segments.
//    should_subdivide_sharp_curves
//        Whether or not to subdivide subcurves further in case
//        two segments meet at an angle that is sharper than a
//        given threshold.
//    should_remove_null_curves
//        Whether or not to remove subcurves of length 0.
//    kwargs
//        Further keyword arguments are passed to the parent
//        open class.
//    """
