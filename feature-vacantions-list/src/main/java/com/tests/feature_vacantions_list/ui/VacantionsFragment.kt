package com.tests.feature_vacantions_list.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.s21.presentation.ui.adapters.ViewDataAdapter
import com.tests.common.di.CommonModule
import com.tests.feature_vacantions_list.databinding.FragmentVacantionsBinding
import com.tests.feature_vacantions_list.model.VacancyFeature
import javax.inject.Inject



class VacantionsFragment(
    private val vacancyFeatures: List<VacancyFeature>,
    private val viewDataAdapter: ViewDataAdapter
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

        vacantionsViewModel.vacancyFeatures.observe(viewLifecycleOwner, Observer { features ->
            features?.let {
                viewDataAdapter.items = it
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}