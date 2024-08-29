package com.tests.data.offersparser

import com.google.gson.Gson
import com.tests.data.model.OffersData
import java.io.InputStream

class OffersParser {
    fun parse(inputStream : InputStream) : OffersData {
        System.out.println("qqqqqqqqq")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        System.out.println("22222212121212")
        return Gson().fromJson(jsonString, OffersData::class.java)
    }
}