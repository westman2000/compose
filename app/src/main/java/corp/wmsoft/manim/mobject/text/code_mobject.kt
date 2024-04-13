package corp.wmsoft.manim.mobject.text

import corp.wmsoft.manim.mobject.types.VGroup

//"""Mobject representing highlighted source code listings."""

open class Code : VGroup()
//    """A highlighted source code listing.
//
//    An object ``listing`` of :class:`.Code` is a :class:`.VGroup` consisting
//    of three objects:
//
//    - The background, ``listing.background_mobject``. This is either
//      a :class:`.Rectangle` (if the listing has been initialized with
//      ``background="rectangle"``, the default option) or a :class:`.VGroup`
//      resembling a window (if ``background="window"`` has been passed).
//
//    - The line numbers, ``listing.line_numbers`` (a :class:`.Paragraph`
//      object).
//
//    - The highlighted code itself, ``listing.code`` (a :class:`.Paragraph`
//      object).
//
//    .. WARNING::
//
//        Using a :class:`.Transform` on text with leading whitespace (and in
//        this particular case: code) can look
//        `weird <https://github.com/3b1b/manim/issues/1067>`_. Consider using
//        :meth:`remove_invisible_chars` to resolve this issue.
//
//    Examples
//    --------
//
//    Normal usage::
//
//        listing = Code(
//            "helloworldcpp.cpp",
//            tab_width=4,
//            background_stroke_width=1,
//            background_stroke_color=WHITE,
//            insert_line_no=True,
//            style=Code.styles_list[15],
//            background="window",
//            language="cpp",
//        )
//
//    We can also render code passed as a string (but note that
//    the language has to be specified in this case):
//
//    .. manim:: CodeFromString
//        :save_last_frame:
//
//        class CodeFromString(Scene):
//            def construct(self):
//                code = '''from manim import Scene, Square
//
//        class FadeInSquare(Scene):
//            def construct(self):
//                s = Square()
//                self.play(FadeIn(s))
//                self.play(s.animate.scale(2))
//                self.wait()
//        '''
//                rendered_code = Code(code=code, tab_width=4, background="window",
//                                    language="Python", font="Monospace")
//                self.add(rendered_code)
//
//    Parameters
//    ----------
//    file_name
//        Name of the code file to display.
//    code
//        If ``file_name`` is not specified, a code string can be
//        passed directly.
//    tab_width
//        Number of space characters corresponding to a tab character. Defaults to 3.
//    line_spacing
//        Amount of space between lines in relation to font size. Defaults to 0.3, which means 30% of font size.
//    font_size
//        A number which scales displayed code. Defaults to 24.
//    font
//        The name of the text font to be used. Defaults to ``"Monospace"``.
//        This is either a system font or one loaded with `text.register_font()`. Note
//        that font family names may be different across operating systems.
//    stroke_width
//        Stroke width for text. 0 is recommended, and the default.
//    margin
//        Inner margin of text from the background. Defaults to 0.3.
//    indentation_chars
//        "Indentation chars" refers to the spaces/tabs at the beginning of a given code line. Defaults to ``"    "`` (spaces).
//    background
//        Defines the background's type. Currently supports only ``"rectangle"`` (default) and ``"window"``.
//    background_stroke_width
//        Defines the stroke width of the background. Defaults to 1.
//    background_stroke_color
//        Defines the stroke color for the background. Defaults to ``WHITE``.
//    corner_radius
//        Defines the corner radius for the background. Defaults to 0.2.
//    insert_line_no
//        Defines whether line numbers should be inserted in displayed code. Defaults to ``True``.
//    line_no_from
//        Defines the first line's number in the line count. Defaults to 1.
//    line_no_buff
//        Defines the spacing between line numbers and displayed code. Defaults to 0.4.
//    style
//        Defines the style type of displayed code. You can see possible names of styles in with :attr:`styles_list`. Defaults to ``"vim"``.
//    language
//        Specifies the programming language the given code was written in. If ``None``
//        (the default), the language will be automatically detected. For the list of
//        possible options, visit https://pygments.org/docs/lexers/ and look for
//        'aliases or short names'.
//    generate_html_file
//        Defines whether to generate highlighted html code to the folder `assets/codes/generated_html_files`. Defaults to `False`.
//    warn_missing_font
//        If True (default), Manim will issue a warning if the font does not exist in the
//        (case-sensitive) list of fonts returned from `manimpango.list_fonts()`.
//
//    Attributes
//    ----------
//    background_mobject : :class:`~.VGroup`
//        The background of the code listing.
//    line_numbers : :class:`~.Paragraph`
//        The line numbers for the code listing. Empty, if
//        ``insert_line_no=False`` has been specified.
//    code : :class:`~.Paragraph`
//        The highlighted code.
//
//    """
//
//    # tuples in the form (name, aliases, filetypes, mimetypes)
//    # 'language' is aliases or short names
//    # For more information about pygments.lexers visit https://pygments.org/docs/lexers/
//    # from pygments.lexers import get_all_lexers
//    # all_lexers = get_all_lexers()
//    styles_list = list(get_all_styles())
//    # For more information about pygments.styles visit https://pygments.org/docs/styles/

