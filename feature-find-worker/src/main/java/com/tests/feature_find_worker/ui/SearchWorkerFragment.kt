package com.tests.feature_find_worker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tests.feature_find_worker.databinding.FragmentSearchWorkersBinding

class SearchWorkerFragment: Fragment() {
    private var _binding : FragmentSearchWorkersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchWorkersBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}