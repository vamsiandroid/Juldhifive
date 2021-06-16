package com.vamsi.digitalmindstask

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StatesDataAdapter : RecyclerView.Adapter<StatesDataAdapter.MainViewHolder>() {

    var statesDateList: List<StateDistricsWiseData>? = null
    fun setListToAdapter(statesData: List<StateDistricsWiseData>) {
        statesDateList = statesData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return statesDateList!!.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        try {
            holder.stateName.text = statesDateList!!.get(position).state
            holder.valueOne.text =
                statesDateList!!.get(position).districtData.get(position).active.toString()

            holder.valueTwo.text =
                statesDateList!!.get(position).districtData.get(position).confirmed.toString()

            holder.valueThree.text =
                statesDateList!!.get(position).districtData.get(position).deceased.toString()

            holder.valueFour.text =
                statesDateList!!.get(position).districtData.get(position).recovered.toString()
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stateName: TextView = itemView.findViewById(R.id.stateName)
        val lstUpdatedTime: TextView = itemView.findViewById(R.id.lastUpdatedTime)
        val valueOne: TextView = itemView.findViewById(R.id.valueOne)
        val valueTwo: TextView = itemView.findViewById(R.id.valueTwo)
        val valueThree: TextView = itemView.findViewById(R.id.valueThree)
        val valueFour: TextView = itemView.findViewById(R.id.valueFour)
    }
}

