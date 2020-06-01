package com.sirid.covidata

import android.graphics.Color
import android.util.Log
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.time.format.DateTimeFormatter

class ChartHelper(data: List<CasesTimeSeries>) {
    private var chartData: List<CasesTimeSeries> = listOf()

    init {
        chartData = data
    }

    fun generateLineChart(): LineData {
        var entries = chartData.mapIndexed {
                index: Int, casesTimeSeries: CasesTimeSeries ->  Entry(index.toFloat(),
                casesTimeSeries.totalconfirmed.toFloat()) }
        val lineDataSet = LineDataSet(entries, "Cases Time Series")
        lineDataSet.color = Color.RED
        lineDataSet.setDrawValues(false)
        lineDataSet.axisDependency = YAxis.AxisDependency.LEFT

        return LineData(lineDataSet)
    }

//    fun dateFormatter(date: String): String {
//        var formatter = DateTimeFormatter.ofPattern("MM dd")
//        return date.format(formatter)
//    }

}
