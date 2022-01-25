package com.example.lonelymountainnav.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lonelymountainnav.databinding.FragmentPasswordBinding
import com.example.lonelymountainnav.dataclasses.User
import com.example.lonelymountainnav.viewmodel.FormViewModel

class PasswordFragment: Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!
    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FormViewModel::class.java]

        with(binding) {

            var password = ""

            passwordText.addTextChangedListener {
                password = it.toString()
            }

            submitBtn.setOnClickListener{
                viewModel.addPassword(password)

                val user =
                    User(viewModel.firstName.value.toString(),
                        viewModel.lastName.value.toString(),
                        viewModel.email.value.toString(),
                        viewModel.password.value.toString())

                viewModel.addUser(user)

                val directions =
                        PasswordFragmentDirections.actionPasswordFragmentToDisplayFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}