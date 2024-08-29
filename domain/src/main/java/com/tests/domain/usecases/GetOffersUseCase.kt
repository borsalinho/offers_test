package com.tests.domain.usecases

import com.tests.domain.models.Offers
import com.tests.domain.offersrepository.OffersRepository

class GetOffersUseCase(
    private val offersRepository: OffersRepository
) {
    suspend fun execute() : Offers {
        return offersRepository.getOffers()
    }
}