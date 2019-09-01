package com.maruiz.koinexample.domain.usecase

import arrow.core.Either
import arrow.core.None
import com.maruiz.koinexample.data.api.BookApi
import com.maruiz.koinexample.data.error.Failure
import com.maruiz.koinexample.data.extensions.makeRequest
import com.maruiz.koinexample.data.model.BookModel

class GetBooks(private val bookApi: BookApi) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> =
        bookApi.getBooks().makeRequest().map { it ?: emptyList() }
}
