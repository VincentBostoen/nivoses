package com.github.vincentbostoen.nivoses

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_select_massif.*

class SelectMassifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_massif)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        massif_list.layoutManager = mLayoutManager
        massif_list.adapter = MassifListAdapter(arrayListOf("Chartreuse", "Vercors", "Belledonne","Taillefer"))
    }


}
