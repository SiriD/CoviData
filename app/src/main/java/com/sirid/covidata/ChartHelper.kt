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
        var entries1 = chartData.mapIndexed {
                index: Int, casesTimeSeries: CasesTimeSeries ->  Entry(index.toFloat(),
                casesTimeSeries.totalconfirmed.toFloat()) }

        var entries2 = chartData.mapIndexed {
                index: Int, casesTimeSeries: CasesTimeSeries ->  Entry(index.toFloat(),
            casesTimeSeries.totalrecovered.toFloat()) }

        var entries3 = chartData.mapIndexed {
                index: Int, casesTimeSeries: CasesTimeSeries ->  Entry(index.toFloat(),
            casesTimeSeries.totaldeceased.toFloat()) }

        val lineDataSet1 = LineDataSet(entries1, "Total Confirmed")
        lineDataSet1.color = Color.RED
        lineDataSet1.setDrawValues(false)
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.axisDependency = YAxis.AxisDependency.LEFT

        val lineDataSet2 = LineDataSet(entries2, "Total recovered")
        lineDataSet2.color = Color.GREEN
        lineDataSet2.setDrawValues(false)
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.axisDependency = YAxis.AxisDependency.LEFT

        val lineDataSet3 = LineDataSet(entries3, "Total Deceased")
        lineDataSet3.color = Color.MAGENTA
        lineDataSet3.setDrawValues(false)
        lineDataSet3.setDrawCircles(false);
        lineDataSet3.axisDependency = YAxis.AxisDependency.LEFT

        return LineData(lineDataSet1, lineDataSet2, lineDataSet3)
    }

//    fun dateFormatter(date: String): String {
//        var formatter = DateTimeFormatter.ofPattern("MM dd")
//        return date.format(formatter)
//    }

}
