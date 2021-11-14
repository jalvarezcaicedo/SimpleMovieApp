package com.tech.simplemovieapp.feature.movies

import androidx.lifecycle.ViewModel
import com.tech.simplemovieapp.data.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    repository: FilmRepository
) : ViewModel() {

    val movies = repository.getMovies()

}