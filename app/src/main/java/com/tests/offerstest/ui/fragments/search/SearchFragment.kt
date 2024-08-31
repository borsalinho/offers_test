package com.tests.offerstest.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.s21.presentation.ui.adapters.ViewDataAdapter
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentSearchBinding
import com.tests.offerstest.mappers.toVacancyFeatureList
import com.tests.feature_vacantions_list.ui.vacantions.VacantionsFragment
import com.tests.offerstest.R
import javax.inject.Inject

class SearchFragment : Fragment(){

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var searchViewModel : SearchViewModel

    @Inject
    lateinit var viewDataAdapter: ViewDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        searchViewModel.fetchOffers()

        searchViewModel.offers.observe(viewLifecycleOwner, Observer { offersViewData ->
            offersViewData?.let {
                val vacancyFeatures = it.vacancies.toVacancyFeatureList()

                val vacantionsFragment = VacantionsFragment(
                    vacancyFeatures,
                    viewDataAdapter,
                    R.id.action_vacantionsFragment_to_vacancyDetailFragment
                )


                childFragmentManager.commit {
                    replace(R.id.fragmentVacantions, vacantionsFragment)
                }
            }
        })

        errorObserve()

        return root
    }

    private fun errorObserve(){
        searchViewModel.error.observe(viewLifecycleOwner, Observer { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
