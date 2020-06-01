package com.sirid.covidata

import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit

class DataRepository(val apiService: ApiService) {

    val liveDataCasesTimeSeries = MutableLiveData<List<CasesTimeSeries>>()
    val liveDataStatewise = MutableLiveData<List<Statewise>>()
    val liveDataTested = MutableLiveData<List<Tested>>()

    fun getCasesTimeSeries() {
        liveDataCasesTimeSeries.value = apiService.getCasesTimeSeriesData()
    }

    fun getStatewiseData() {
        liveDataStatewise.value = apiService.getStatewiseData()
    }

    fun getTestedData() {
        liveDataTested.value = apiService.getTestedData()
    }

}