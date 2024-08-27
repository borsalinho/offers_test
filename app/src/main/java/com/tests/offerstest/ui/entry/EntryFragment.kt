package com.tests.offerstest.ui.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tests.feature_find_worker.ui.SearchWorkerFragment
import com.tests.featureemailverification.emailpattern.EmailPattern
import com.tests.featureemailverification.emailverificationlistener.EmailVerificationListener
import com.tests.featureemailverification.ui.EmailVerificationFragment
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentEntryBinding
import com.tests.offerstest.ui.verification.VerificationFragment
import javax.inject.Inject

class EntryFragment : Fragment(), EmailVerificationListener {

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
            val emailVerificationFragment = EmailVerificationFragment(emailPattern)
            emailVerificationFragment.setEmailVerificationListener(this@EntryFragment)
            replace(R.id.fragmentEmailVerification, emailVerificationFragment)
        }

        childFragmentManager.commit {
            replace(R.id.fragmentSearchForker, SearchWorkerFragment())
        }

        return binding.root
    }

    override fun onEmailVerificated(isVerificated: Boolean) {
        if(isVerificated){
            transition()
        }
    }

    private fun transition(){
        findNavController().navigate(R.id.action_entryFragment_to_verificationFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}