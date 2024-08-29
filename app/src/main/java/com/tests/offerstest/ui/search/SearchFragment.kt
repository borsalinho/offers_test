package com.tests.offerstest.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentSearchBinding
import javax.inject.Inject

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var searchViewModel : SearchViewModel


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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}