package com.example.onlinebookshop.model

data class Book(var name: String,
           var author: String,
           var pages: Int,
           var description: String,
           var rating: Double,
           var size: String,
           var price: String,
           var img: Int,
           var genreName: String,
           var isSaved: Boolean = false,
           var isWish: Boolean = false,)