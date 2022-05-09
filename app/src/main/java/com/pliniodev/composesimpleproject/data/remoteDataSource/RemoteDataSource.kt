package com.pliniodev.composesimpleproject.data.remoteDataSource

import com.pliniodev.composesimpleproject.domain.Breed


internal interface RemoteDataSource {
    suspend fun getBreedsByPage(page: Int): List<Breed>
}
