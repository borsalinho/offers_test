package com.tests.feature_offers_list.delegate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.tests.common.model.ViewData
import com.tests.feature_offers_list.databinding.ItemOfferBinding
import com.tests.feature_offers_list.model.OfferFeature

class OffersAdapterDelegate(
) :
    AbsListItemAdapterDelegate<OfferFeature, ViewData, OffersAdapterDelegate.OfferViewHolder>() {

    override fun isForViewType(item: ViewData, items: MutableList<ViewData>, position: Int) = item is OfferFeature

    override fun onCreateViewHolder(parent: ViewGroup): OfferViewHolder {
        val binding = ItemOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun onBindViewHolder(item: OfferFeature, holder: OfferViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class OfferViewHolder(private val binding: ItemOfferBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: OfferFeature) {

            binding.title.text = data.title
            if (data.button != null){
                binding.akaButton.visibility = View.VISIBLE
            } else {
                binding.akaButton.visibility = View.GONE
            }
        }
    }
}