package com.github.vincentbostoen.nivoses

import android.content.Context
import android.view.ViewGroup
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MassifListAdapterTest {

    @Test
    fun adapter_returns_four_when_adaptee_list_contains_four_elements() {
        val massifListAdapter = MassifListAdapter(arrayListOf("Chartreuse", "Vercors", "Belledonne","Taillefer"))

        assertThat(massifListAdapter.itemCount).isEqualTo(4)
    }

}