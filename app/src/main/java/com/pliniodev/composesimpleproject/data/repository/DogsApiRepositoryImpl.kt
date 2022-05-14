package com.pliniodev.composesimpleproject.data.repository

import com.pliniodev.composesimpleproject.data.remoteDataSource.RemoteDataSource
import com.pliniodev.composesimpleproject.domain.mapper.BreedsDomainMapper
import com.pliniodev.composesimpleproject.domain.repository.DogsApiRepository
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation

internal class DogsApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DogsApiRepository {
    override suspend fun getBreeds(page: Int): List<BreedPresentation> {
        return BreedsDomainMapper.toBreedsPresentation(remoteDataSource.getBreedsByPage(page))
    }
}
