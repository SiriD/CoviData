package com.sirid.covidata.main

import com.sirid.covidata.api.CovidData

sealed class CovidDataState {
    class Success(val covidData: CovidData): CovidDataState()
    class Error(val message: String?): CovidDataState()
}