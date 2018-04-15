package com.example.omar_salem.kotlinoverview.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.omar_salem.kotlinoverview.R
import com.example.omar_salem.kotlinoverview.model.AllBooks

import com.example.omar_salem.kotlinoverview.model.BookDetails
import java.util.ArrayList

/**
 * TODO: Add class header
 */
class BookAdapter(private val bookDetailList:ArrayList<AllBooks> ,private val mContext:Context): RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: BookAdapter.MyViewHolder?, position: Int) {
        with(bookDetailList[position]) {
            holder?.Tittle?.text = items!!.BookTittle
            holder?.Publisher?.text = items.BookPublisher
            holder?.publishedDate?.text = items.publishedDate
            Glide.with(mContext)
                    .load(items.BookImage?.NormalImage)
                    .into(holder?.Image!!)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val BookView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.card_view_book, parent, false)
        return MyViewHolder(BookView)

    }

    override fun getItemCount(): Int {
      return bookDetailList.size
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var Image:ImageView? = null
        var Tittle: TextView?= null
        var Publisher: TextView?= null
        var publishedDate: TextView?= null
        init {
            with(itemView) {
                Image = this?.findViewById(R.id.iv_book) as ImageView
                Tittle = this.findViewById(R.id.tv_book_tittle) as TextView
                Publisher = this.findViewById(R.id.tv_book_publisher) as TextView
                publishedDate = this.findViewById(R.id.tv_publishedDate) as TextView
            }
        }



    }
}