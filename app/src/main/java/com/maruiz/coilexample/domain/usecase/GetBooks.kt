package com.maruiz.coilexample.domain.usecase

import arrow.core.Either
import arrow.core.None
import com.maruiz.coilexample.data.api.BookApi
import com.maruiz.coilexample.data.error.Failure
import com.maruiz.coilexample.data.extensions.makeRequest
import com.maruiz.coilexample.data.model.BookModel

class GetBooks(private val bookApi: BookApi) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> =
        bookApi.getBooks().makeRequest().map { it ?: emptyList() }
}
