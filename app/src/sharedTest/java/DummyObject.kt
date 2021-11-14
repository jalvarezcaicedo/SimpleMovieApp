import com.tech.simplemovieapp.data.model.Film

object DummyObject {
    val fakeListFilms: List<Film> = listOf(
        Film("fakeMovie1", "MOVIE"),
        Film("fakeMovie2", "MOVIE"),
        Film("fakeMovie3", "MOVIE"),
        Film("fakeSeries1", "SERIES"),
        Film("fakeSeries2", "SERIES")
    )

    val fakeListMovies: List<Film> = listOf(
        Film("fakeOnlyMovie1", "MOVIE"),
        Film("fakeOnlyMovie2", "MOVIE"),
        Film("fakeOnlyMovie3", "MOVIE")
    )

    val fakeListSeries: List<Film> = listOf(
        Film("fakeOnlySeries1", "SERIES"),
        Film("fakeOnlySeries2", "SERIES"),
        Film("fakeOnlySeries3", "SERIES")
    )
}