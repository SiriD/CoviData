package com.sirid.covidata

import retrofit2.Call
import retrofit2.http.GET

interface DataApiService {
    @GET("data.json")
    fun getCovidData(): Call<CovidData>
}