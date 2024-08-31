package com.tests.feature_offers_list.model

import com.tests.common.model.ViewData

data class OfferFeature(
    val id: String?,
    val title: String,
    val link: String,
    val button: ButtonFeature?
) : ViewData

data class ButtonFeature(
    val text: String
)
