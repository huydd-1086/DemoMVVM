package com.sun.demomvvm.di

import com.sun.demomvvm.ui.detail.DetailViewModel
import com.sun.demomvvm.ui.favorite.FavoriteViewModel
import com.sun.demomvvm.ui.product.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}
