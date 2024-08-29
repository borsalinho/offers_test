package com.tests.data.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming

interface OffersApi {
    @GET("/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    @Streaming
    suspend fun downloadFile() : Response<ResponseBody>
}