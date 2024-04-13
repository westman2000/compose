package corp.wmsoft.manim.scene



//"""The interface between scenes and ffmpeg."""



open class SceneFileWriter()
//    """
//    SceneFileWriter is the object that actually writes the animations
//    played, into video files, using FFMPEG.
//    This is mostly for Manim's internal use. You will rarely, if ever,
//    have to use the methods for this class, unless tinkering with the very
//    fabric of Manim's reality.
//
//    Attributes
//    ----------
//        sections : list of :class:`.Section`
//            used to segment scene
//
//        sections_output_dir : :class:`pathlib.Path`
//            where are section videos stored
//
//        output_name : str
//            name of movie without extension and basis for section video names
//
//    Some useful attributes are:
//        "write_to_movie" (bool=False)
//            Whether or not to write the animations into a video file.
//        "movie_file_extension" (str=".mp4")
//            The file-type extension of the outputted video.
//        "partial_movie_files"
//            List of all the partial-movie files.
//
//    """
