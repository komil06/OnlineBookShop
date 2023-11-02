package com.example.onlinebookshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinebookshop.databinding.FragmentBookDetailBinding

class BookDetailFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookDetailBinding.inflate(inflater,container,false)

        binding.audio.setOnClickListener {
          findNavController().navigate(R.id.action_bookDetailFragment_to_bookDetailAudioFragment)
        }
        return binding.root
    }


}