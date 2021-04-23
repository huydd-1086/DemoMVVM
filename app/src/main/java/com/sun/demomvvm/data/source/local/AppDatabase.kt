package com.sun.demomvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.data.source.local.AppDatabase.Companion.DATABASE_VERSION
import com.sun.demomvvm.data.source.local.AppDatabase.Companion.EXPORT_SCHEME
import com.sun.demomvvm.data.source.local.dao.ProductDAO

@Database(
    entities = [Product::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDAO() : ProductDAO

    companion object {
        const val DATABASE_NAME = "ProductDB"
        const val DATABASE_VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
