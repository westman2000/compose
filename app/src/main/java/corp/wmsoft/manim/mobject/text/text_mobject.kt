package corp.wmsoft.manim.mobject.text

import corp.wmsoft.manim.mobject.svg.SVGMobject
import corp.wmsoft.manim.mobject.types.VGroup

//"""Mobjects used for displaying (non-LaTeX) text.
//
//.. note::
//   Just as you can use :class:`~.Tex` and :class:`~.MathTex` (from the module :mod:`~.tex_mobject`)
//   to insert LaTeX to your videos, you can use :class:`~.Text` to to add normal text.
//
//.. important::
//
//   See the corresponding tutorial :ref:`using-text-objects`, especially for information about fonts.
//
//
//The simplest way to add text to your animations is to use the :class:`~.Text` class. It uses the Pango library to render text.
//With Pango, you are also able to render non-English alphabets like `你好` or  `こんにちは` or `안녕하세요` or `مرحبا بالعالم`.
//
//Examples
//--------
//
//.. manim:: HelloWorld
//    :save_last_frame:
//
//    class HelloWorld(Scene):
//        def construct(self):
//            text = Text('Hello world').scale(3)
//            self.add(text)
//
//.. manim:: TextAlignment
//    :save_last_frame:
//
//    class TextAlignment(Scene):
//        def construct(self):
//            title = Text("K-means clustering and Logistic Regression", color=WHITE)
//            title.scale(0.75)
//            self.add(title.to_edge(UP))
//
//            t1 = Text("1. Measuring").set_color(WHITE)
//
//            t2 = Text("2. Clustering").set_color(WHITE)
//
//            t3 = Text("3. Regression").set_color(WHITE)
//
//            t4 = Text("4. Prediction").set_color(WHITE)
//
//            x = VGroup(t1, t2, t3, t4).arrange(direction=DOWN, aligned_edge=LEFT).scale(0.7).next_to(ORIGIN,DR)
//            x.set_opacity(0.5)
//            x.submobjects[1].set_opacity(1)
//            self.add(x)
//
//"""


class Paragraph : VGroup()
//    r"""Display a paragraph of text.
//
//    For a given :class:`.Paragraph` ``par``, the attribute ``par.chars`` is a
//    :class:`.VGroup` containing all the lines. In this context, every line is
//    constructed as a :class:`.VGroup` of characters contained in the line.
//
//
//    Parameters
//    ----------
//    line_spacing
//        Represents the spacing between lines. Defaults to -1, which means auto.
//    alignment
//        Defines the alignment of paragraph. Defaults to None. Possible values are "left", "right" or "center".
//
//    Examples
//    --------
//    Normal usage::
//
//        paragraph = Paragraph('this is a awesome', 'paragraph',
//                              'With \nNewlines', '\tWith Tabs',
//                              '  With Spaces', 'With Alignments',
//                              'center', 'left', 'right')
//
//    Remove unwanted invisible characters::
//
//        self.play(Transform(remove_invisible_chars(paragraph.chars[0:2]),
//                            remove_invisible_chars(paragraph.chars[3][0:3]))
//
//    """

class Text : SVGMobject()
//    r"""Display (non-LaTeX) text rendered using `Pango <https://pango.gnome.org/>`_.
//
//    Text objects behave like a :class:`.VGroup`-like iterable of all characters
//    in the given text. In particular, slicing is possible.
//
//    Parameters
//    ----------
//    text
//        The text that needs to be created as a mobject.
//    font
//        The font family to be used to render the text. This is either a system font or
//        one loaded with `register_font()`. Note that font family names may be different
//        across operating systems.
//    warn_missing_font
//        If True (default), Manim will issue a warning if the font does not exist in the
//        (case-sensitive) list of fonts returned from `manimpango.list_fonts()`.
//
//    Returns
//    -------
//    :class:`Text`
//        The mobject-like :class:`.VGroup`.
//
//    Examples
//    ---------
//
//    .. manim:: Example1Text
//        :save_last_frame:
//
//        class Example1Text(Scene):
//            def construct(self):
//                text = Text('Hello world').scale(3)
//                self.add(text)
//
//    .. manim:: TextColorExample
//        :save_last_frame:
//
//        class TextColorExample(Scene):
//            def construct(self):
//                text1 = Text('Hello world', color=BLUE).scale(3)
//                text2 = Text('Hello world', gradient=(BLUE, GREEN)).scale(3).next_to(text1, DOWN)
//                self.add(text1, text2)
//
//    .. manim:: TextItalicAndBoldExample
//        :save_last_frame:
//
//        class TextItalicAndBoldExample(Scene):
//            def construct(self):
//                text1 = Text("Hello world", slant=ITALIC)
//                text2 = Text("Hello world", t2s={'world':ITALIC})
//                text3 = Text("Hello world", weight=BOLD)
//                text4 = Text("Hello world", t2w={'world':BOLD})
//                text5 = Text("Hello world", t2c={'o':YELLOW}, disable_ligatures=True)
//                text6 = Text(
//                    "Visit us at docs.manim.community",
//                    t2c={"docs.manim.community": YELLOW},
//                    disable_ligatures=True,
//               )
//                text6.scale(1.3).shift(DOWN)
//                self.add(text1, text2, text3, text4, text5 , text6)
//                Group(*self.mobjects).arrange(DOWN, buff=.8).set(height=config.frame_height-LARGE_BUFF)
//
//    .. manim:: TextMoreCustomization
//            :save_last_frame:
//
//            class TextMoreCustomization(Scene):
//                def construct(self):
//                    text1 = Text(
//                        'Google',
//                        t2c={'[:1]': '#3174f0', '[1:2]': '#e53125',
//                             '[2:3]': '#fbb003', '[3:4]': '#3174f0',
//                             '[4:5]': '#269a43', '[5:]': '#e53125'}, font_size=58).scale(3)
//                    self.add(text1)
//
//    As :class:`Text` uses Pango to render text, rendering non-English
//    characters is easily possible:
//
//    .. manim:: MultipleFonts
//        :save_last_frame:
//
//        class MultipleFonts(Scene):
//            def construct(self):
//                morning = Text("வணக்கம்", font="sans-serif")
//                japanese = Text(
//                    "日本へようこそ", t2c={"日本": BLUE}
//                )  # works same as ``Text``.
//                mess = Text("Multi-Language", weight=BOLD)
//                russ = Text("Здравствуйте मस नम म ", font="sans-serif")
//                hin = Text("नमस्ते", font="sans-serif")
//                arb = Text(
//                    "صباح الخير \n تشرفت بمقابلتك", font="sans-serif"
//                )  # don't mix RTL and LTR languages nothing shows up then ;-)
//                chinese = Text("臂猿「黛比」帶著孩子", font="sans-serif")
//                self.add(morning, japanese, mess, russ, hin, arb, chinese)
//                for i,mobj in enumerate(self.mobjects):
//                    mobj.shift(DOWN*(i-3))
//
//
//    .. manim:: PangoRender
//        :quality: low
//
//        class PangoRender(Scene):
//            def construct(self):
//                morning = Text("வணக்கம்", font="sans-serif")
//                self.play(Write(morning))
//                self.wait(2)
//
//    Tests
//    -----
//
//    Check that the creation of :class:`~.Text` works::
//
//        >>> Text('The horse does not eat cucumber salad.')
//        Text('The horse does not eat cucumber salad.')
//
//    """


class MarkupText : SVGMobject()
//    r"""Display (non-LaTeX) text rendered using `Pango <https://pango.gnome.org/>`_.
//
//    Text objects behave like a :class:`.VGroup`-like iterable of all characters
//    in the given text. In particular, slicing is possible.
//
//    **What is PangoMarkup?**
//
//    PangoMarkup is a small markup language like html and it helps you avoid using
//    "range of characters" while coloring or styling a piece a Text. You can use
//    this language with :class:`~.MarkupText`.
//
//    A simple example of a marked-up string might be::
//
//        <span foreground="blue" size="x-large">Blue text</span> is <i>cool</i>!"
//
//    and it can be used with :class:`~.MarkupText` as
//
//    .. manim:: MarkupExample
//        :save_last_frame:
//
//        class MarkupExample(Scene):
//            def construct(self):
//                text = MarkupText('<span foreground="blue" size="x-large">Blue text</span> is <i>cool</i>!"')
//                self.add(text)
//
//    A more elaborate example would be:
//
//    .. manim:: MarkupElaborateExample
//        :save_last_frame:
//
//        class MarkupElaborateExample(Scene):
//            def construct(self):
//                text = MarkupText(
//                    '<span foreground="purple">ا</span><span foreground="red">َ</span>'
//                    'ل<span foreground="blue">ْ</span>ع<span foreground="red">َ</span>ر'
//                    '<span foreground="red">َ</span>ب<span foreground="red">ِ</span>ي'
//                    '<span foreground="green">ّ</span><span foreground="red">َ</span>ة'
//                    '<span foreground="blue">ُ</span>'
//                )
//                self.add(text)
//
//    PangoMarkup can also contain XML features such as numeric character
//    entities such as ``&#169;`` for © can be used too.
//
//    The most general markup tag is ``<span>``, then there are some
//    convenience tags.
//
//    Here is a list of supported tags:
//
//    - ``<b>bold</b>``, ``<i>italic</i>`` and ``<b><i>bold+italic</i></b>``
//    - ``<ul>underline</ul>`` and ``<s>strike through</s>``
//    - ``<tt>typewriter font</tt>``
//    - ``<big>bigger font</big>`` and ``<small>smaller font</small>``
//    - ``<sup>superscript</sup>`` and ``<sub>subscript</sub>``
//    - ``<span underline="double" underline_color="green">double underline</span>``
//    - ``<span underline="error">error underline</span>``
//    - ``<span overline="single" overline_color="green">overline</span>``
//    - ``<span strikethrough="true" strikethrough_color="red">strikethrough</span>``
//    - ``<span font_family="sans">temporary change of font</span>``
//    - ``<span foreground="red">temporary change of color</span>``
//    - ``<span fgcolor="red">temporary change of color</span>``
//    - ``<gradient from="YELLOW" to="RED">temporary gradient</gradient>``
//
//    For ``<span>`` markup, colors can be specified either as
//    hex triples like ``#aabbcc`` or as named CSS colors like
//    ``AliceBlue``.
//    The ``<gradient>`` tag is handled by Manim rather than
//    Pango, and supports hex triplets or Manim constants like
//    ``RED`` or ``RED_A``.
//    If you want to use Manim constants like ``RED_A`` together
//    with ``<span>``, you will need to use Python's f-String
//    syntax as follows::
//
//        MarkupText(f'<span foreground="{RED_A}">here you go</span>')
//
//    If your text contains ligatures, the :class:`MarkupText` class may
//    incorrectly determine the first and last letter when creating the
//    gradient. This is due to the fact that ``fl`` are two separate characters,
//    but might be set as one single glyph - a ligature. If your language
//    does not depend on ligatures, consider setting ``disable_ligatures``
//    to ``True``. If you must use ligatures, the ``gradient`` tag supports an optional
//    attribute ``offset`` which can be used to compensate for that error.
//
//    For example:
//
//    - ``<gradient from="RED" to="YELLOW" offset="1">example</gradient>`` to *start* the gradient one letter earlier
//    - ``<gradient from="RED" to="YELLOW" offset=",1">example</gradient>`` to *end* the gradient one letter earlier
//    - ``<gradient from="RED" to="YELLOW" offset="2,1">example</gradient>`` to *start* the gradient two letters earlier and *end* it one letter earlier
//
//    Specifying a second offset may be necessary if the text to be colored does
//    itself contain ligatures. The same can happen when using HTML entities for
//    special chars.
//
//    When using ``underline``, ``overline`` or ``strikethrough`` together with
//    ``<gradient>`` tags, you will also need to use the offset, because
//    underlines are additional paths in the final :class:`SVGMobject`.
//    Check out the following example.
//
//    Escaping of special characters: ``>`` **should** be written as ``&gt;``
//    whereas ``<`` and ``&`` *must* be written as ``&lt;`` and
//    ``&amp;``.
//
//    You can find more information about Pango markup formatting at the
//    corresponding documentation page:
//    `Pango Markup <https://docs.gtk.org/Pango/pango_markup.html>`_.
//    Please be aware that not all features are supported by this class and that
//    the ``<gradient>`` tag mentioned above is not supported by Pango.
//
//    Parameters
//    ----------
//
//    text
//        The text that needs to be created as mobject.
//    fill_opacity
//        The fill opacity, with 1 meaning opaque and 0 meaning transparent.
//    stroke_width
//        Stroke width.
//    font_size
//        Font size.
//    line_spacing
//        Line spacing.
//    font
//        Global font setting for the entire text. Local overrides are possible.
//    slant
//        Global slant setting, e.g. `NORMAL` or `ITALIC`. Local overrides are possible.
//    weight
//        Global weight setting, e.g. `NORMAL` or `BOLD`. Local overrides are possible.
//    gradient
//        Global gradient setting. Local overrides are possible.
//    warn_missing_font
//        If True (default), Manim will issue a warning if the font does not exist in the
//        (case-sensitive) list of fonts returned from `manimpango.list_fonts()`.
//
//    Returns
//    -------
//    :class:`MarkupText`
//        The text displayed in form of a :class:`.VGroup`-like mobject.
//
//    Examples
//    ---------
//
//    .. manim:: BasicMarkupExample
//        :save_last_frame:
//
//        class BasicMarkupExample(Scene):
//            def construct(self):
//                text1 = MarkupText("<b>foo</b> <i>bar</i> <b><i>foobar</i></b>")
//                text2 = MarkupText("<s>foo</s> <u>bar</u> <big>big</big> <small>small</small>")
//                text3 = MarkupText("H<sub>2</sub>O and H<sub>3</sub>O<sup>+</sup>")
//                text4 = MarkupText("type <tt>help</tt> for help")
//                text5 = MarkupText(
//                    '<span underline="double">foo</span> <span underline="error">bar</span>'
//                )
//                group = VGroup(text1, text2, text3, text4, text5).arrange(DOWN)
//                self.add(group)
//
//    .. manim:: ColorExample
//        :save_last_frame:
//
//        class ColorExample(Scene):
//            def construct(self):
//                text1 = MarkupText(
//                    f'all in red <span fgcolor="{YELLOW}">except this</span>', color=RED
//                )
//                text2 = MarkupText("nice gradient", gradient=(BLUE, GREEN))
//                text3 = MarkupText(
//                    'nice <gradient from="RED" to="YELLOW">intermediate</gradient> gradient',
//                    gradient=(BLUE, GREEN),
//                )
//                text4 = MarkupText(
//                    'fl ligature <gradient from="RED" to="YELLOW">causing trouble</gradient> here'
//                )
//                text5 = MarkupText(
//                    'fl ligature <gradient from="RED" to="YELLOW" offset="1">defeated</gradient> with offset'
//                )
//                text6 = MarkupText(
//                    'fl ligature <gradient from="RED" to="YELLOW" offset="1">floating</gradient> inside'
//                )
//                text7 = MarkupText(
//                    'fl ligature <gradient from="RED" to="YELLOW" offset="1,1">floating</gradient> inside'
//                )
//                group = VGroup(text1, text2, text3, text4, text5, text6, text7).arrange(DOWN)
//                self.add(group)
//
//    .. manim:: UnderlineExample
//        :save_last_frame:
//
//        class UnderlineExample(Scene):
//            def construct(self):
//                text1 = MarkupText(
//                    '<span underline="double" underline_color="green">bla</span>'
//                )
//                text2 = MarkupText(
//                    '<span underline="single" underline_color="green">xxx</span><gradient from="#ffff00" to="RED">aabb</gradient>y'
//                )
//                text3 = MarkupText(
//                    '<span underline="single" underline_color="green">xxx</span><gradient from="#ffff00" to="RED" offset="-1">aabb</gradient>y'
//                )
//                text4 = MarkupText(
//                    '<span underline="double" underline_color="green">xxx</span><gradient from="#ffff00" to="RED">aabb</gradient>y'
//                )
//                text5 = MarkupText(
//                    '<span underline="double" underline_color="green">xxx</span><gradient from="#ffff00" to="RED" offset="-2">aabb</gradient>y'
//                )
//                group = VGroup(text1, text2, text3, text4, text5).arrange(DOWN)
//                self.add(group)
//
//    .. manim:: FontExample
//        :save_last_frame:
//
//        class FontExample(Scene):
//            def construct(self):
//                text1 = MarkupText(
//                    'all in sans <span font_family="serif">except this</span>', font="sans"
//                )
//                text2 = MarkupText(
//                    '<span font_family="serif">mixing</span> <span font_family="sans">fonts</span> <span font_family="monospace">is ugly</span>'
//                )
//                text3 = MarkupText("special char > or &gt;")
//                text4 = MarkupText("special char &lt; and &amp;")
//                group = VGroup(text1, text2, text3, text4).arrange(DOWN)
//                self.add(group)
//
//    .. manim:: NewlineExample
//        :save_last_frame:
//
//        class NewlineExample(Scene):
//            def construct(self):
//                text = MarkupText('foooo<span foreground="red">oo\nbaa</span>aar')
//                self.add(text)
//
//    .. manim:: NoLigaturesExample
//        :save_last_frame:
//
//        class NoLigaturesExample(Scene):
//            def construct(self):
//                text1 = MarkupText('fl<gradient from="RED" to="GREEN">oat</gradient>ing')
//                text2 = MarkupText('fl<gradient from="RED" to="GREEN">oat</gradient>ing', disable_ligatures=True)
//                group = VGroup(text1, text2).arrange(DOWN)
//                self.add(group)
//
//
//    As :class:`MarkupText` uses Pango to render text, rendering non-English
//    characters is easily possible:
//
//    .. manim:: MultiLanguage
//        :save_last_frame:
//
//        class MultiLanguage(Scene):
//            def construct(self):
//                morning = MarkupText("வணக்கம்", font="sans-serif")
//                japanese = MarkupText(
//                    '<span fgcolor="blue">日本</span>へようこそ'
//                )  # works as in ``Text``.
//                mess = MarkupText("Multi-Language", weight=BOLD)
//                russ = MarkupText("Здравствуйте मस नम म ", font="sans-serif")
//                hin = MarkupText("नमस्ते", font="sans-serif")
//                chinese = MarkupText("臂猿「黛比」帶著孩子", font="sans-serif")
//                group = VGroup(morning, japanese, mess, russ, hin, chinese).arrange(DOWN)
//                self.add(group)
//
//    You can justify the text by passing :attr:`justify` parameter.
//
//    .. manim:: JustifyText
//
//        class JustifyText(Scene):
//            def construct(self):
//                ipsum_text = (
//                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
//                    "Praesent feugiat metus sit amet iaculis pulvinar. Nulla posuere "
//                    "quam a ex aliquam, eleifend consectetur tellus viverra. Aliquam "
//                    "fermentum interdum justo, nec rutrum elit pretium ac. Nam quis "
//                    "leo pulvinar, dignissim est at, venenatis nisi."
//                )
//                justified_text = MarkupText(ipsum_text, justify=True).scale(0.4)
//                not_justified_text = MarkupText(ipsum_text, justify=False).scale(0.4)
//                just_title = Title("Justified")
//                njust_title = Title("Not Justified")
//                self.add(njust_title, not_justified_text)
//                self.play(
//                    FadeOut(not_justified_text),
//                    FadeIn(justified_text),
//                    FadeOut(njust_title),
//                    FadeIn(just_title),
//                )
//                self.wait(1)
//
//    Tests
//    -----
//
//    Check that the creation of :class:`~.MarkupText` works::
//
//        >>> MarkupText('The horse does not eat cucumber salad.')
//        MarkupText('The horse does not eat cucumber salad.')
//
//    """
