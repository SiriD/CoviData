package com.sirid.covidata.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CoviDataApi {
    @GET("data.json")
    fun getCoviData() : Deferred<CovidData>
}

