package com.tests.data.model


data class OffersData(
    val offers : List<OfferData>,
    val vacancies: List<VacancyData>
)
data class OfferData(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonData?
)

data class VacancyData(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: AddressData,
    val company: String,
    val experience: ExperienceData,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryData,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
)

data class AddressData(
    val town: String,
    val street: String,
    val house: String
)

data class ExperienceData(
    val previewText: String,
    val text: String
)

data class SalaryData(
    val short: String?,
    val full: String
)

data class ButtonData(
    val text: String
)