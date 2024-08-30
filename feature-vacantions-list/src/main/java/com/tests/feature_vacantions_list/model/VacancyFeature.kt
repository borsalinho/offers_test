package com.tests.feature_vacantions_list.model

import com.tests.common.model.ViewData


data class VacancyFeature(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: AddressFeature,
    val company: String,
    val experience: ExperienceFeature,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryFeature,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
) : ViewData

data class AddressFeature(
    val town: String,
    val street: String,
    val house: String
)

data class ExperienceFeature(
    val previewText: String,
    val text: String
)

data class SalaryFeature(
    val short: String?,
    val full: String
)
