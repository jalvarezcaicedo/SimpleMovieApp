package com.tech.simplemovieapp.feature.landing

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
class LandingViewModelTest : BaseTest() {

    private lateinit var testedObject: LandingViewModel

    @RelaxedMockK
    private lateinit var filmRepository: FilmRepository

    override fun preTest() {
        testedObject = LandingViewModel(filmRepository)
    }

    @Test
    fun getFilms() {
        val expected = MutableLiveData(Resource.success(DummyObject.fakeListFilms))
        every {
            filmRepository.getFilms()
        }.returns(expected)
        testedObject.start()
        val observable = testedObject.films.test()
        observable.assertHasValue()
            .assertValue {
                it == Resource.success(DummyObject.fakeListFilms)
            }
    }

}