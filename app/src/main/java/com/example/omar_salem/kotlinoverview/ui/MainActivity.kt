package com.example.omar_salem.kotlinoverview.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import com.example.omar_salem.kotlinoverview.Adapter.BookAdapter
import com.example.omar_salem.kotlinoverview.R
import com.example.omar_salem.kotlinoverview.Retrofit.GoogleBooksApi
import com.example.omar_salem.kotlinoverview.Retrofit.RetrofitClient
import com.example.omar_salem.kotlinoverview.model.BookDetails
import com.example.omar_salem.kotlinoverview.model.BooksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var Search :EditText
    lateinit var BookRecyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         Search = findViewById(R.id.et_SearchKey_id)as EditText
         BookRecyclerView=findViewById(R.id.rv_Books) as RecyclerView
        BookRecyclerView.setHasFixedSize(true)
        BookRecyclerView.layoutManager= LinearLayoutManager(this)

    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId)
        {

                R.id.action_search ->  FetchBooksFromApis(Search.text.toString())

        }
        return super.onOptionsItemSelected(item)
    }
    fun FetchBooksFromApis(Key:String) {

        if (Key.isEmpty() ) {
            Toast.makeText(this@MainActivity, "Please Type Your Word  ", Toast.LENGTH_SHORT).show()
        } else{
        val getclient = RetrofitClient()
        val loadingFromServer = getclient.clint.create(GoogleBooksApi::class.java)
        val MakeCallFromServer = loadingFromServer.getBooks(Key)
        MakeCallFromServer.enqueue(object : Callback<BooksResponse> {
            override fun onResponse(call: Call<BooksResponse>?, response: Response<BooksResponse>) {
                val booksitems = response.body()!!.allItems!!
                BookRecyclerView.adapter = BookAdapter(booksitems!!, this@MainActivity)
                Toast.makeText(this@MainActivity, "Thanks ", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BooksResponse>?, t: Throwable) {
                Log.d("Error ", t.message)
                Toast.makeText(this@MainActivity, "Error : please check you Network ", Toast.LENGTH_SHORT).show()


            }
        })
    }

    }
}
