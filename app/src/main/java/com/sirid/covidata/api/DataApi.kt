package com.sirid.covidata.api

import kotlinx.coroutines.Deferred

interface DataApi {
    suspend fun getData(): Deferred<CovidData>
}