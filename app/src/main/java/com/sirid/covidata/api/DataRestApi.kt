package com.sirid.covidata.api

import kotlinx.coroutines.Deferred

class DataRestApi(private val coviDataApi: CoviDataApi): DataApi {
    override suspend fun getData(): Deferred<CovidData> {
        println("getting data")
        return coviDataApi.getCoviData()
    }
}