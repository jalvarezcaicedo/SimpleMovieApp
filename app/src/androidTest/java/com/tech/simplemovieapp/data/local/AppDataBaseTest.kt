package com.tech.simplemovieapp.data.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tech.simplemovieapp.data.model.Film
import junit.framework.Assert
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDataBaseTest : TestCase() {

    private lateinit var dataBase: AppDataBase
    private lateinit var filmDao: FilmDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        dataBase = Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java).build()
        filmDao = dataBase.filmDao()
    }

    @After
    fun closeDatabase() {
        dataBase.close()
    }

    @Test
    fun writeAndReadFilmData() = runBlocking {
        val fakeCatalogue: List<Film> = listOf(
            Film("fakeMovie1", "MOVIE"),
            Film("fakeMovie2", "MOVIE"),
            Film("fakeMovie3", "MOVIE"),
            Film("fakeSeries1", "SERIES"),
            Film("fakeSeries2", "SERIES")
        )
        filmDao.insertAll(fakeCatalogue)
        val films = filmDao.getAllFilms()
        Assert.assertEquals(films.value, fakeCatalogue)
    }

}