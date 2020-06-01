package com.sirid.covidata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {

    val liveDataCasesTimeSeries = MutableLiveData<List<CasesTimeSeries>>()
    val liveDataStatewise = MutableLiveData<List<Statewise>>()
    val liveDataTested = MutableLiveData<List<Tested>>()

    fun getLiveCovidData(): MutableLiveData<CovidData> {
        val liveCovidData = MutableLiveData<CovidData>()

        val response = DataApiService.buildService(DataApi::class.java)
        response.getCovidData().enqueue(object : Callback<CovidData> {
            override fun onResponse(call: Call<CovidData>, response: Response<CovidData>) {
                if (response.isSuccessful) {
                    liveDataCasesTimeSeries.value = response.body()!!.cases_time_series
                    liveDataStatewise.value = response.body()!!.statewise
                    liveDataTested.value = response.body()!!.tested
                }
            }

            override fun onFailure(call: Call<CovidData>, t: Throwable) {
                Log.e("FAILED IN REPOSITORY", "onFailure: Failed to get Covid data")
            }
        })

        return liveCovidData
    }
}