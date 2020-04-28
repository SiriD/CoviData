package com.sirid.covidata.main

import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.sirid.covidata.R
import com.sirid.covidata.api.CovidDataItem
import com.sirid.covidata.utils.ViewType
import com.sirid.covidata.utils.ViewTypeDelegateAdapter
import kotlinx.android.synthetic.main.data_list_item.view.*

class MainDelegateAdapter (): ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MainViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as MainViewHolder
        holder.bind(item as CovidDataItem)
    }

    inner class MainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.get(R.layout.data_list_item)) {

        private val main_item = itemView.textView

        fun bind(item: CovidDataItem) {
            main_item.text = item
            super.itemView.setOnClickListener { }
        }
    }

}