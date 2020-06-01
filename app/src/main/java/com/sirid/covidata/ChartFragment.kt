package com.sirid.covidata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.mikephil.charting.charts.LineChart
import kotlinx.android.synthetic.main.chart_fragment.*

class ChartFragment : Fragment() {

    object Injection {
        val repository: DataRepository by lazy { DataRepository() }
        val viewModelFactory: DataViewModelFactory by lazy { DataViewModelFactory(repository) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataViewModel: ChartViewModel by viewModels {
            Injection.viewModelFactory
        }

        dataViewModel.casesTimeSeries.observe(viewLifecycleOwner, Observer { casesTimeSeriesDataList ->
            // line chart
            var helper = ChartHelper(casesTimeSeriesDataList)
            this.line_chart.invalidate()
            this.line_chart.setTouchEnabled(true);
            this.line_chart.setDragDecelerationFrictionCoef(0.9f);
            this.line_chart.setDragEnabled(true);
            this.line_chart.setScaleEnabled(true);
            this.line_chart.setDrawGridBackground(false);

            this.line_chart.data = helper.generateLineChart()
        })

        dataViewModel.getCovidData()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.chart_fragment, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): ChartFragment = ChartFragment()
    }
}