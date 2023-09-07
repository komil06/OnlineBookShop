package com.example.onlinebookshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinebookshop.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = FragmentRegisterBinding.inflate(inflater,container, false)
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_secondFragment)
        }
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_boshFragment)
        }
        return binding.root
    }


}