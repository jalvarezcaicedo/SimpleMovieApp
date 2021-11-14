package com.tech.simplemovieapp.feature.series

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
class SeriesViewModelTest : BaseTest() {

    private lateinit var testedObject: SeriesViewModel

    @RelaxedMockK
    private lateinit var filmRepository: FilmRepository

    override fun preTest() {
        testedObject = SeriesViewModel(filmRepository)
    }

    @Test
    fun getSeries() {
        val expected = MutableLiveData(Resource.success(DummyObject.fakeListSeries))
        every {
            filmRepository.getSeries()
        }.returns(expected)
        testedObject.start()
        val observable = testedObject.series.test()
        observable.assertHasValue()
            .assertValue {
                it == Resource.success(DummyObject.fakeListSeries)
            }
    }
}