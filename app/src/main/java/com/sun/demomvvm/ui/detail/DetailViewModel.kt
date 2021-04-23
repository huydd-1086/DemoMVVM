package com.sun.demomvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _isFavorite = MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite
    val error: LiveData<String>
        get() = _error

    fun checkFavorite(id: String) {
        repository.isFavorite(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    private fun insertFavoriteProduct(product: Product) {
        repository.insertFavoriteProduct(product)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = true
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    private fun deleteFavoriteProduct(product: Product) {
        repository.deleteFavoriteProduct(product)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = false
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposable)
    }

    fun setFavorite(product: Product) {
        if (isFavorite.value == true) {
            deleteFavoriteProduct(product)
        } else {
            insertFavoriteProduct(product)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
