package com.example.omar_salem.kotlinoverview.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.omar_salem.kotlinoverview.Adapter.BookAdapter
import com.example.omar_salem.kotlinoverview.Retrofit.GoogleBooksApi
import com.example.omar_salem.kotlinoverview.Retrofit.RetrofitClient
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult

/**
 * TODO: Add class header
 */
class ScreenPresenter(private val screenView: ScreenView) {

    fun fetchBooksFromApis(Key: String, mContext: Context, bookRecyclerView: RecyclerView) = launch(UI) {

        if (Key.isEmpty()) {
         screenView.onEmptyText()
        } else {
            val getClient = RetrofitClient()
           val loadingFromServer = getClient.clint.create(GoogleBooksApi::class.java)
            val makeCallFromServer = loadingFromServer.getBooks(Key).awaitResult()
            when (makeCallFromServer) {
                is Result.Ok -> {
                    val apiItems = makeCallFromServer.value
                    val responseApi = apiItems.allItems
                    bookRecyclerView.adapter = BookAdapter(responseApi, mContext)
                    screenView.onSuccess()
                }
                is Result.Error -> {
                    screenView.onError()
                }
            }
        }
    }
}