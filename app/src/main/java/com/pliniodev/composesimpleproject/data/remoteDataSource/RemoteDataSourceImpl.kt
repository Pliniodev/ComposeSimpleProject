package com.pliniodev.composesimpleproject.data.remoteDataSource

import com.pliniodev.composesimpleproject.data.DogsApiService
import com.pliniodev.composesimpleproject.data.mapper.BreedsMapper
import com.pliniodev.composesimpleproject.domain.Breed

internal class RemoteDataSourceImpl(
    private val api: DogsApiService
) : RemoteDataSource {
    override suspend fun getBreedsByPage(page: Int): List<Breed> {
        return BreedsMapper.toBreedsDomain(api.getBreedsByPage(page, FIFTY_BREEDS))
    }

    companion object {
        const val FIFTY_BREEDS = 50
    }
}
