package com.example.omar_salem.kotlinoverview.ui
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.omar_salem.kotlinoverview.R
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(), ScreenView {

    lateinit var presenter: ScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ScreenPresenter(this)
        rv_Books.setHasFixedSize(true)
        rv_Books.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> presenter.fetchBooksFromApis(et_SearchKey_id.text.toString(), this@MainActivity, rv_Books)

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccess() {
        Toast.makeText(this@MainActivity, "Thanks ", Toast.LENGTH_SHORT).show()
    }

    override fun onError() {
        Toast.makeText(this@MainActivity, "Error : please check you Network ", Toast.LENGTH_SHORT).show()
    }

    override fun onEmptyText() {
        Toast.makeText(this@MainActivity, "Please enter your books type", Toast.LENGTH_SHORT).show()
    }

}
