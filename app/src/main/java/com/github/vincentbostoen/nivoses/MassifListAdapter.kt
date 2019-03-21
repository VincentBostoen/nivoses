package com.github.vincentbostoen.nivoses

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MassifListAdapter(val massifList: ArrayList<String>) :
    RecyclerView.Adapter<MassifListAdapter.MassifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MassifViewHolder {
        return MassifViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return massifList.size
    }

    override fun onBindViewHolder(viewHolder: MassifViewHolder, position: Int) {
        (viewHolder.itemView as TextView).text = massifList[position]
    }

    class MassifViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
