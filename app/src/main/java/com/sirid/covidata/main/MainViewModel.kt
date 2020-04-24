package com.sirid.covidata.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sirid.covidata.api.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(private val api: CoviDataApi,
    private val coroutineContext: CoroutineContext): ViewModel() {

    val covidDataState: MutableLiveData<CovidDataState> = MutableLiveData()
    val uiScope = CoroutineScope(Dispatchers.Main)
    fun fetchCovidData() = uiScope.launch(coroutineContext) {
        try {
            val result = api.getCoviData().await()
            val coviddata = process(result)
            covidDataState.postValue(CovidDataState.Success(coviddata))
        } catch (e: Throwable) {
            covidDataState.postValue(CovidDataState.Error(e.message))
        }
    }
}

private fun process(response: CovidData): CovidData {
    val casesTimeSeries = response.casesTimeSeries.map {
        CovidCasesTimeSeries(it.dailyconfirmed, it.dailydeceased, it.dailyrecovered,
            it.totalconfirmed, it.totaldeceased, it.totalrecovered,
            it.date)
    }

    val statewise = response.statewise.map { CovidStatewise(it.active, it.confirmed, it.deaths,
                    it.deltaconfirmed, it.deltarecovered, it.lastupdatedtime, it.state,
                    it.statecode, it.statenotes, it.recovered, it.deltadeaths)}

    val tested = response.tested.map { CovidTested(it.positivecasesfromsamplesreported,
                                    it.samplereportedtoday, it.source,
                                    it.testsconductedbyprivatelabs, it.totalpositivecases,
                                    it.totalsamplestested, it.totalindividualstested,
                                    it.updatetimestamp) }

    return CovidData(casesTimeSeries, statewise, tested)
}