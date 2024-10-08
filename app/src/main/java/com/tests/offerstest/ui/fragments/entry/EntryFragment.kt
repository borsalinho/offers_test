package com.tests.offerstest.ui.fragments.entry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.tests.feature_find_worker.ui.SearchWorkerFragment
import com.tests.featureemailverification.emailpattern.EmailPattern
import com.tests.featureemailverification.emailverificationlistener.EmailVerificationListener
import com.tests.featureemailverification.ui.EmailVerificationFragment
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentEntryBinding
import javax.inject.Inject

class EntryFragment : Fragment(), EmailVerificationListener {

    private var _binding: FragmentEntryBinding? = null
    private val binding get() = _binding!!

    lateinit var emailVerificationFragment: EmailVerificationFragment

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

        _binding = FragmentEntryBinding.inflate(inflater, container, false)
        emailVerificationFragment = EmailVerificationFragment(emailPattern)

        childFragmentManager.commit {
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
        val mail = emailVerificationFragment.getEmail()
        val bundle = Bundle().apply {
            putString("email_key", mail)
        }
        findNavController().navigate(R.id.action_entryFragment_to_verificationFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}