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

}