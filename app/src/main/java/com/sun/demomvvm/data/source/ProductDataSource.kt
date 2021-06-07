package com.sun.demomvvm.data.source

import com.sun.demomvvm.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {
    interface Remote {
        fun getProducts(): Observable<List<Product>>
    }

    interface Local {
        fun getFavoriteProducts(): Observable<List<Product>>
        fun insertFavoriteProduct(product: Product): Completable
        fun deleteFavoriteProduct(product: Product): Completable
        fun isFavorite(id: String): Single<Boolean>
    }
}
