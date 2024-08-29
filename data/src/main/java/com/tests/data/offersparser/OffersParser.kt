package com.tests.data.offersparser

import com.google.gson.Gson
import com.tests.data.model.OffersData
import java.io.InputStream

class OffersParser {
    fun parse(inputStream : InputStream) : OffersData {
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, OffersData::class.java)
    }
}