package com.tests.offerstest.ui.fragments.cardvacancy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.tests.feature_vacantions_list.ui.vacantionsdetail.VacancyDetailFragment
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentCardVacancyBinding

class CardVacancy: Fragment() {

    private var _binding: FragmentCardVacancyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCardVacancyBinding.inflate(inflater, container, false)

        childFragmentManager.commit {
            replace(R.id.fragmentCardVacancy, VacancyDetailFragment())
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}