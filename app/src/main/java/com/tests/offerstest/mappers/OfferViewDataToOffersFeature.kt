package com.tests.offerstest.mappers

import com.tests.feature_offers_list.model.ButtonFeature
import com.tests.feature_offers_list.model.OfferFeature
import com.tests.offerstest.models.ButtonViewData
import com.tests.offerstest.models.OfferViewData


fun List<OfferViewData>.toOfferFeatureList(): List<OfferFeature> {
    return this.map { offerViewData ->
        offerViewData.toOfferFeature()
    }
}

fun OfferViewData.toOfferFeature(): OfferFeature {
    return OfferFeature(
        id = this.id,
        title = this.title,
        link = this.link,
        button = this.button?.toButtonFeature()
    )
}

fun ButtonViewData.toButtonFeature(): ButtonFeature {
    return ButtonFeature(
        text = this.text
    )
}


