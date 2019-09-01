package com.maruiz.koinexample.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maruiz.koinexample.data.error.Failure

abstract class BaseViewModel : ViewModel() {

    private val failure: MutableLiveData<Failure> = MutableLiveData()

    fun observeFailure(): LiveData<Failure> = failure

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }

    override fun onCleared() {
        super.onCleared()
        cancelRequest()
    }

    abstract fun cancelRequest()
}