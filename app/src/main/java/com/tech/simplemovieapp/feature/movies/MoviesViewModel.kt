package com.tech.simplemovieapp.feature.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.tech.simplemovieapp.data.model.Film
import com.tech.simplemovieapp.data.repository.FilmRepository
import com.tech.simplemovieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    repository: FilmRepository
) : ViewModel() {
    private val _invoke = MutableLiveData<Boolean>()

    fun start() {
        _invoke.value = true
    }

    var _movies = _invoke.switchMap {
        repository.getMovies()
    }

    val movies: LiveData<Resource<List<Film>>> = _movies

}