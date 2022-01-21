package com.example.lonelymountainnav.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainnav.databinding.FragmentNameBinding

class NameFragment: Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            nextBtn.setOnClickListener{


            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}