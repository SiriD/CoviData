package com.sirid.covidata.api

import android.os.Parcel
import android.os.Parcelable
import com.sirid.covidata.utils.ViewType

//data class CovidDataItem: ViewType(
//    val dataItem: String
//)

data class CovidDataItem(val dataItem: String) : ViewType, Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(dataItem)
    }

    override fun getViewType(): Int = 1

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CovidDataItem> {
        override fun createFromParcel(parcel: Parcel): CovidDataItem {
            return CovidDataItem(parcel)
        }

        override fun newArray(size: Int): Array<CovidDataItem?> {
            return arrayOfNulls(size)
        }
    }

}

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