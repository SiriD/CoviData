package com.sirid.covidata.di.covidata

import com.sirid.covidata.api.CoviDataApi
import com.sirid.covidata.api.DataApi
import com.sirid.covidata.api.DataRestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CovidDataModule {

    @Singleton
    @Provides
    fun provideCovidDataApi(retrofit: Retrofit): CoviDataApi = retrofit.create(CoviDataApi::class.java)

    @Singleton
    @Provides
    fun provideDataApi(coviDataApi: CoviDataApi): DataApi = DataRestApi(coviDataApi)
}