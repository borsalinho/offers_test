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

        val response = offersApi.downloadFile()

        if (!response.isSuccessful) {
            throw Exception("Failed to download file: ${response.code()} ${response.message()}")
        }

        val responseBody: ResponseBody = response.body() ?: throw Exception("Empty response body")
        val inputStream = responseBody.byteStream()

        return offersParser.parse(inputStream).toOffers()
    }

}