package com.tech.simplemovieapp.data.repository

import com.tech.simplemovieapp.data.local.FilmDao
import com.tech.simplemovieapp.data.remote.CatalogueRemoteDataSource
import com.tech.simplemovieapp.util.performGetOperation
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val remoteDataSource: CatalogueRemoteDataSource,
    private val localDataSource: FilmDao
) {

    fun getFilms() = performGetOperation(
        databaseQuery = { localDataSource.getAllFilms() },
        networkCall = { remoteDataSource.getFilms() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )

}