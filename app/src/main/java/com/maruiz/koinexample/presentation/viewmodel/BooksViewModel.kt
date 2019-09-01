package com.maruiz.koinexample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import arrow.core.None
import com.maruiz.koinexample.data.model.BookModel
import com.maruiz.koinexample.domain.usecase.GetBooks
import com.maruiz.koinexample.presentation.presentationmodel.BookPresentationModel

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {
    private val books = MutableLiveData<List<BookPresentationModel>>()

    fun observeBooks(): LiveData<List<BookPresentationModel>> = books

    fun getBooks() = getBooks(None) { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookModel>) {
        this.books.value = books.map { BookPresentationModel(it.image) }
    }

    override fun cancelRequest() {
        getBooks.cancel()
    }
}