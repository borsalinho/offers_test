package com.tests.feature_vacantions_list.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.s21.presentation.ui.adapters.ViewDataAdapter
import com.tests.feature_vacantions_list.databinding.FragmentVacantionsBinding
import com.tests.feature_vacantions_list.model.VacancyFeature
import com.tests.common.model.ViewData
import com.tests.feature_vacantions_list.R

class VacantionsFragment(
    private val vacancyFeatures: List<VacancyFeature>,
    private val viewDataAdapter: ViewDataAdapter,
    private val navId: Int
) : Fragment() {

    private var _binding: FragmentVacantionsBinding? = null
    private val binding get() = _binding!!

    private val vacantionsViewModel: VacantionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vacantionsViewModel.setVacancyFeatures(vacancyFeatures)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVacantionsBinding.inflate(inflater, container, false)
        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = viewDataAdapter
        }

        viewDataAdapter.setOnItemClickListener { vacancy ->
            navigateToVacancyDetail(vacancy)
        }

        vacantionsViewModel.vacancyFeatures.observe(viewLifecycleOwner, Observer { features ->
            features?.let {
                viewDataAdapter.items = it
            }
        })
    }

    private fun navigateToVacancyDetail(vacancy: ViewData) {
        val bundle = Bundle().apply {
            putString("id_key", (vacancy as VacancyFeature).id)
        }
        findNavController().navigate(navId, bundle)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
