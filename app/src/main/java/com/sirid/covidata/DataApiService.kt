package com.sirid.covidata

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DataApiService {

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19india.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}