package com.sirid.covidata

import retrofit2.Call
import retrofit2.http.GET

interface DataApi {
    @GET("data.json")
    fun getCovidData(): Call<CovidData>
}