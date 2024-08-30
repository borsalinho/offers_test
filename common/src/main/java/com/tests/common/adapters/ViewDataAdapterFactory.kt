package com.s21.presentation.ui.adapters

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.tests.common.model.ViewData

object ViewDataAdapterFactory {
    fun createAdapter(
        vararg delegates: AdapterDelegate<List<ViewData>>
    ): ViewDataAdapter {
        return ViewDataAdapter(
            delegates.toList()
        )
    }
}