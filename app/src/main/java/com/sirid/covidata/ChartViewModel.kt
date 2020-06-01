package com.sirid.covidata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ChartViewModel(val dataRepository: DataRepository): ViewModel() {
    var casesTimeSeries: LiveData<List<CasesTimeSeries>> = dataRepository.liveDataCasesTimeSeries
    var statewise: LiveData<List<Statewise>> = dataRepository.liveDataStatewise
    var tested: LiveData<List<Tested>> = dataRepository.liveDataTested

    fun getCovidData() {
        dataRepository.getLiveCovidData()
    }

    fun getCasesTimeSeriesData(): LiveData<List<CasesTimeSeries>> {
        return casesTimeSeries
    }

    fun getStatewiseData(): LiveData<List<Statewise>> {
        return statewise
    }

    fun getTestedData(): LiveData<List<Tested>> {
        return tested
    }

}