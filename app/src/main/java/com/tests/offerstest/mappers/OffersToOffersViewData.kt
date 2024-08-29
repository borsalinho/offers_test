package com.tests.offerstest.mappers

import com.tests.domain.models.Address
import com.tests.domain.models.Button
import com.tests.domain.models.Experience
import com.tests.domain.models.Offer
import com.tests.domain.models.Offers
import com.tests.domain.models.Salary
import com.tests.domain.models.Vacancy
import com.tests.offerstest.models.AddressViewData
import com.tests.offerstest.models.ButtonViewData
import com.tests.offerstest.models.ExperienceViewData
import com.tests.offerstest.models.OfferViewData
import com.tests.offerstest.models.OffersViewData
import com.tests.offerstest.models.SalaryViewData
import com.tests.offerstest.models.VacancyViewData

fun Offers.toOffersViewData(): OffersViewData {
    return OffersViewData(
        offers = offers.map { it.toOfferViewData() },
        vacancies = vacancies.map { it.toVacancyViewData() }
    )
}

fun Offer.toOfferViewData(): OfferViewData {
    return OfferViewData(
        id = id,
        title = title,
        link = link,
        button = button?.toButtonViewData()
    )
}

fun Vacancy.toVacancyViewData(): VacancyViewData {
    return VacancyViewData(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = address.toAddressViewData(),
        company = company,
        experience = experience.toExperienceViewData(),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.toSalaryViewData(),
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions
    )
}

fun Address.toAddressViewData(): AddressViewData {
    return AddressViewData(
        town = town,
        street = street,
        house = house
    )
}

fun Experience.toExperienceViewData(): ExperienceViewData {
    return ExperienceViewData(
        previewText = previewText,
        text = text
    )
}

fun Salary.toSalaryViewData(): SalaryViewData {
    return SalaryViewData(
        short = short,
        full = full
    )
}

fun Button.toButtonViewData(): ButtonViewData {
    return ButtonViewData(
        text = text
    )
}