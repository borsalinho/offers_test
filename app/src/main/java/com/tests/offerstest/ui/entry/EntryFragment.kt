package com.tests.offerstest.ui.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.tests.feature_find_worker.ui.SearchWorkerFragment
import com.tests.featureemailverification.emailpattern.EmailPattern
import com.tests.featureemailverification.ui.EmailVerificationFragment
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentEntryBinding
import javax.inject.Inject

class EntryFragment : Fragment() {

    private var _binding: FragmentEntryBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var emailPattern : EmailPattern

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val entryViewModel =
            ViewModelProvider(this).get(EntryViewModel::class.java)

        _binding = FragmentEntryBinding.inflate(inflater, container, false)


        childFragmentManager.commit {
            replace(R.id.fragmentEmailVerification, EmailVerificationFragment(emailPattern))
        }

        childFragmentManager.commit {
            replace(R.id.fragmentSearchForker, SearchWorkerFragment())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}