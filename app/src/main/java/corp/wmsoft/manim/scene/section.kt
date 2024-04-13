package corp.wmsoft.manim.scene

//"""building blocks of segmented video API"""



class DefaultSectionType() // (str, Enum):
//    """The type of a section can be used for third party applications.
//    A presentation system could for example use the types to created loops.
//
//    Examples
//    --------
//    This class can be reimplemented for more types::
//
//        class PresentationSectionType(str, Enum):
//            # start, end, wait for continuation by user
//            NORMAL = "presentation.normal"
//            # start, end, immediately continue to next section
//            SKIP = "presentation.skip"
//            # start, end, restart, immediately continue to next section when continued by user
//            LOOP = "presentation.loop"
//            # start, end, restart, finish animation first when user continues
//            COMPLETE_LOOP = "presentation.complete_loop"
//    """


open class Section()
//    """A :class:`.Scene` can be segmented into multiple Sections.
//    Refer to :doc:`the documentation</tutorials/output_and_config>` for more info.
//    It consists of multiple animations.
//
//    Attributes
//    ----------
//    type
//        Can be used by a third party applications to classify different types of sections.
//    video
//        Path to video file with animations belonging to section relative to sections directory.
//        If ``None``, then the section will not be saved.
//    name
//        Human readable, non-unique name for this section.
//    skip_animations
//        Skip rendering the animations in this section when ``True``.
//    partial_movie_files
//        Animations belonging to this section.
//
//    See Also
//    --------
//    :class:`.DefaultSectionType`
//    :meth:`.CairoRenderer.update_skipping_status`
//    :meth:`.OpenGLRenderer.update_skipping_status`
//    """
