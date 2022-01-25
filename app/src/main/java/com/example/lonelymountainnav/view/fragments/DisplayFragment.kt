package com.example.lonelymountainnav.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lonelymountainnav.adapters.UserAdapter
import com.example.lonelymountainnav.databinding.FragmentDisplayBinding
import com.example.lonelymountainnav.viewmodel.FormViewModel

class DisplayFragment:Fragment() {

    private var _binding: FragmentDisplayBinding? = null
    private val binding: FragmentDisplayBinding get() = _binding!!
    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FormViewModel::class.java]
        with(binding) {
           viewModel.users.observe(viewLifecycleOwner){ users ->
               displayRv.apply{
                   adapter = UserAdapter(users)
                   layoutManager =
                       LinearLayoutManager(requireContext())
               }
           }

            backBtn.setOnClickListener{

                val directions =
                    DisplayFragmentDirections.actionDisplayFragmentToNameFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}