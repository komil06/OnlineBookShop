package com.example.onlinebookshop

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.example.onlinebookshop.Book.BookApi
import com.example.onlinebookshop.adapter.BookAdapter
import com.example.onlinebookshop.databinding.FragmentSearchBinding
import com.example.onlinebookshop.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SearchFragment : Fragment() {
    lateinit var books: ArrayList<Book>
    val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
    val gson = Gson()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentSearchBinding.inflate(inflater, container, false)
        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }

        var booksJson = shared.getString("books", null)
        books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)

        binding.searchRV.adapter = BookAdapter(books.filter { it.isWish } as ArrayList<Book>, R.layout.roman_item, requireContext())


        binding.editText.addTextChangedListener {
            if (binding.editText.text.toString().isNotEmpty()) {
                var filterBooks: ArrayList<Book> = ArrayList()
                for (i in books) {
                    if (i.name.lowercase().trim()
                            .contains(binding.editText.text.toString().lowercase().trim())
                    ) {
                        filterBooks.add(i)
                    }
                }

            }
        }
        binding.editText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.editText.clearFocus()
            }
            false
        }
        return binding.root

    }
}