package com.sun.demomvvm.data.source.remote

import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.source.ProductDataSource
import io.reactivex.rxjava3.core.Observable

class ProductRemoteDataSource(
    private val api: API
) : ProductDataSource.Remote {

    override fun getProducts(): Observable<List<Product>> = api.getProducts()
}
