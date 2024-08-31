package com.tests.feature_vacantions_list.ui.vacantionsdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tests.feature_vacantions_list.databinding.FragmentVacancyDetailBinding
import com.tests.feature_vacantions_list.model.VacancyFeature
import com.tests.feature_vacantions_list.ui.vacantions.VacantionsViewModel

class VacancyDetailFragment : Fragment() {

    private val vacantionsDetailViewModel: VacantionsDetailViewModel by viewModels()
    private val vacantionsViewModel: VacantionsViewModel by activityViewModels()
    private var _binding: FragmentVacancyDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVacancyDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacantionsViewModel.selectVacancy()

        selectedVacancyObserver()
        vacancyFeatureObserver()


    }

    private fun selectedVacancyObserver(){
        vacantionsViewModel.selectedVacancy.observe(viewLifecycleOwner, Observer { vacancyId ->
            if (vacancyId != null) {
                vacantionsDetailViewModel.setVacancyFeature(vacancyId)

            }
        })
    }

    private fun vacancyFeatureObserver(){
        vacantionsDetailViewModel.vacancyFeature.observe(viewLifecycleOwner, Observer { vacancy ->
            updateUI(vacancy)
        })
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(vacancy: VacancyFeature) {
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
