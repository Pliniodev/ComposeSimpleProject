package com.pliniodev.composesimpleproject.data

import com.pliniodev.composesimpleproject.data.mapper.BreedsMapper
import com.pliniodev.composesimpleproject.data.response.BreedResponse
import com.pliniodev.composesimpleproject.data.utils.Resource
import com.pliniodev.composesimpleproject.domain.Breed
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DogsRepository @Inject constructor(
    private val api: DogsGateway
) {
    suspend fun getBreeds(): Resource<List<Breed>> {
        val response = try {
            BreedsMapper.toBreedsDomain(api.getBreedsByPage(1, 40))
        }catch (e: Exception) {
            return Resource.Error("Unknown error")
        }
        return Resource.Success(response)
    }
}