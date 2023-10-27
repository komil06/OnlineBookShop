package com.example.onlinebookshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onlinebookshop.databinding.FragmentSearchBinding
import com.example.onlinebookshop.model.Book


class SearchFragment : Fragment() {
    lateinit var books: ArrayList<Book>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding  = FragmentSearchBinding.inflate(inflater,container,false)

        binding.searchView2.setOnSearchClickListener{
            if (binding.searchView2.toString().isNotEmpty()) {
                var filterBooks: ArrayList<Book> = ArrayList()
                for (i in books) {
                    if (i.name.lowercase().trim()
                            .contains(binding.searchView2.toString().lowercase().trim())
                    ) {
                        filterBooks.add(i)
                    }
                }

            }
        }

        return binding.root
    }


}