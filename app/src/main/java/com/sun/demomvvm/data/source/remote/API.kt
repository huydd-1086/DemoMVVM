package com.sun.demomvvm.data.source.remote

import com.sun.demomvvm.data.model.Product
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface API {
    @GET("products")
    fun getProducts(): Observable<List<Product>>
}
