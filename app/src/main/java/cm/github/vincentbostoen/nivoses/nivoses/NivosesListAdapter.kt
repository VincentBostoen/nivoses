package cm.github.vincentbostoen.nivoses.nivoses

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class NivosesListAdapter(private val nivosesList: MutableList<Nivose>) :
    RecyclerView.Adapter<NivosesListAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nivoseImageView: ImageView

        init {
            nivoseImageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.nivose_list_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val nivose = nivosesList[position]
        GlideApp.with(holder.nivoseImageView).load(nivose.imageURL).centerInside().into(holder.nivoseImageView)
    }

    override fun getItemCount(): Int {
        return nivosesList.size
    }

    fun updateList(newNivosesList: List<Nivose>) {
        nivosesList.clear()
        nivosesList.addAll(newNivosesList)
    }
}