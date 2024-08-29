package com.tests.domain.offersrepository

import com.tests.domain.models.Offers

interface OffersRepository {
    suspend fun getOffers() : Offers
}