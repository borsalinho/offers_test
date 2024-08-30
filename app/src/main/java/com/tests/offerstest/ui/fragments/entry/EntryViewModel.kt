package com.tests.offerstest.ui.fragments.entry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EntryViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is entry Fragment"
    }
    val text: LiveData<String> = _text
}