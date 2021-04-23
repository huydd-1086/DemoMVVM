package com.sun.demomvvm.data.repository

import com.sun.demomvvm.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductRepository {
    fun getProducts(): Observable<List<Product>>
    fun getFavoriteProducts(): Observable<List<Product>>
    fun insertFavoriteProduct(product: Product): Completable
    fun deleteFavoriteProduct(product: Product): Completable
    fun isFavorite(id: String): Single<Boolean>
}
