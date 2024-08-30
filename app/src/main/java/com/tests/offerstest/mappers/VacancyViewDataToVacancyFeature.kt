package com.tests.offerstest.mappers

import com.tests.feature_vacantions_list.model.AddressFeature
import com.tests.feature_vacantions_list.model.ExperienceFeature
import com.tests.feature_vacantions_list.model.SalaryFeature
import com.tests.feature_vacantions_list.model.VacancyFeature
import com.tests.offerstest.models.VacancyViewData

fun List<VacancyViewData>.toVacancyFeatureList(): List<VacancyFeature> {
    return this.map { vacancyViewData ->
        VacancyFeature(
            id = vacancyViewData.id,
            lookingNumber = vacancyViewData.lookingNumber,
            title = vacancyViewData.title,
            address = AddressFeature(
                town = vacancyViewData.address.town,
                street = vacancyViewData.address.street,
                house = vacancyViewData.address.house
            ),
            company = vacancyViewData.company,
            experience = ExperienceFeature(
                previewText = vacancyViewData.experience.previewText,
                text = vacancyViewData.experience.text
            ),
            publishedDate = vacancyViewData.publishedDate,
            isFavorite = vacancyViewData.isFavorite,
            salary = SalaryFeature(
                short = vacancyViewData.salary.short,
                full = vacancyViewData.salary.full
            ),
            schedules = vacancyViewData.schedules,
            appliedNumber = vacancyViewData.appliedNumber,
            description = vacancyViewData.description,
            responsibilities = vacancyViewData.responsibilities,
            questions = vacancyViewData.questions
        )
    }
}