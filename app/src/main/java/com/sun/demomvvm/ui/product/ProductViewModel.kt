package com.sun.demomvvm.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _products = MutableLiveData<List<Product>>()
    private val _error = MutableLiveData<String>()
    val products: LiveData<List<Product>>
        get() = _products
    val error: LiveData<String>
        get() = _error

    init {
        getProducts()
    }

    private fun getProducts() {
        repository.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _products.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
