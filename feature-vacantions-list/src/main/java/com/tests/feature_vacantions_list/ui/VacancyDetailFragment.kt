package com.tests.feature_vacantions_list.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tests.feature_vacantions_list.databinding.FragmentVacancyDetailBinding
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacancyDetailFragment : Fragment() {

    private val vacantionsViewModel: VacantionsViewModel by viewModels()
    private var _binding: FragmentVacancyDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VacancyDetailFragment", "onCreate")

        vacantionsViewModel.selectedVacancyId.observe(this, Observer { vacancyId ->
            if (vacancyId != null) {
                vacantionsViewModel.selectVacancy(vacancyId)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVacancyDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("VacancyDetailFragment", "onViewCreated")


        vacantionsViewModel.selectedVacancy.observe(viewLifecycleOwner, Observer { vacancy ->
            if (vacancy == null) {
                Log.d("VacancyDetailFragment", "Vacancy is null")
            } else {
                Log.d("VacancyDetailFragment", "Vacancy received: $vacancy")
                updateUI(vacancy)
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(vacancy: VacancyFeature) {
        Log.d("VacancyDetailFragment", "Updating UI with vacancy: $vacancy")
        binding.title.text = vacancy.title
        binding.salary.text = vacancy.salary.toString()
        binding.experience.text = vacancy.experience.previewText
        binding.schedules.text = vacancy.schedules.toString()
        binding.appliedNumber.text = "${vacancy.appliedNumber} Человек уже откликнулись"
        binding.lookingNumber.text = "${vacancy.lookingNumber} Человека уже смотрят"
        binding.company.text = vacancy.company
        binding.street.text = vacancy.address.toString()
        binding.description.text = vacancy.description
        binding.responsibilities.text = vacancy.responsibilities
        binding.questions.text = vacancy.questions.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
