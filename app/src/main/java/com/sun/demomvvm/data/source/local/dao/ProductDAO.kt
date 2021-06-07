package com.sun.demomvvm.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sun.demomvvm.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ProductDAO {
    @Query("SELECT * FROM FavoriteProduct")
    fun getFavoriteProduct(): Observable<List<Product>>

    @Insert
    fun insertFavoriteProduct(product: Product): Completable

    @Delete
    fun deleteFavoriteProduct(product: Product): Completable

    @Query("SELECT * FROM FavoriteProduct WHERE id = :id")
    fun isFavorite(id: String): Single<List<Product>>
}
