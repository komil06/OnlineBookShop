package com.example.onlinebookshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinebookshop.R
import com.example.onlinebookshop.model.Book
import com.google.android.material.imageview.ShapeableImageView

class BookAdapter(
    var books: ArrayList<Book>,
    var itemLayout: Int = R.layout.roman_item,
    var context: Context,
    private var myInterface: MyInterface = object : MyInterface {
        override fun onItemTap(book: Book) {}
    }
) : RecyclerView.Adapter<BookAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.book_name)
        var img = itemView.findViewById<ShapeableImageView>(R.id.book_img)
        var rating = itemView.findViewById<TextView>(R.id.star_rate)
    }

    interface MyInterface {
        fun onItemTap(book: Book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var book = books[position]
        holder.name.text = book.name
        holder.img.setImageResource(book.img)
        holder.rating.text = book.rating.toString()

        val anim = AnimationUtils.loadAnimation(context, R.anim.item_anim)
        holder.itemView.startAnimation(anim)

        holder.itemView.setOnClickListener {
            myInterface.onItemTap(book)
        }
    }
}