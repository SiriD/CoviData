package com.sirid.covidata

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {

    fun getCasesTimeSeriesData(): List<CasesTimeSeries> {
        return covidDataFromInterwebs().cases_time_series
    }

    fun getStatewiseData(): List<Statewise> {
        return covidDataFromInterwebs().statewise
    }

    fun getTestedData(): List<Tested> {
        return covidDataFromInterwebs().tested
    }

}

data class CovidData(val cases_time_series: List<CasesTimeSeries>,
                     val statewise: List<Statewise>, val tested: List<Tested>)

data class CasesTimeSeries(val dailyconfirmed: String,
                           val dailydeceased: String,
                           val dailyrecovered: String,
                           val date: String,
                           val totalconfirmed: String,
                           val totaldeceased: String,
                           val totalrecovered: String)

data class Statewise(val active: String,
                     val confirmed: String,
                     val deaths: String,
                     val deltaconfirmed: String,
                     val deltadeaths: String,
                     val deltarecovered: String,
                     val lastupdatedtime: String,
                     val recovered: String,
                     val state: String,
                     val statecode: String,
                     val statenotes: String)

data class Tested(val individualstestedperconfirmedcase: String,
                  val positivecasesfromsamplesreported: String,
                  val samplereportedtoday: String,
                  val source: String,
                  val testpositivityrate: String,
                  val testsconductedbyprivatelabs: String,
                  val testsperconfirmedcase: String,
                  val totalindividualstested: String,
                  val totalpositivecases: String,
                  val totalsamplestested: String,
                  val updatetimestamp: String)


private fun covidDataFromInterwebs(): CovidData {
    val casesTimeSeriesList = mutableListOf<CasesTimeSeries>()
    val statewiseList = mutableListOf<Statewise>()
    val testedList = mutableListOf<Tested>()

    //CasesTimeSeries
    casesTimeSeriesList.add(CasesTimeSeries("1", "0",
        "0", "January 30", "3", "0",
        "0"))
    casesTimeSeriesList.add(CasesTimeSeries("1", "0",
        "0", "January 31", "1", "0",
        "0"))
    casesTimeSeriesList.add(CasesTimeSeries("1", "0",
        "0", "February 1", "1", "0",
        "0"))
    casesTimeSeriesList.add(CasesTimeSeries("1", "0",
        "0", "February 2", "1", "0",
        "0"))

    //Statewise
    statewiseList.add(
        Statewise("552", "1044", "28",
            "0", "22", "82",
            "01/05/2020 20:12:46", "464", "Telangana",
            "TG", "Telangana"))

    statewiseList.add(
        Statewise("102", "498", "4",
            "0", "0", "9",
            "01/05/2020 17:32:46", "392", "Kerala",
            "KL", ""))

    //Tested
    testedList.add(Tested("", "",
        "",
        "https://icmr.nic.in/sites/default/files/whats_new/ICMR_testing_update_23Apr2020_9AM_IST.pdf",
        "", "", "",
        "", "","", "23/04/2020 09:00:00"))

    return CovidData(casesTimeSeriesList, statewiseList, testedList)
}