package com.github.vincentbostoen.nivoses

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MassifListAdapter(val massifList : Array<Massif> = Massif.values()) :
    RecyclerView.Adapter<MassifListAdapter.MassifViewHolder<TextView>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MassifViewHolder<TextView> {
        return MassifViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return massifList.size
    }

    override fun onBindViewHolder(viewHolder: MassifViewHolder<TextView>, position: Int) {
        (viewHolder.itemView as TextView).text = Massif.values()[position].massif
    }

    class MassifViewHolder<T : View>(itemView: T) : RecyclerView.ViewHolder(itemView)
}
