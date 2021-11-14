package com.tech.simplemovieapp.feature.movies

import DummyObject
import androidx.lifecycle.MutableLiveData
import com.jraska.livedata.test
import com.tech.simplemovieapp.BaseTest
import com.tech.simplemovieapp.data.repository.FilmRepository
import com.tech.simplemovieapp.util.Resource
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

@ExperimentalCoroutinesApi
class MoviesViewModelTest : BaseTest() {

    private lateinit var testedObject: MoviesViewModel

    @RelaxedMockK
    private lateinit var filmRepository: FilmRepository

    override fun preTest() {
        testedObject = MoviesViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val expected = MutableLiveData(Resource.success(DummyObject.fakeListMovies))
        every {
            filmRepository.getMovies()
        }.returns(expected)
        testedObject.start()
        val observable = testedObject.movies.test()
        observable.assertHasValue()
            .assertValue {
                it == Resource.success(DummyObject.fakeListMovies)
            }
    }

}