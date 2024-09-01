package com.tests.feature_vacantions_list.delegate

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.tests.common.model.ViewData
import com.tests.feature_vacantions_list.databinding.ItemVacantionBinding
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacationsAdapterDelegate(
) :
    AbsListItemAdapterDelegate<VacancyFeature, ViewData, VacationsAdapterDelegate.OfferViewHolder>() {

    override fun isForViewType(item: ViewData, items: MutableList<ViewData>, position: Int) = item is VacancyFeature

    override fun onCreateViewHolder(parent: ViewGroup): OfferViewHolder {
        val binding = ItemVacantionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding)
    }

    override fun onBindViewHolder(item: VacancyFeature, holder: OfferViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class OfferViewHolder(private val binding: ItemVacantionBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: VacancyFeature) {
            binding.watchNow.text = "Сейчас просматривают " + data.lookingNumber.toString() + " человек"
            binding.title.text = data.title
            binding.town.text = data.address.town
            binding.company.text = data.company
            binding.experience.text = data.experience.previewText
            binding.publishedDate.text = "Опубликовано " +  data.publishedDate
        }
    }
}
