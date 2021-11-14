package com.tech.simplemovieapp.data.remote

import com.tech.simplemovieapp.data.OpenForTesting
import javax.inject.Inject

@OpenForTesting
class CatalogueRemoteDataSource @Inject constructor(private val catalogueService: CatalogueService) :
    BaseDataSource() {

    suspend fun getFilms() = getResult { catalogueService.getCatalogue() }

}