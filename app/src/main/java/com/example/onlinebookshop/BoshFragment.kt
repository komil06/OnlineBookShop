package com.example.onlinebookshop

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlinebookshop.Book.BookApi
import com.example.onlinebookshop.adapter.BookAdapter
import com.example.onlinebookshop.adapter.CategoryAdapter
import com.example.onlinebookshop.databinding.FragmentBoshBinding
import com.example.onlinebookshop.model.Book
import com.example.onlinebookshop.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class BoshFragment : Fragment() {

    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBoshBinding.inflate(inflater,container,false)

        val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()

        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }


        var booksJson = shared.getString("books", null)
         books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)
//        setGenresUi()



        binding.filter.setOnClickListener {
            findNavController().navigate(R.id.action_boshFragment_to_filterFragment)
        }

       binding.romanRV.adapter = BookAdapter(books,R.layout.roman_item,requireContext())
       binding.romanRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

       binding.darslikRV.adapter = BookAdapter(books,R.layout.darslik_item,requireContext())
       binding.darslikRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        var checkedString = shared.getString("radioCheckedText", null)
        var isFilter = shared.getBoolean("isFilter", false)

        var romance = shared.getBoolean("romance", false)
        var thriller = shared.getBoolean("thriller", false)
        var action = shared.getBoolean("action", false)




        if (isFilter) {
            var filterBooks = books
            if (checkedString == "4.5+") filterBooks = books.filter { it.rating >= 4.5 } as ArrayList<Book>
            if (checkedString == "4.0+") filterBooks = books.filter { it.rating >= 4.0 } as ArrayList<Book>
            if (romance || thriller || action) {
                if (!romance) filterBooks.removeAll { it.genreName == "Romance" }
                if (!thriller) filterBooks.removeAll { it.genreName == "Thriller" }
                if (!action) filterBooks.removeAll { it.genreName == "Action" }
            }


        }






         fun getGenres(): ArrayList<Category> {
            var genres = ArrayList<Category>()
            genres.add(Category("Romance"))
            genres.add(Category("Thriller"))
            genres.add(Category("Action"))
            return genres
        }

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search ->{
                    findNavController().navigate(R.id.action_boshFragment_to_searchFragment)
                }
                else -> {
                    false
                }
            }
            true
        }

        return binding.root
    }


}