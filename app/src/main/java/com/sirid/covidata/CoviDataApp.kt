package com.sirid.covidata

import android.app.Application
import com.sirid.covidata.di.covidata.CovidDataComponent
import com.sirid.covidata.di.covidata.DaggerCovidDataComponent

class CoviDataApp: Application() {

    companion object {
        lateinit var covidDataComponent: CovidDataComponent
    }

    override fun onCreate() {
        super.onCreate()
        covidDataComponent = DaggerCovidDataComponent.builder().build()
    }
}