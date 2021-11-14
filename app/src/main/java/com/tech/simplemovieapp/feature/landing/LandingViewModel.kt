package com.tech.simplemovieapp.feature.landing

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
class LandingViewModel @Inject constructor(
    repository: FilmRepository
) : ViewModel() {
    private val _invoke = MutableLiveData<Boolean>()

    fun start() {
        _invoke.value = true
    }

    var _film = _invoke.switchMap {
        repository.getFilms()
    }

    val films: LiveData<Resource<List<Film>>> = _film

}