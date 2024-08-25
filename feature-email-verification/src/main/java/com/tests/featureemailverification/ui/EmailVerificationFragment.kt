package com.tests.featureemailverification.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tests.feature_email_verification.databinding.FragmentEmailVerificationBinding

class EmailVerificationFragment : Fragment() {

    private var _binding : FragmentEmailVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailVerificationBinding.inflate(inflater,container,false)

        binding.buttonVerify.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            if (email.matches(Regex(".*@mail\\.ru"))) {
                Toast.makeText(requireContext(), "Email is valid!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Invalid email format!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}