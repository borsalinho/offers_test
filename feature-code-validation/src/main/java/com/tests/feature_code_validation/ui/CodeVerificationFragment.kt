package com.tests.feature_code_validation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.tests.feature_code_validation.codevalidationlistener.CodeValidationListener
import com.tests.feature_code_validation.databinding.FragmentCodeVerificationBinding

class CodeVerificationFragment(private val email : String) : Fragment() {

    private var codeValidationListener : CodeValidationListener? = null

    private var _binding: FragmentCodeVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCodeVerificationBinding.inflate(inflater, container, false)

        binding.title.text = "Отправили код на $email"
        binding.editTextNumber1.requestFocus()

        setButtonDisable()

        setupFocusListeners()
        setupTextWatchers()

        buttonListener()

        return binding.root
    }

    fun setCodeValidationListener(codeListener : CodeValidationListener){
        codeValidationListener = codeListener
    }

    private fun buttonListener(){
        binding.buttonCodeVerification.setOnClickListener {
            if (areAllFieldsFilled()) {
                codeValidationListener?.onCodeValidation(true)
            }
        }
    }

    private fun areAllFieldsFilled(): Boolean {
        return binding.editTextNumber1.text.isNotEmpty() &&
                binding.editTextNumber2.text.isNotEmpty() &&
                binding.editTextNumber3.text.isNotEmpty() &&
                binding.editTextNumber4.text.isNotEmpty()
    }

    private fun setupFocusListeners() {
        setupHintBehavior(binding.editTextNumber1, binding.editTextNumber1.hint.toString())
        setupHintBehavior(binding.editTextNumber2, binding.editTextNumber2.hint.toString())
        setupHintBehavior(binding.editTextNumber3, binding.editTextNumber3.hint.toString())
        setupHintBehavior(binding.editTextNumber4, binding.editTextNumber4.hint.toString())
    }

    private fun setupHintBehavior(editText: EditText, hint: String) {
        editText.setOnFocusChangeListener { v, hasFocus ->
            val editTextView = v as EditText
            if (hasFocus) {
                editTextView.hint = ""
            } else {
                if (editTextView.text.isEmpty()) {
                    editTextView.hint = hint
                }
            }
        }
    }

    private fun setupTextWatchers() {
        setupTextWatcher(binding.editTextNumber1, binding.editTextNumber2)
        setupTextWatcher(binding.editTextNumber2, binding.editTextNumber3)
        setupTextWatcher(binding.editTextNumber3, binding.editTextNumber4)
        setupTextWatcher(binding.editTextNumber4, null)
    }

    private fun setupTextWatcher(currentEditText: EditText, nextEditText: EditText?) {
        currentEditText.addTextChangedListener {
            if (it?.length == 1) {
                nextEditText?.requestFocus() ?: binding.buttonCodeVerification.requestFocus()
            }
            updateButtonState()
        }
    }

    private fun updateButtonState() {
        val isCodesNotEmpty = binding.editTextNumber1.text.isNotEmpty() &&
                binding.editTextNumber2.text.isNotEmpty() &&
                binding.editTextNumber3.text.isNotEmpty() &&
                binding.editTextNumber4.text.isNotEmpty()

        if (isCodesNotEmpty) {
            setButtonEnable()
        } else {
            setButtonDisable()
        }
    }

    private fun setButtonDisable(){
        binding.buttonCodeVerification.apply {
            setBackgroundColor(requireContext().getColor(com.tests.common.R.color.disabledButtonColor))
            setTextColor(requireContext().getColor(com.tests.common.R.color.disabledButtonTextColor))
            isEnabled = false
        }
    }

    private fun setButtonEnable(){
        binding.buttonCodeVerification.apply {
            setBackgroundColor(requireContext().getColor(com.tests.common.R.color.enabledButtonColor))
            setTextColor(requireContext().getColor(com.tests.common.R.color.enabledButtonTextColor))
            isEnabled = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}