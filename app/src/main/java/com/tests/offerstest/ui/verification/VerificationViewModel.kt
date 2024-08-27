package com.tests.offerstest.ui.verification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VerificationViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is verification Fragment"
    }
    val text: LiveData<String> = _text
}