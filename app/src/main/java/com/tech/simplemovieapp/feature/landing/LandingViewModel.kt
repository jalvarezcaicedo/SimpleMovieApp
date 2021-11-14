package com.tech.simplemovieapp.feature.landing

import androidx.lifecycle.ViewModel
import com.tech.simplemovieapp.data.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {

    val films = repository.getFilms()

}