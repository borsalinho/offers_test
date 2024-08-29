package com.tests.offerstest.models

data class OffersViewData(
    val offers : List<OfferViewData>,
    val vacancies: List<VacancyViewData>
)
data class OfferViewData(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonViewData?
)

data class VacancyViewData(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: AddressViewData,
    val company: String,
    val experience: ExperienceViewData,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryViewData,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
)

data class AddressViewData(
    val town: String,
    val street: String,
    val house: String
)

data class ExperienceViewData(
    val previewText: String,
    val text: String
)

data class SalaryViewData(
    val short: String?,
    val full: String
)

data class ButtonViewData(
    val text: String
)