package com.example.lonelymountainnav.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainnav.databinding.FragmentNameBinding
import com.example.lonelymountainnav.viewmodel.FormViewModel

class NameFragment: Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get() = _binding!!
    private lateinit var viewModel: FormViewModel

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
        viewModel = ViewModelProvider(requireActivity())[FormViewModel::class.java]
        with(binding) {

            var firstName = ""
            var lastName = ""

            firstNameText.addTextChangedListener {
                firstName = it.toString()
            }

            lastNameText.addTextChangedListener {
                lastName = it.toString()
            }

            nextBtn.setOnClickListener{
                viewModel.addFirstName(firstName)
                viewModel.addLastName(lastName)

                val directions =
                    NameFragmentDirections.actionNameFragmentToEmailFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}