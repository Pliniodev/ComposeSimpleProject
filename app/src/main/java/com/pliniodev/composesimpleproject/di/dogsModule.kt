package com.pliniodev.composesimpleproject.di

import com.pliniodev.composesimpleproject.commons.createApi
import com.pliniodev.composesimpleproject.data.DogsApiService
import com.pliniodev.composesimpleproject.data.remoteDataSource.RemoteDataSource
import com.pliniodev.composesimpleproject.data.repository.DogsApiRepositoryImpl
import com.pliniodev.composesimpleproject.domain.repository.DogsApiRepository
import com.pliniodev.composesimpleproject.network.constants.BaseUrl
import com.pliniodev.composesimpleproject.network.retrofit.provideOkHttpClientAuthDogs
import com.pliniodev.composesimpleproject.data.remoteDataSource.RemoteDataSourceImpl
import com.pliniodev.composesimpleproject.view.doglist.DogsListViewModel
import com.pliniodev.composesimpleproject.network.constants.InjectionTag
import com.pliniodev.composesimpleproject.network.retrofit.BuildRetrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dogsModule = module {
    single(named(InjectionTag.RETROFIT_DOGS)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.dogs,
            okHttpClient = provideOkHttpClientAuthDogs()
        )
    }

    single(named(InjectionTag.API_DOGS)) {
        createApi<DogsApiService>(get(named(InjectionTag.RETROFIT_DOGS)))
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(
            api = get(named(InjectionTag.API_DOGS))
        )
    }

    single<DogsApiRepository> { DogsApiRepositoryImpl(remoteDataSource = get()) }

    viewModel { DogsListViewModel(api = get()) }
}