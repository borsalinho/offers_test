package com.tests.offerstest.ui.fragments.verification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.tests.feature_code_validation.ui.CodeVerificationFragment
import com.tests.feature_code_validation.codevalidationlistener.CodeValidationListener
import com.tests.offerstest.R
import com.tests.offerstest.app.MyApp
import com.tests.offerstest.databinding.FragmentVerificationBinding


class VerificationFragment: Fragment(), CodeValidationListener {

    private var _binding: FragmentVerificationBinding? = null
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

        _binding = FragmentVerificationBinding.inflate(inflater, container, false)

        val email = arguments?.getString("email_key") ?: ""


        childFragmentManager.commit {
            val codeVerificationFragment = CodeVerificationFragment(email)
            codeVerificationFragment.setCodeValidationListener(this@VerificationFragment)
            replace(R.id.fragmentCodeVerification, codeVerificationFragment)
        }

        return binding.root
    }

    override fun onCodeValidation(isValid: Boolean) {
        if (isValid){
            transition()
        }
    }

    private fun transition(){
        findNavController().navigate(R.id.action_verificationFragment_to_offersFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}