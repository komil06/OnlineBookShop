package com.example.onlinebookshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.example.onlinebookshop.databinding.FragmentBookDetailAudioBinding


class BookDetailAudioFragment : Fragment() {
    var progressBar:ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookDetailAudioBinding.inflate(inflater,container,false)



        findNavController().navigate(R.id.action_bookDetailAudioFragment_to_bookDetailFragment)
        return binding.root
    }



}