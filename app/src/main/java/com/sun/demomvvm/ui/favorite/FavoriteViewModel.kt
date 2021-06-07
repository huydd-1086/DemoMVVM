package com.sun.demomvvm.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _products = MutableLiveData<List<Product>>()
    private val _error = MutableLiveData<String>()
    val products: MutableLiveData<List<Product>>
        get() = _products
    val error: MutableLiveData<String>
        get() = _error

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        repository.getFavoriteProducts()
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
