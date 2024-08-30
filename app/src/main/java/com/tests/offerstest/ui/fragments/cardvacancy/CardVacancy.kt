package com.tests.offerstest.ui.fragments.cardvacancy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.tests.feature_find_worker.ui.SearchWorkerFragment
import com.tests.feature_vacantions_list.ui.VacancyDetailFragment
import com.tests.featureemailverification.emailpattern.EmailPattern
import com.tests.featureemailverification.emailverificationlistener.EmailVerificationListener
import com.tests.featureemailverification.ui.EmailVerificationFragment
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentCardVacancyBinding
import com.tests.offerstest.databinding.FragmentEntryBinding
import javax.inject.Inject

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