package com.tests.feature_offers_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.s21.presentation.ui.adapters.ViewDataAdapter
import com.tests.feature_offers_list.databinding.FragmentOffersBinding
import com.tests.feature_offers_list.model.OfferFeature

class OffersFragment(
    private val vacancyFeatures: List<OfferFeature>,
    private val viewDataAdapter: ViewDataAdapter,
) : Fragment() {
    private var _binding: FragmentOffersBinding? = null
    private val binding get() = _binding!!

    private val offersViewModel: OffersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        offersViewModel.setVacancyFeatures(vacancyFeatures)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOffersBinding.inflate(inflater, container, false)
        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = viewDataAdapter
        }

        offersViewModel.offersFeatures.observe(viewLifecycleOwner, Observer { offers ->
            offers?.let {
                viewDataAdapter.items = it
            }
        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}