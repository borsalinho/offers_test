package com.tests.offerstest.ui.fragments.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tests.offerstest.databinding.FragmentPlugBinding

class MessagesFragment : Fragment() {

    private var _binding: FragmentPlugBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val messagesViewModel =
            ViewModelProvider(this).get(MessagesViewModel::class.java)

        _binding = FragmentPlugBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFavorites
        messagesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}