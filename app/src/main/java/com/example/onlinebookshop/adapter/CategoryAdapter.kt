package com.example.onlinebookshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebookshop.R
import com.example.onlinebookshop.model.Category

class CategoryAdapter(var list: MutableList<Category>):
    RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    class CategoryHolder(itemView: View):RecyclerView.ViewHolder(itemView){
          var name:TextView = itemView.findViewById(R.id.book_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryHolder {
        val holder = CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.seach_item,parent,false))
        return holder
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryHolder, position: Int) {
        var item = list[position]
        holder.name.text = item.name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}