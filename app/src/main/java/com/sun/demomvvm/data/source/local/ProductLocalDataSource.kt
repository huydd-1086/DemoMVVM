package com.sun.demomvvm.data.source.local

import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.source.ProductDataSource
import com.sun.demomvvm.data.source.local.dao.ProductDAO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class ProductLocalDataSource(
    private val productDAO: ProductDAO
) : ProductDataSource.Local {

    override fun getFavoriteProducts(): Observable<List<Product>> = productDAO.getFavoriteProduct()

    override fun insertFavoriteProduct(product: Product): Completable =
        productDAO.insertFavoriteProduct(product)

    override fun deleteFavoriteProduct(product: Product): Completable =
        productDAO.deleteFavoriteProduct(product)

    override fun isFavorite(id: String): Single<Boolean> =
        productDAO.isFavorite(id).map { it.isNotEmpty() }
}
