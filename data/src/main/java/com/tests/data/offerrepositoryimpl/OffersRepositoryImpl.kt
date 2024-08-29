package com.tests.data.offerrepositoryimpl

import com.tests.data.mapper.toOffers
import com.tests.data.network.OffersApi
import com.tests.data.offersparser.OffersParser
import com.tests.domain.models.Offers
import com.tests.domain.offersrepository.OffersRepository
import okhttp3.ResponseBody


class OffersRepositoryImpl(
    private var offersApi: OffersApi,
    private var offersParser : OffersParser
) : OffersRepository {
    override suspend fun getOffers(): Offers {
        System.out.println("1111")
        val response = offersApi.downloadFile()
        System.out.println("222")
        if (!response.isSuccessful) {
            throw Exception("Failed to download file: ${response.code()} ${response.message()}")
        }
        System.out.println("3333")
        val responseBody: ResponseBody = response.body() ?: throw Exception("Empty response body")
        System.out.println("4444")
        val inputStream = responseBody.byteStream()
        System.out.println("5555")

        return offersParser.parse(inputStream).toOffers()
    }

}