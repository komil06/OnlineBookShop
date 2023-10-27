package com.example.onlinebookshop.model

data class Product(val id: Int,
                   val name: String,
                   val category: String,
                   val author_name: String,
                   val rating: Double,
                   val images: List<String>)
