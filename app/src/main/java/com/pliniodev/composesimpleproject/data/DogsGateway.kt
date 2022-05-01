package com.pliniodev.composesimpleproject.data

import com.pliniodev.composesimpleproject.data.response.BreedResponse
import com.pliniodev.composesimpleproject.data.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface DogsGateway {

    @GET("breeds")
    suspend fun getBreedsByPage(
        @Query(
            value = "page",
            encoded = true
        ) page: Int,
        @Query(
            value = "limit",
            encoded = true
        ) limitOfBreeds: Int
    ): List<BreedResponse>
}
