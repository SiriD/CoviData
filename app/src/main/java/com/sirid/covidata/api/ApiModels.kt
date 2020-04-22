package com.sirid.covidata.api

class CovidData (
    val casesTimeSeries: List<CovidCasesTimeSeries>,
    val statewise: List<CovidStatewise>,
    val tested: List<CovidTested>
)

class CovidCasesTimeSeries (
    val dailyconfirmed: String,
    val dailydeceased: String,
    val dailyrecovered: String,
    val date: String,
    val totalconfirmed: String,
    val totaldeceased: String,
    val totalrecovered: String
)

class CovidStatewise (
    val active: String,
    val confirmed: String,
    val deaths: String,
    val deltaconfirmed: String,
    val deltadeaths: String,
    val deltarecovered: String,
    val lastupdatedtime: String,
    val recovered: String,
    val state: String,
    val statecode: String,
    val statenotes: String
)

class CovidTested (
    val positivecasesfromsamplesreported: String,
    val samplereportedtoday: String,
    val source: String,
    val testsconductedbyprivatelabs: String,
    val totalindividualstested: String,
    val totalpositivecases: String,
    val totalsamplestested: String,
    val updatetimestamp: String
)