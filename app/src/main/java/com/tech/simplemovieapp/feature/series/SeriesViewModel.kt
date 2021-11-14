package com.tech.simplemovieapp.feature.series

import androidx.lifecycle.ViewModel
import com.tech.simplemovieapp.data.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    repository: FilmRepository
) : ViewModel() {

    val series = repository.getSeries()

}