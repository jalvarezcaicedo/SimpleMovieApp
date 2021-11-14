package com.tech.simplemovieapp.data.remote

import javax.inject.Inject

class CatalogueRemoteDataSource @Inject constructor(private val catalogueService: CatalogueService) :
    BaseDataSource() {

    suspend fun getFilms() = getResult { catalogueService.getCatalogue() }

}