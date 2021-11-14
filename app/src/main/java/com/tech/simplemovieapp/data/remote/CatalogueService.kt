package com.tech.simplemovieapp.data.remote

import com.tech.simplemovieapp.data.model.Catalogue
import retrofit2.Response
import retrofit2.http.GET

interface CatalogueService {

    @GET("72f66f33-9186-4b20-a9a6-2c65661bc9cf")
    suspend fun getCatalogue(): Response<Catalogue>

}