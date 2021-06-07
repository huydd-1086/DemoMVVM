package com.sun.demomvvm.di

import androidx.room.Room
import com.sun.demomvvm.data.repository.ProductRepository
import com.sun.demomvvm.data.repository.ProductRepositoryImpl
import com.sun.demomvvm.data.source.ProductDataSource
import com.sun.demomvvm.data.source.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.sun.demomvvm.data.source.local.AppDatabase.Companion.DATABASE_NAME
import com.sun.demomvvm.data.source.local.ProductLocalDataSource
import com.sun.demomvvm.data.source.remote.ProductRemoteDataSource

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().productDAO() }
}

val repositoryProductModule = module {
    single<ProductDataSource.Remote> { ProductRemoteDataSource(get()) }
    single<ProductDataSource.Local> { ProductLocalDataSource(get()) }
    single<ProductRepository> {ProductRepositoryImpl(get(), get())}
}
