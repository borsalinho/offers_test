package com.tests.data.mapper

import com.tests.data.model.AddressData
import com.tests.data.model.ButtonData
import com.tests.data.model.ExperienceData
import com.tests.data.model.OfferData
import com.tests.data.model.OffersData
import com.tests.data.model.SalaryData
import com.tests.data.model.VacancyData
import com.tests.domain.models.Address
import com.tests.domain.models.Button
import com.tests.domain.models.Experience
import com.tests.domain.models.Offer
import com.tests.domain.models.Offers
import com.tests.domain.models.Salary
import com.tests.domain.models.Vacancy

fun OffersData.toOffers(): Offers {
    return Offers(
        offers = offers.map { it.toOffer() },
        vacancies = vacancies.map { it.toVacancy() }
    )
}

fun OfferData.toOffer(): Offer {
    return Offer(
        id = id,
        title = title,
        link = link,
        button = button?.toButton()
    )
}

fun VacancyData.toVacancy(): Vacancy {
    return Vacancy(
        id = id,
        lookingNumber = lookingNumber,
        title = title,
        address = address.toAddress(),
        company = company,
        experience = experience.toExperience(),
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        salary = salary.toSalary(),
        schedules = schedules,
        appliedNumber = appliedNumber,
        description = description,
        responsibilities = responsibilities,
        questions = questions
    )
}

fun AddressData.toAddress(): Address {
    return Address(
        town = town,
        street = street,
        house = house
    )
}

fun ExperienceData.toExperience(): Experience {
    return Experience(
        previewText = previewText,
        text = text
    )
}

fun SalaryData.toSalary(): Salary {
    return Salary(
        short = short,
        full = full
    )
}

fun ButtonData.toButton() : Button {
    return Button(
        text = text
    )
}
