package com.example.onlinebookshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinebookshop.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_registerFragment)
        }
        binding.kirish.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_boshFragment)
        }
        return binding.root
    }

}