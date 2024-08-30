package com.tests.offerstest.ui.fragments.responses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResponceViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is responce Fragment"
    }
    val text: LiveData<String> = _text
}