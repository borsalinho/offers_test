package com.tests.featureemailverification.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tests.feature_email_verification.R
import com.tests.feature_email_verification.databinding.FragmentEmailVerificationBinding
import com.tests.featureemailverification.emailpattern.EmailPattern

class EmailVerificationFragment(private val pattern: EmailPattern) : Fragment() {

    private var _binding: FragmentEmailVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailVerificationBinding.inflate(inflater, container, false)

        validTextListener()
        setIconsDefSettings()
        textListenterForChangeIcons()
        touchTextEditListener()

        return binding.root
    }

    private fun validTextListener() {
        binding.buttonVerify.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            if (email.matches(Regex(pattern.value))) {
            } else {
                showInvalidEmailError()
            }
        }
    }

    private fun showInvalidEmailError() {
        binding.editTextEmail.setBackgroundResource(R.drawable.bg_red_border)
        binding.errorTextView.apply {
            visibility = View.VISIBLE
            text = "Вы ввели неверный e-mail"
        }
    }

    private fun hideInvalidEmailError() {
        binding.editTextEmail.setBackgroundResource(0)
        binding.errorTextView.visibility = View.GONE
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun touchTextEditListener() {
        binding.editTextEmail.setOnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2

            if (event.action == MotionEvent.ACTION_UP) {
                val drawableRight = binding.editTextEmail.compoundDrawables[DRAWABLE_RIGHT]
                if (drawableRight != null && event.rawX >= (binding.editTextEmail.right - drawableRight.bounds.width())) {
                    binding.editTextEmail.setText("")
                    hideInvalidEmailError()
                    updateButtonState()
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun textListenterForChangeIcons() {
        binding.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if ((s?.length ?: 0) > 0) {
                    binding.editTextEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
                } else {
                    binding.editTextEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_responce_black_24dp, 0, 0, 0)
                }
                hideInvalidEmailError()
                updateButtonState()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun updateButtonState() {
        val isTextNotEmpty = binding.editTextEmail.text.isNotEmpty()
        binding.buttonVerify.isEnabled = isTextNotEmpty

        if (isTextNotEmpty) {
            binding.buttonVerify.apply {
                setBackgroundColor(requireContext().getColor(R.color.enabledButtonColor))
                setTextColor(requireContext().getColor(R.color.enabledButtonTextColor))
            }
        } else {
            binding.buttonVerify.apply {
                setBackgroundColor(requireContext().getColor(R.color.disabledButtonColor))
                setTextColor(requireContext().getColor(R.color.disabledButtonTextColor))
            }
        }
    }

    private fun setIconsDefSettings() {
        binding.editTextEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_responce_black_24dp, 0, 0, 0)
        updateButtonState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
