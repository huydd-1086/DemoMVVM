package com.sun.demomvvm.data.repository

import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImpl(
    private val remote: ProductDataSource.Remote,
    private val local: ProductDataSource.Local
) : ProductRepository {

    override fun getProducts(): Observable<List<Product>> = remote.getProducts()

    override fun getFavoriteProducts(): Observable<List<Product>> = local.getFavoriteProducts()

    override fun insertFavoriteProduct(product: Product): Completable =
        local.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product): Completable =
        local.deleteFavoriteProduct(product)

    override fun isFavorite(id: String): Single<Boolean> = local.isFavorite(id)
}
