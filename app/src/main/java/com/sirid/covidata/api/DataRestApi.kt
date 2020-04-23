package com.sirid.covidata.api

import kotlinx.coroutines.Deferred
import javax.inject.Inject

class DataRestApi @Inject constructor(private val coviDataApi: CoviDataApi): DataApi {
    override suspend fun getData(): Deferred<CovidData> {
        println("getting data")
        return coviDataApi.getCoviData()
    }
}