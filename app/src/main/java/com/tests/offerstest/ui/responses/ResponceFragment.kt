package com.tests.offerstest.ui.responses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tests.offerstest.databinding.FragmentResponceBinding


class ResponceFragment : Fragment() {

    private var _binding: FragmentResponceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val responceViewModel =
            ViewModelProvider(this).get(ResponceViewModel::class.java)

        _binding = FragmentResponceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textResponce
        responceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}