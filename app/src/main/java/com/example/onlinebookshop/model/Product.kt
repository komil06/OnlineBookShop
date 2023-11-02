package com.example.onlinebookshop.model

data class Product(val name: String,
                   val category: String,
                   val author_name: String,
                   val rating: Double,
                   val images: List<String>)
