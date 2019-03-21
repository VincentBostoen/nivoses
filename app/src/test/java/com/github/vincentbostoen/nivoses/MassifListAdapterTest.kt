package com.github.vincentbostoen.nivoses

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MassifListAdapterTest {

    @Test
    fun adapter_returns_two_when_adaptee_list_contains_two_elements() {
        val massifListAdapter = MassifListAdapter(arrayOf(Massif.BELLEDONNE, Massif.CHARTREUSE))

        assertThat(massifListAdapter.itemCount).isEqualTo(2)
    }

    @Test
    fun adapter_returns_three_when_default_adaptee_list() {
        val massifListAdapter = MassifListAdapter(Massif.values())

        assertThat(massifListAdapter.itemCount).isEqualTo(3)
    }
}