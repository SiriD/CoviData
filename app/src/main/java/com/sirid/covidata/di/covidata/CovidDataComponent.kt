package com.sirid.covidata.di.covidata

import com.sirid.covidata.coviddatachart.ChartFragment
import com.sirid.covidata.di.AppModule
import com.sirid.covidata.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, CovidDataModule::class])
interface CovidDataComponent{
    fun inject(chartFragment: ChartFragment)
}