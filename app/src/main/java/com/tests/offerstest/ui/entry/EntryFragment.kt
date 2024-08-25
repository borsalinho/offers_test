package com.tests.offerstest.ui.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.tests.featureemailverification.ui.EmailVerificationFragment
import com.tests.offerstest.R
import com.tests.offerstest.databinding.FragmentEntryBinding

class EntryFragment : Fragment() {

    private var _binding: FragmentEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val entryViewModel =
            ViewModelProvider(this).get(EntryViewModel::class.java)

        _binding = FragmentEntryBinding.inflate(inflater, container, false)


        val textView: TextView = binding.textEntry
        entryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        childFragmentManager.commit {
            replace(R.id.fragmentEmailVerification, EmailVerificationFragment())
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}