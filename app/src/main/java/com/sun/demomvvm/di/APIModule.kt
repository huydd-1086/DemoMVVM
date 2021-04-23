package com.sun.demomvvm.di

import com.sun.demomvvm.data.source.remote.API
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(API::class.java) }
}
