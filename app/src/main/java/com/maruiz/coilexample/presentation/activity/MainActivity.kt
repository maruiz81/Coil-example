package com.maruiz.coilexample.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.maruiz.coilexample.R
import com.maruiz.coilexample.presentation.adapter.BooksAdapter
import com.maruiz.coilexample.presentation.viewmodel.BooksViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val booksViewModel: BooksViewModel by inject()
    private val adapter: BooksAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()

        booksViewModel.observeBooks().observe(this, Observer {
            it?.let {
                adapter.renderables = it
            }
        })
        booksViewModel.observeFailure().observe(this, Observer {
            Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show()
        })
        booksViewModel.getBooks()
    }

    private fun setupRecycler() {
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }
}
