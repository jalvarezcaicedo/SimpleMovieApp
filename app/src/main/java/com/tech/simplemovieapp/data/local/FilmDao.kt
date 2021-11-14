package com.tech.simplemovieapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tech.simplemovieapp.data.OpenForTesting
import com.tech.simplemovieapp.data.model.Film

@Dao
@OpenForTesting
interface FilmDao {

    @Query("SELECT * FROM films")
    fun getAllFilms(): LiveData<List<Film>>

    @Query("SELECT * FROM films WHERE type='MOVIE'")
    fun getAllMovies(): LiveData<List<Film>>

    @Query("SELECT * FROM films WHERE type='SERIES'")
    fun getAllSeries(): LiveData<List<Film>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Film>)


}
