package com.sirid.covidata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ChartViewModel(val dataRepository: DataRepository): ViewModel() {
    val casesTimeSeries: LiveData<List<CasesTimeSeries>> = dataRepository.liveDataCasesTimeSeries
    val statewise: LiveData<List<Statewise>> = dataRepository.liveDataStatewise
    val tested: LiveData<List<Tested>> = dataRepository.liveDataTested

    fun getCasesTimeSeriesData() {
        dataRepository.getCasesTimeSeries()
    }

    fun getStatewiseData() {
        dataRepository.getStatewiseData()
    }

    fun getTestedData() {
        dataRepository.getTestedData()
    }
}